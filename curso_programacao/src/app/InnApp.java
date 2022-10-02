package app;

import java.util.Scanner;

import entities.Rent;

public class InnApp {

	public static void main(String[] args) {
		
		Rent[] rooms = new Rent[10];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("\nRent #" + (i+1) + ":");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			rooms[room] = new Rent(name, email);
		}
		
		System.out.println("\n\nBusy rooms:");
		for(int i = 0; i < rooms.length; i++) {
			if(rooms[i] != null) {
				System.out.printf("%d: %s, %s%n", i, rooms[i].getName(), rooms[i].getEmail());				
			}
		}		
		
		sc.close();
		
	}

}
