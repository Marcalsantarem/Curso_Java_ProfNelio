package service;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		double valorParcela = (double)contract.getTotalValue() / months;
		LocalDate dataInicial = contract.getDate();
		
		for (int n = 1; n <= months; n++) {			

			LocalDate dataParcela = dataInicial.plusMonths(n);
			double juro = onlinePaymentService.interest(valorParcela, n);
			double taxa = onlinePaymentService.paymentFee(valorParcela + juro);
			double valorFinalParcela = valorParcela + juro + taxa;
			
			Installment parcela = new Installment(dataParcela, valorFinalParcela, contract);
			contract.addInstalment(parcela);
		}
	}	
}
