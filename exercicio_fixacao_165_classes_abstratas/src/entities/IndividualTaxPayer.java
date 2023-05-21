package entities;

public class IndividualTaxPayer extends TaxPayer {

	private Double healthExpenditures;
	
	public IndividualTaxPayer() {
		super();
	}

	public IndividualTaxPayer(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	public Double tax() {
		Double sum = 0.0;
		
		if (super.getAnualIncome() < 20000.00) {
			sum = super.getAnualIncome() * 0.15;
		} else {
			sum = super.getAnualIncome() * 0.25;
		}
		
		if (healthExpenditures > 0) {
			sum -= healthExpenditures * 0.5;
		}
		
		return sum;
	}
}
