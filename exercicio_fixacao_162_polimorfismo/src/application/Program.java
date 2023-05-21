package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			sc.nextLine();
			System.out.print("Commom, used or imported (c/u/i)? ");
			char ch = sc.nextLine().charAt(0);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Customs fee: ");
				Double fee = sc.nextDouble();
				Product p = new ImportedProduct(name, price, fee);
				list.add(p);
			}
			else if(ch == 'u') {
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			}
			else {
				Product p = new Product(name, price);
				list.add(p);
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS");
		for (Product p : list) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}
}
