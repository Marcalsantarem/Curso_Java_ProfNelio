import java.util.Scanner;

public class TesteGeral {

	public static void main(String args[]){

		Arquivo a = new Arquivo(1);
		ArquivoBinario ab = new ArquivoBinario(1);
		ArquivoTexto at = new ArquivoTexto(1, 1);
		
		a.mB();
		ab.mB();
		at.mB();
		
	}	
}
