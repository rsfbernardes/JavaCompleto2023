package model.services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public Double paymentFee(Double amount) {
		
		Double fee = 0.02;		
		return fee*amount;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		
		Double interest = 0.01;
		
		return amount * interest * months;
	}

}
