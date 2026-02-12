package DesignPatterns.Creational.Factory;

// Service Layer
//       ↓
// Factory decides
//       ↓
// Creates Air object
//       ↓
// Returns Logistics reference
//       ↓
// Calls send()

interface Logistics{
	void send();
}

// concrete class of Logistics
class Road implements Logistics{
	@Override
	public void send(){
		System.out.println("Sending by road logic");
	}
}

// concrete class of Logistics
class Air implements Logistics{
	@Override
	public void send(){
		System.out.println("Sending by air logic");
	}
}

// concrete class of Logistics
class Train implements Logistics{
	@Override
	public void send(){
		System.out.println("Sending by train logic");
	}
}

class LogisticsFactory{
	// returning the interface
	// dealing with object creation
	public static Logistics getLogistics(String mode){
		if(mode == "road"){
			return new Road();
		}

		else if(mode == "air")	return new Air();
		else 					return new Train();
	}
}

class LogisticsService{
	public void send(String mode){
		// client does not know which class is created and how object is created :: loose coupling
		Logistics logistics = LogisticsFactory.getLogistics(mode);
		logistics.send();
  	}
}

public class solution {
  
}
