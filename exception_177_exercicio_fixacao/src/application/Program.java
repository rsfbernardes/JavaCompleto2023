package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		Account account = new Account(number, holder, initialBalance, withdrawLimit);
		System.out.println();
		System.out.print("Enter amount of for withdraw: ");
		Double withdraw = sc.nextDouble();
		account.withdraw(withdraw);
		System.out.println("New balance: " + account.getBalance());
		}
		catch (DomainException e){
			System.out.println("Withdraw error: " + e.getMessage());
		}

		sc.close();
	}
}
