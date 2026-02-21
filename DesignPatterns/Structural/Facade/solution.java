package DesignPatterns.Structural.Facade;

class MovieBookingFacade {

	private PaymentService paymentService;
	private SeatReservationService seatReservationService;
	private NotificationService notificationService;
	private LoyaltyPointsService loyaltyPointsService;
	private TicketService ticketService;

	public MovieBookingFacade(){
		// instance of every service is created
		this.paymentService = new PaymentService();
		this.seatReservationService = new SeatReservationService();
		this.notificationService = new NotificationService();
		this.loyaltyPointsService = new LoyaltyPointsService();
		this.ticketService = new TicketService();
	}

	// can be scaled using builder pattern :: multiple parameters
	public void bookMovieTicket(String accountId, String movieId, String seatNumber, String userEmail, double amount){
		paymentService.makePayment(accountId, amount);
		seatReservationService.reserveSeat(movieId, seatNumber);
		ticketService.generateTicket(movieId, seatNumber);
		loyaltyPointsService.addPoints(accountId, 50);
		notificationService.sendBookingConfirmation(userEmail);

		System.out.println("Movie ticket booking completed successfully !!");
	}
}

public class solution {
	public static void main(String[] args) {
		
		MovieBookingFacade movieBookingFacade = new MovieBookingFacade();
		movieBookingFacade.bookMovieTicket(null, null, null, null, 0);
	}
}
