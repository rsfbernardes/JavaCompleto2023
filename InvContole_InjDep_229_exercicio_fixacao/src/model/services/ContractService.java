package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		List<Installment> installments = new ArrayList<>();
		Double total = 0d;
		LocalDate date = contract.getDate();
		
		for (int i = 1; i <= months; i++) {
			Double totalInterest = onlinePaymentService.interest(contract.getTotalValue()/months, i);
			Double totalPaymentFee = onlinePaymentService.paymentFee(totalInterest);
			total = totalInterest + totalPaymentFee;
			date = date.plusMonths(i);
			Installment installment = new Installment(date, total);
			installments.add(installment);
			contract.setInstallments(installments);
			date = contract.getDate();
		}
	}
}
