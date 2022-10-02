package entities;

public class Rent {
	
	private String name;
	private String email;
	
	public Rent(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}

}
