package ut.set.sn.controller;

import java.util.ArrayList;
import java.util.List;

import ut.set.sn.modeles.Client;

public class OrderForm {
    private Client client=new Client();
    private List<OrderProduct> products=new ArrayList<>();
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<OrderProduct> getProducts() {
		return products;
	}
	public void setProducts(List<OrderProduct> products) {
		this.products = products;
	}
    
}
class OrderProduct{
    private Long id;
    private int quantity;
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}

