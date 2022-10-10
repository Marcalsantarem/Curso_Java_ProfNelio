package application;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.*;

public class App {

	public static void main(String[] args) {
		
		List<Contribuinte> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: " );
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.printf("Tax payer #" + (i + 1) + " data:", Font.BOLD);
			System.out.print("\nIndividual or company (i/c)? ");
			char ch = sc.nextLine().charAt(0);
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Anual Income: ");
			double rendaAnual = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				list.add(new ContribuinteFisico(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Number of employees: ");
				int funcionarios = sc.nextInt();
				list.add(new ContribuinteJuridico(nome, rendaAnual, funcionarios));
			}			
		}
		
		double total = 0;
		System.out.println("\nTAXES PAID:");
		for(Contribuinte c : list) {
			System.out.println(c.toString());
			total += c.calculaImposto();
		}
		
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", total));
		
		sc.close();

	}

}
