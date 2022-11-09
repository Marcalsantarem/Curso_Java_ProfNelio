
public class ArquivoTexto extends Arquivo {
	
	private int x;
	
	public ArquivoTexto(int a, int b) {
		super(a);
		this.x = b;
	}
	
	public int mA() {
		System.out.println("mA do ArquivoTexto");
		return 1;
	}
	
	public void mB() {
		System.out.println("mB do ArquivoTexto");
	}
	
	public void mC() {
		System.out.println("mC do ArquivoTexto");
	}

}
