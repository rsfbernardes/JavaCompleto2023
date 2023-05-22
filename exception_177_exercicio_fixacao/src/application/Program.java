package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
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
		System.out.println("New balance: " + account.withdraw(withdraw));
		}
		catch (exception e){
			
		}

		sc.close();
	}
}
