package DesignPatterns.Structural.Facade;

// bookMyShow
// paymentServie -> generate ticket -> send notification

class PaymentService {
	public void makePayment(String accountId, double amount){
		System.out.println("Payment of Rs." + amount + " successful for account " + accountId);
	}
}

class SeatReservationService {
	public void reserveSeat(String movieId, String seatNumber){
		System.out.println("Seat " + seatNumber + " reserved for movie " + movieId);
	}
}

class NotificationService {
	public void sendBookingConfirmation(String userEmail){
		System.out.println("Booking confirmation sent to: " + userEmail);
	}
}

class LoyaltyPointsService {
	public void addPoints(String accountId, int points){
		System.out.println(points + " loyalty points added to account " + accountId);
	}
}

class TicketService {
	public void generateTicket(String movieId, String seatNumber){
		System.out.println("Ticket generated for movie: " + movieId + ", Seat: " + seatNumber);
	}
}

public class problem {
	public static void main(String[] args) {
		// booking a movie ticket manually in order
		// problem :: client dealing with all services by itself
		PaymentService paymentService = new PaymentService();
		paymentService.makePayment("user123", 500);

		SeatReservationService seatReservationService = new SeatReservationService();
		seatReservationService.reserveSeat("movie456", "A10");

		NotificationService notificationService = new NotificationService();
		notificationService.sendBookingConfirmation("user@example.com");

		LoyaltyPointsService loyaltyPointsService = new LoyaltyPointsService();
		loyaltyPointsService.addPoints("user123", 50);

		TicketService ticketService = new TicketService();
		ticketService.generateTicket("movie456", "A10");
	}
}
