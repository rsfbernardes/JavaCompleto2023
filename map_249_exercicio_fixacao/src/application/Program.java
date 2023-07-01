package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new LinkedHashMap<>();
		Integer sum;
		
		System.out.print("Enter file full path: ");
		
		try (BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
			
			String votesCsv = br.readLine();
			while(votesCsv != null) {
				String[] fields = votesCsv.split(",");
				if(!votes.containsKey(fields[0])) {
					votes.put(fields[0], Integer.valueOf(fields[1]));
					votesCsv = br.readLine();
				}
				else {
					sum = votes.get(fields[0]) + Integer.valueOf(fields[1]);
					votes.put(fields[0], sum);
					votesCsv = br.readLine();
				}
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getLocalizedMessage());
		}
		
		for (String key : votes.keySet()) {
			System.out.println(key + ": " + votes.get(key));
		}
		
		sc.close();
	}
}
