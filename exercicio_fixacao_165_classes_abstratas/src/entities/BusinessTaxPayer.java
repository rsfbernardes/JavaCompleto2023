package entities;

public class BusinessTaxPayer extends TaxPayer {

	private Integer numberOfEmployees;
	
	public BusinessTaxPayer(){
		super();
	}

	public BusinessTaxPayer(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	public Double tax() {
		Double sum = 0.0;
		
		if (numberOfEmployees > 10) {
			sum = super.getAnualIncome() * 0.14;
		} else {
			sum = super.getAnualIncome() * 0.16;
		}
		
		return sum;
	}
}
