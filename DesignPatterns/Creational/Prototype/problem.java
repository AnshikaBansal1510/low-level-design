package DesignPatterns.Creational.Prototype;

interface EmailTemplate{
	void setContent(String content);
	void send(String to);
}

class WelcomeEmail implements EmailTemplate{
	private String subject;
	private String content;

	public WelcomeEmail(){
		this.subject = "Welcome";
		this.content = "Hi there! Thanks for joining us";
	}

	@Override
	public void setContent(String content){
		this.content = content;
	}

	@Override
	public void send(String to){
		System.out.println("Sending to " + to + ": [" + subject + "] " + content);
	}
}

public class problem {
	public static void main(String[] args) {
		
		// for using the same template :: we have to create different instances
		// to use it in different places

		// Singleton pattern will not work :: since it creates a global object 
		// which might override the content in race conditions
		WelcomeEmail welcomeEmail = new WelcomeEmail();
	}
}
