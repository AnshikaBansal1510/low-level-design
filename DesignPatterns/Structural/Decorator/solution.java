package DesignPatterns.Structural.Decorator;

interface Pizza {
	String getDescription();
	double getCost();
}

// concrete component 
class MargheritaPizza implements Pizza {
	@Override
	public String getDescription() {
		return "Margherita Pizza";
	}

	@Override
	public double getCost() {
	return 200.0;
	}
}

class PlainPizza implements Pizza {
	@Override
	public String getDescription() {
		return "Plain Pizza";
	}

	@Override
	public double getCost() {
	return 150.0;
	}
}

// decorator abstract class
// can not create obj of abstract class :: bcoz it has some methods that subclasses need to implement
abstract class PizzaDecorator implements Pizza {
	protected Pizza pizza;			// has-a relationship

	public PizzaDecorator(Pizza pizza){
		this.pizza = pizza;
	}
}

// concrete decorators
class ExtraCheese extends PizzaDecorator{
	public ExtraCheese(Pizza pizza){
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Extra Cheese";
	}

	@Override
	public double getCost() {
		return pizza.getCost() + 40.0;
	}
}

class Olives extends PizzaDecorator{
	public Olives(Pizza pizza){
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Olives";
	}

	@Override
	public double getCost() {
		return pizza.getCost() + 40.0;
	}
}

class StuffedCrust extends PizzaDecorator{
	public StuffedCrust(Pizza pizza){
		super(pizza);
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Stuffed Crust";
	}

	@Override
	public double getCost() {
		return pizza.getCost() + 50.0;
	}
}

public class solution {
	public static void main(String[] args) {

		// decorator class on concrete components (base) where stack ends

		Pizza margheritaCheese = new ExtraCheese(new MargheritaPizza());
		Pizza pizza = new ExtraCheese(new PlainPizza());
		// olive <- cheese <- margherita
		// new Olives(new Cheese(new Margherita))
		Pizza oliveCheese = new Olives(margheritaCheese);
		Pizza oliveStuffedM = new Olives(new StuffedCrust(new MargheritaPizza()));
	}
}
