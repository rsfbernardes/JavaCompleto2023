package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdfBirthDate = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data!");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String clientBirthDate = sc.nextLine();
		
		Client client = new Client(clientName, clientEmail, sdfBirthDate.parse(clientBirthDate));
		
		System.out.println("Enter order data!");
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();

		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		for (int i = 1; i <= items; i++) {
			System.out.println();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addOrderItem(orderItem);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
	}
}
