package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		System.out.print("Enter salary: ");
		Double salary = sc.nextDouble();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String employeesCsv = br.readLine();
			while (employeesCsv != null) {
				String[] fields = employeesCsv.split(",");
				Employee employee = new Employee(fields[0], fields[1], Double.valueOf(fields[2]));
				employees.add(employee);
				employeesCsv = br.readLine();
			}

			List<String> emails = new ArrayList<>();
			emails = employees.stream()
			.filter(x -> x.getSalary() > salary)
			.map(x -> x.getEmail())
			.sorted()
			.collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
			
			emails.forEach(System.out::println);
			
			Double sum = employees.stream()
					.filter(x -> x.getName().charAt(0) == 'M')
					.map(x -> x.getSalary())
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));

		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}
