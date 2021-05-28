package ut.set.sn.modeles;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity

public class OrderItem {

	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    private Produit product;
	    private int quantity;
	    private double price;
	    @ManyToOne
	    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	    private Order order;
	

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Produit getProduct() {
		return product;
	}


	public void setProduct(Produit product) {
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


	public void setPrice(double price) {
		this.price = price;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}
  
}
