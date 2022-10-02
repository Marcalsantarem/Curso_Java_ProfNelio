package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

public class SalaryApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Employee> empList = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		System.out.println();
		for(int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			System.out.println();
			empList.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int idInc = sc.nextInt();
		sc.nextLine();
		
		Employee empAux = 
				empList.stream().filter(x -> x.getId() == idInc).findFirst().orElse(null);

		if(empAux != null){
			System.out.print("Enter the percentage: ");
			empAux.increaseSalary(sc.nextDouble());	
		} else {	
			System.out.println("This id does not exist!");
		}		
		
		System.out.println("\nList of employees:");
		for(Employee e : empList) {
			System.out.printf("%d, %s, %.2f%n", e.getId(), e.getName(), e.getSalary());
		}		
		
		sc.close();
	}

}
