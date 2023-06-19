package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService payPalService;
	
	public void processContract(Contract contract, Integer months) {
		
		List<Installment> installments = new ArrayList<>();
		Double total = contract.getTotalValue();
		LocalDate date = contract.getDate();
		
		for (int i = 1; i <= months; i++) {
			total = payPalService.interest(contract.getTotalValue(), i) + payPalService.paymentFee(contract.getTotalValue());
			date.plusMonths(i);
			Installment installment = new Installment(date, total);
			installments.add(installment);
			contract.setInstallments(installments);
		}
	}
}
