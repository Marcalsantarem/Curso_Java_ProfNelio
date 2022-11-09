import java.util.Date;

public class Arquivo {
	
	private int t;
	private String loc;
	private Date d;
	
	public Arquivo(int x) {
		this.t = x;
	}
	
	public int mA() {
		System.out.println("mA do Arquivo");
		return 1;
	}
	
	public void mB() {
		System.out.println("mB do Arquivo");
	}
}
