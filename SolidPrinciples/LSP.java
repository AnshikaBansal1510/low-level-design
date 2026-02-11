package SolidPrinciples;

class Rectangle{
	int h;
	int w;

	void setHeight(int h){
		this.h = h;
	}

	void setWidth(int w){
		this.w = w;
	}
}

class Square extends Rectangle{
	int h;
	int w;

	void setHeight(int h){
		this.h = h;
	}

	void setWidth(int w){
		this.w = w;
	}
}

class Notification{
	public void sendNotification(){
		System.out.println("Email send");
	}
}

class textNotification extends Notification{
	@Override
	public void sendNotification(){
		System.out.println("Text sent");
	}
}

public class LSP {
	public static void main(String[] args) {
		
		Rectangle rec = new Square();
		rec.setHeight(5);
		rec.setWidth(6);

		// behaviour same : logic might be different
		// so if over period of time we require to change the mode of notification
		// we can simply do it using substitution with minimal changes

		// if you are substituting :: it should have same functionalities of parent class as well
		// otherwise it will not give compile error but runtime error : LSP violation
		Notification notification = new textNotification();	// lsp 
		notification.sendNotification();
	}
}
