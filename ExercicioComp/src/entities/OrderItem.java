package entities;

public class OrderItem {
	
	private int quantity;
	private double price;
	
	private Product product;

	public OrderItem(int quantity, Product product) {
		this.quantity = quantity;
		this.price = product.getPrice();
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		this.price = product.getPrice();
	}
	
	public double subTotal() {
		return this.quantity * this.price;
	}

	@Override
	public String toString() {
		return product.getName() + ", $"
				                 + String.format("%.2f", price)
				                 + ", Quantity: "
				                 + quantity
				                 + ", Subtotal: $"
				                 + String.format("%.2f", subTotal())
				                 + "\n";
	}
}
