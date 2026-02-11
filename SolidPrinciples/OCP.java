package SolidPrinciples;

// modification in software entity effected all the services using them
// which need to be fixed now

// class TaxCalculator{
// 	public double amountAfterTax(double amount, String region){

// 		if(region == "INDIA")	return (amount + 0.18 * amount);
// 		else if(region == "US")	return (amount + 0.10 * amount);
// 		else 					return amount;
// 	}
// }

interface TaxCalculator{
	double amountAfterTax(double amount);
}

// extension of logic : add more code but do not modify existing code
class IndianTax implements TaxCalculator{
	public double amountAfterTax(double amount){
		return (amount + 0.18 * amount);
	}
}

class UsTax implements TaxCalculator{
	public double amountAfterTax(double amount){
		return (amount + 0.10 * amount);
	}
}

class InvoiceServices{
	public void calculate(){
		TaxCalculator taxCalculator = new IndianTax();
		taxCalculator.amountAfterTax(100);
	}
}

public class OCP{
	public static void main(String[] args) {
		
	}
}