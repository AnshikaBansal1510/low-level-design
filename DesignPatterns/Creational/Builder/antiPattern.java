package DesignPatterns.Creational.Builder;

// telescoping constructor anti-pattern
// does not scale well :: Java-lack of optional/default params
class BurgerMeal{
  private String bunType;
	private String patty;
	private boolean hasCheese;

  public BurgerMeal(String bunType, String patty){
    this.bunType = bunType;
    this.patty = patty;
    this.hasCheese = false;
  }

  public BurgerMeal(String bunType, String patty, boolean hasCheese){
    this.bunType = bunType;
    this.patty = patty;
    this.hasCheese = hasCheese;
  }
}

public class antiPattern {
  public static void main(String[] args) {
    BurgerMeal burgerMeal = new BurgerMeal("wheat", "veg");
  }
}
