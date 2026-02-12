package DesignPatterns.Creational.AbstractFactory;

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

class PaypalGateway implements PaymentGateway{
	public void processPayment(double amount){
    	System.out.println("Processing USD payment via PayPal: Rs." + amount);
  	}
}

class StripeGateway implements PaymentGateway{
	public void processPayment(double amount){
    	System.out.println("Processing USD payment via Stripe: Rs." + amount);
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

class USInvoice implements Invoice{
	public void generateInvoice(){
	  System.out.println("Generating US invoice for US.");
	}
}

interface RegionFactory{

	PaymentGateway createPaymentGateway(String gatewayType);
	Invoice createInvoice();
}

class IndiaFactory implements RegionFactory{
	public PaymentGateway createPaymentGateway(String gatewayType){
	  switch(gatewayType.toLowerCase()){
		case "razorpay":
		  return new RazorpayGateway();
		case "payu":
		  return new PayUGateway();
		default:
		  throw new IllegalArgumentException("Unsupported payment gateway in India: " + gatewayType);    
	  }
	}

	public Invoice createInvoice(){
	  return new GSTInvoice();
	}
}

class USFactory implements RegionFactory{
	public PaymentGateway createPaymentGateway(String gatewayType){
	  switch(gatewayType.toLowerCase()){
		case "stripe":
		  return new StripeGateway();
		case "paypal":
		  return new PaypalGateway();
		default:
		  throw new IllegalArgumentException("Unsupported payment gateway in US: " + gatewayType);    
	  }
	}

	public Invoice createInvoice(){
	  return new USInvoice();
	}
}

class CheckoutService{
	private PaymentGateway paymentGateway;
	private Invoice invoice;
	private String gatewayType;

	public CheckoutService(RegionFactory factory, String gatewayType){
		this.gatewayType = gatewayType;
		this.paymentGateway = factory.createPaymentGateway("razorpay");
		this.invoice = factory.createInvoice();
	}

	public void completeOrder(double amount){
		paymentGateway.processPayment(amount);
		invoice.generateInvoice();
	}
}

public class solution {
	public static void main(String[] args) {
		CheckoutService checkoutService = new CheckoutService(new IndiaFactory(), "razorpay");
		CheckoutService checkoutService2 = new CheckoutService(new USFactory(), "stripe");
	}
}
