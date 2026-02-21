package DesignPatterns.Structural.Decorator;

// problem :: exponentially growing the number of classes
// similar to builder pattern problem
class PlainPizza {}
class CheesePizza extends PlainPizza {}
class OlivePizza extends PlainPizza {}
class StuffedPizza extends PlainPizza {}
class CheeseStuffedPizza extends CheesePizza {}
class CheeseOlivePizza extends CheesePizza {}
class CheeseOliveStuffedPizza extends CheeseOlivePizza {}


public class problem {
	public static void main(String[] args) {
		
	}
}
