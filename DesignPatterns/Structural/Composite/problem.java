package DesignPatterns.Structural.Composite;

import java.util.*;

class Product {
	private String name;
	private double price;

	public Product(String name, double price){

		this.name = name;
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void display(String indent){
		System.out.println(indent + "Product: " + name + " Rs." + price);
	}
}

class ProductBundle {
	private String bundleName;
	private List<Product> products = new ArrayList<>();

	public ProductBundle(String bundleName){
		this.bundleName = bundleName;
	}

	public void addProduct(Product product){
		products.add(product);
	}

	public double getPrice(){
		double total = 0;
		for(Product product : products){
			total += product.getPrice();
		}

		// discount logic
		return total;
	}

	public void display(String indent){
		System.out.println(indent + "Bundle: " + bundleName);
		for(Product product : products){
			product.display(indent + " ");
		}
	}
}

public class problem {
	public static void main(String[] args) {
		
		// Individual items
		Product book = new Product("Atomic habits", 499);
		Product phone = new Product("iPhone 15", 79999);
		Product earbuds = new Product("airPods", 15999);
		Product charger = new Product("20W charger", 1999);

		// bundle : iPhone combo
		ProductBundle iphoneCombo = new ProductBundle("iPhone essentials combo");
		iphoneCombo.addProduct(phone);
		iphoneCombo.addProduct(charger);
		iphoneCombo.addProduct(earbuds);

		// bundle : school kit
		ProductBundle schoolKit = new ProductBundle("Back to school kit");
		schoolKit.addProduct(new Product("Notebook Pack", 248));
		schoolKit.addProduct(new Product("Pen set", 99));
		schoolKit.addProduct(new Product("Highlighter", 149));

		// Add to cart - problem begins !!
		// using Object bcoz two type - product and productBundle
		// not preferred
		List<Object> cart = new ArrayList<>();
		cart.add(book);
		cart.add(iphoneCombo);
		cart.add(schoolKit);

		// Display cart
		System.out.println("Your cart (without Composite Pattern): ");
		double total = 0;

		// problem :: client has to explicitly check the type of instance
		for(Object item : cart){
			if(item instanceof Product){
				Product product = (Product) item;
				product.display(" ");
				total += product.getPrice();
			} else if(item instanceof ProductBundle){
				ProductBundle productBundle = (ProductBundle) item;
				productBundle.display(" ");
				total += productBundle.getPrice();
			}
		}

		System.out.println("Total: " + total);
	}
}
