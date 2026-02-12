package DesignPatterns.Creational.AbstractFactory;

// checkout service :: payment gateway -> generate invoice

interface PaymentGateway{
	void processPayment(double amount);
}

class RazorpayGateway implements PaymentGateway{
	public void processPayment(double amount){
    	System.out.println("Processing INR payment via Razorpay: Rs." + amount);
  	}
}

class PayUGateway implements PaymentGateway{
	public void processPayment(double amount){
    	System.out.println("Processing INR payment via PayU: Rs." + amount);
  	}
}

interface Invoice{
  	void generateInvoice();
}

class GSTInvoice implements Invoice{
  	public void generateInvoice(){
    	System.out.println("Generating GST invoice for India.");
  	}
}

class IndiaFactory{
  	public static PaymentGateway createPaymentGateway(String gatewayType){
    	switch(gatewayType.toLowerCase()){
      	case "razorpay":
        	return new RazorpayGateway();
      	case "payu":
        	return new PayUGateway();
      	default:
        	throw new IllegalArgumentException("Unsupported payment gateway in India: " + gatewayType);    
    	}
  	}

  	public static Invoice createInvoice(){
    	return new GSTInvoice();
  	}
}

// violating SRP :: doing obj creation, processing payment, generating invoice -> Solved using Factory pattern
// violating SRP :: handling 2 factory logic India and US -> Solved using Factory Abstract pattern
class CheckoutService{

  	private String gatewayType;
  	private String countryCode;

  	public CheckoutService(String gatewayType, String countryCode){
    	this.gatewayType = gatewayType;
    	this.countryCode = countryCode;
  	}

  	public void checkOut(double amount){
		// if(gatewayType == "razorpay"){
		//   PaymentGateway paymentGateway = new RazorpayGateway();
		//   paymentGateway.processPayment(amount);
		// } else {
		//   PaymentGateway paymentGateway = new PayUGateway();
		//   paymentGateway.processPayment(amount);
		// }
		//Invoice invoice = new GSTInvoice();

		if(countryCode == "INDIA"){

			PaymentGateway paymentGateway = IndiaFactory.createPaymentGateway(gatewayType);
			paymentGateway.processPayment(amount);
			Invoice invoice = IndiaFactory.createInvoice();
			invoice.generateInvoice();
		} else {
			// create US Factory
		}
  	}
}
public class problem {
  	public static void main(String[] args) {
    
  	}
}
