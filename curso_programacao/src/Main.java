
public class Main {

	public static void main(String[] args) {
		
		int n = 5;
		int i;
		long fat, f;

		System.out.println("Letra b");
		fat = 1;		
		for(i = n; i >= 1; i--) {
			fat = fat * i;
		}
		System.out.println(fat);			

		System.out.println("Letra c");
		fat = 0;
		for(i = n; i >= 1; i--) {
			fat = fat * i;
		}
		System.out.println(fat);				

		System.out.println("Letra d");
		f = 1;
		long prod;
		for(i = 1; i <= n; i++) {
			prod = f * i;
			f = prod;
		}
		System.out.println(f);
	}

}
