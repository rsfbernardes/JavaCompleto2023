package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato");
		System.out.print("Numero:");
		Integer number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
		System.out.print("Valor do contrato: ");
		Double totalValue = sc.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		Integer months = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);
		
		ContractService contractService = new ContractService();
		
		contractService.processContract(contract, months);
		
		System.out.println("Parcelas:");
		for (int i = 1; i < months; i++) {
			System.out.println(contract.getInstallments());
		}
		
		sc.close();

	}

}
