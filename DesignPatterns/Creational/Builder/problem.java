package DesignPatterns.Creational.Builder;

// sides, toppings, cheese :: optional things

class BurgerMeal{
	private String bun;
	private String patty;

	// we can add String sides, List<String> toppings
	// but that increases the number of parameters
	// also the parameters are optional :: client has to explicitly give null if not required
	public BurgerMeal(String bun, String patty){
		this.bun = bun;
		this.patty = patty;
	}
}

public class problem {
	public static void main(String[] args) {
		
		BurgerMeal burgerMeal = new BurgerMeal("wheat", "veg");
	}
}
