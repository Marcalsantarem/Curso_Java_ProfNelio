package entities;

public class ContribuinteJuridico extends Contribuinte {

	private Integer funcionarios;
	
	public ContribuinteJuridico(String nome, Double rendaAnual, Integer funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}	

	public Integer getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Integer funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public Double calculaImposto() {		
		double tax = 0.16;
		if (funcionarios > 10) {
			tax = 0.14;
		}
		return rendaAnual * tax;
	}
}
