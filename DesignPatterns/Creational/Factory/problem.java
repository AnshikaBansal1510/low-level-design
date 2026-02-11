package DesignPatterns.Creational.Factory;

interface Logistics{
	void send();
}

// concrete class
class Road implements Logistics{
	@Override
	public void send(){
		System.out.println("Sending by road logic");
	}
}

// comcrete class
class Air implements Logistics{
	@Override
	public void send(){
		System.out.println("Sending by air logic");
	}
}

// should only deal with sending out the item
// should not deal with logic of obj creation
// violating SRP
class LogisticsService{
	public void send(String mode){
		if(mode == "Air"){
			Logistics logistics = new Air();
			logistics.send();
		} else {
			Logistics logistics = new Road();
			logistics.send();
		}
	}
}

public class problem {
	public static void main(String[] args) {
		
	}
}
