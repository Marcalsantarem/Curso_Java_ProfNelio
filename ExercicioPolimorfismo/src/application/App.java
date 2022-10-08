package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.nextLine().charAt(0);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			switch (ch) {
			case 'c':
				list.add(new Product(name, price));
				continue;
			case 'u':
				sc.nextLine();
				System.out.print("Manufacture date (DD/MM/YYYY) ");
				String manufactureDate = sc.nextLine();
				list.add(new UsedProduct(name, price, LocalDate.parse(manufactureDate, fmt1)));
				continue;
			case 'i':
				sc.nextLine();
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
				continue;
			}	
		}
		System.out.println("\nPRICE TAGS:");
		
		for (Product p : list) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}

}
