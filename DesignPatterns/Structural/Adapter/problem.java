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

// problem : in our checkout service - we can not give a gateway
// 			 as razorpay is a third party api
class CheckoutService{
	private PaymentGateway paymentGateway;

	public CheckoutService(PaymentGateway paymentGateway){
		this.paymentGateway = paymentGateway;
	}

	public void checkout(String orderId, double amount){
		paymentGateway.pay(orderId, amount);
	}
}

public class problem {
	public static void main(String[] args) {
		CheckoutService checkoutService = new CheckoutService(new PayUGateway());
		checkoutService.checkout("12", 100);
	}
}
