package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.GenericException;

public class App {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {			
			System.out.printf("Enter account data");
			System.out.print("\nNumber: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();			
			Account acc = new Account(number, holder, balance, withdrawLimit);			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));			
		} catch (GenericException e) {
			System.out.println("Withdraw error: " + e.getMessage());			
		} finally {
			sc.close();			
		}
	}
}
