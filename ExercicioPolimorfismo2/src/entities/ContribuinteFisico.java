package entities;

public class ContribuinteFisico extends Contribuinte {
	
	private Double gastosSaude;	

	public ContribuinteFisico(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}
	
	public Double getGastosSaude() {
		return gastosSaude;
	}
	
	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public Double calculaImposto() {
		double tax = 0.15;		
		if(this.rendaAnual >= 20000.00) {
			tax = 0.25;
		}
		return (rendaAnual * tax) - (gastosSaude * 0.50);
	}
}
