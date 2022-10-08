package app;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String birthDate = sc.nextLine();
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localdate = LocalDate.parse(birthDate, fmt1);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();		
		Order order = new Order(Instant.now(), OrderStatus.valueOf(status), new Client(name, email, localdate));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			sc.nextLine();
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			OrderItem item = new OrderItem(quantity, new Product(productName, price));
			order.addItem(item);
		}
		
		System.out.println("\nORDER SUMMARY:");	
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
		
		System.out.println("Order moment: " + formato.format(order.getMoment()));
		System.out.println("Order status: " + order.getStatus().toString());
		System.out.printf("Client: %s (%s) - %s\n", order.getClient().getName(),
				                                    order.getClient().getBirthDate().format(fmt1),
				                                    order.getClient().getEmail());
		System.out.println("Order items:");
		for(OrderItem i : order.getItems()) {
			System.out.printf(i.toString());
		}
		System.out.printf("Total price: $%.2f", order.total());		
		
		
		sc.close();
		
	}
	
}
