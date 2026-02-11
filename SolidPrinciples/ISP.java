package SolidPrinciples;

// violating ISP : rider will be forces to implement acceptRide, drive, endRide
interface Uber{
	void bookRide();
	void acceptRide();
	void drive();
	void endRide();
	void payRide();
}

interface RiderInterface{
	void bookRide();
	void payRide();
}

interface DriverInterface{
	void acceptRide();
	void drive();
	void endRide();
}

// clients not forced to implement extra functionalities they do not use
class Rider implements RiderInterface{
	public void bookRide(){}
	public void payRide(){}
}

class Driver implements DriverInterface{
	public void acceptRide(){}
	public void drive(){}
	public void endRide(){}
}
public class ISP {
  
}
