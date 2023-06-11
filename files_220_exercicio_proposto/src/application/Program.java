package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException{

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		System.out.println(sourceFolderStr);

		boolean success = new File(sourceFolderStr + "/out").mkdir();
		
		System.out.println("Created folder: " + success);

		String targetFileStr = sourceFolderStr + "/out/summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {
				
				String[] sales = itemCsv.split(",");
				String name = sales[0];
				double value = Double.parseDouble(sales[1]);
				int quantity = Integer.parseInt(sales[2]);
				
				list.add(new Product(name, value, quantity));
				
				itemCsv = br.readLine();
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){
				
				for (Product product : list) {
					bw.write(product.getName() + "," + String.format("%.2f", product.Total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + " CREATED");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		sc.close();
	}

}
