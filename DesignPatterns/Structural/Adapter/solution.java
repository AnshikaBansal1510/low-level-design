package DesignPatterns.Structural.Adapter;

interface PaymentGateway{
	void pay(String orderId, double amount);
}

class PayUGateway implements PaymentGateway{
	@Override
	public void pay(String orderId, double amount) {
		System.out.println("Paid Rs." + amount + " using PayU for order: " + orderId);
	}
}

class RazorpayAPI {
	public void makePayment(String invoiceId, double amountInRupees){
		System.out.println("Paid Rs." + amountInRupees + "using Razorpay for invoice: " + invoiceId);
	}
}

// added so that RazorpayAPI and CheckoutService can be amde compatible
class RazorpayAdapter implements PaymentGateway{
	private RazorpayAPI razorpayAPI;

	public RazorpayAdapter(){
		this.razorpayAPI = new RazorpayAPI();
	}

	@Override
	public void pay(String orderId, double amount) {
		razorpayAPI.makePayment(orderId, amount);		// adapting parameters
	}
}

class CheckoutService{
	private PaymentGateway paymentGateway;

	public CheckoutService(PaymentGateway paymentGateway){
		this.paymentGateway = paymentGateway;
	}

	public void checkout(String orderId, double amount){
		paymentGateway.pay(orderId, amount);
	}
}

public class solution {
	public static void main(String[] args) {
		CheckoutService checkoutService = new CheckoutService(new RazorpayAdapter());
		checkoutService.checkout("12", 100);
	}
}

