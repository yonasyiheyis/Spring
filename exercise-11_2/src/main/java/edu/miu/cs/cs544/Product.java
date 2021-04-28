package edu.miu.cs.cs544;

public class Product {
	
	private int productNumber;
	private String name;
	private double price;
	
	public Product(int pNum, String name, double price) {
		this.setName(name);
		this.setPrice(price);
		this.setProductNumber(pNum);
	}
	
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Product Number= "+ this.getProductNumber()+ ", name= "+ this.getName()+ ", price= "+ this.getPrice();
	}

}
