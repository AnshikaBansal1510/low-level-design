package DesignPatterns.Structural.Composite;

import java.util.*;

interface CartItem {
	double getPrice();
	void display(String indent);
}

class Product implements CartItem {
	private String name;
	private double price;

	public Product(String name, double price){
		this.name = name;
		this.price = price;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void display(String indent) {
		System.out.println(indent + "Product: " + name + " - Rs." + price);
	}
}

class ProductBundle implements CartItem {
	private String bundleName;
	private List<CartItem> items = new ArrayList<>();

	public ProductBundle(String bundleName){
		this.bundleName = bundleName;
	}

	public void addItem(CartItem item){
		items.add(item);
	}

	@Override
	public double getPrice() {
		double total = 0;
		for(CartItem item : items){
			total += item.getPrice();
		}

		return total;
	}

	@Override
	public void display(String indent) {
		System.out.println(indent + "Bundle: " + bundleName);
		for(CartItem item : items){
			item.display(indent + " ");
		}
	}
}

public class solution {
	public static void main(String[] args) {
		
		// Individual items
		CartItem book = new Product("Atomic habits", 499);
		CartItem phone = new Product("iPhone 15", 79999);
		CartItem earbuds = new Product("airPods", 15999);
		CartItem charger = new Product("20W charger", 1999);

		// bundle : iPhone combo
		ProductBundle iphoneCombo = new ProductBundle("iPhone essentials combo");
		iphoneCombo.addItem(phone);
		iphoneCombo.addItem(charger);
		iphoneCombo.addItem(earbuds);

		// bundle : school kit
		ProductBundle schoolKit = new ProductBundle("Back to school kit");
		schoolKit.addItem(new Product("Notebook Pack", 248));
		schoolKit.addItem(new Product("Pen set", 99));
		schoolKit.addItem(new Product("Highlighter", 149));

		List<CartItem> cart = new ArrayList<>();
		cart.add(book);
		cart.add(iphoneCombo);
		cart.add(schoolKit);

		// Display cart
		System.out.println("Your amazon cart: ");
		double total = 0;

		// structured through an interface
		for(CartItem item : cart){
			item.display(" ");
			total += item.getPrice();
		}

		System.out.println("Total: " + total);
	}
}
