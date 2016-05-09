package com.shopping.cart;


public class Item {
    private String name;
    private int quantity;
    private double price;

    private Shopping shopping;

    public Shopping getShoppingCart() {
        return shopping;
    }

    public void setShoppingCart(Shopping shopping) {
        this.shopping = shopping;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setPrice(String price) {
		String[] y=price.split("£");
		String part=y[1];
		double x = Double.parseDouble(part);
		this.price = x;
	}
	
}
