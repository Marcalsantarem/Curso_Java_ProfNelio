package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

public class Program {
	
	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Número: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		System.out.print("Valor do contrato: ");;
		double totalValue = sc.nextDouble();
		System.out.print("Entre com o numero de parcelas: ");
		int n = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);		
		ContractService service = new ContractService(new PaypalService());		
		service.processContract(contract, n);
		
		System.out.println("Parcelas:");		
		for (Installment ins : contract.getInstalments()) {
			System.out.println(ins.getDueDate().format(fmt) + " - " + String.format("%.2f", ins.getAmount()));
		}
		
		sc.close();
		
	}

}
