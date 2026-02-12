package DesignPatterns.Creational.Builder;
import java.util.*;

class BurgerMeal{
	// required
	private final String bunType;
	private final String patty;

	// optional
	private final boolean hasCheese;
	private final List<String> toppings;
	private final String side;
	private final String drink;

	// private constructor
	// instead of multiple parameters :: we are using a BurgerBuilder class
	private BurgerMeal(BurgerBuilder builder){
		this.bunType = builder.bunType;
		this.patty = builder.patty;
		this.hasCheese = builder.hasCheese;
		this.toppings = builder.toppings;
		this.side = builder.side;
		this.drink = builder.drink;
	}

	public static class BurgerBuilder{
		// required
		private final String bunType;
		private final String patty;

		// optional
		private boolean hasCheese;
		private List<String> toppings;
		private String side;
		private String drink;

		public BurgerBuilder(String bunType, String patty){
			this.bunType = bunType;
			this.patty = patty;
		}

		// setters
		public BurgerBuilder withCheese(boolean hasCheese){
			this.hasCheese = hasCheese;
			return this;
		}

		public BurgerBuilder withToppings(List<String> toppings){
			this.toppings = toppings;
			return this;
		}

		public BurgerBuilder withSide(String side){
			this.side = side;
			return this;
		}

		public BurgerBuilder withDrink(String drink){
			this.drink = drink;
			return this;
		}

		// this is reference to burgerbuilder instance
		public BurgerMeal build(){
			return new BurgerMeal(this);
		}
	}
}

public class solution {
	public static void main(String[] args) {
		
		// creating object of BurgerBuilder class -> call build() -> which return obj of BurgerMeal class
		BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder("wheat", "veg").build();
		BurgerMeal burgerMeal2 = new BurgerMeal.BurgerBuilder("wheat", "non-veg").withCheese(true).build();
	}
}
