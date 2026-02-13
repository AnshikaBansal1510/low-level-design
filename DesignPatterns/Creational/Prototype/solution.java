package DesignPatterns.Creational.Prototype;

import java.util.*;

interface EmailTemplate extends Cloneable{
	EmailTemplate clone();	// deep clone recommended
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
	public WelcomeEmail clone(){
		try{
			return (WelcomeEmail)	super.clone();
		} catch(CloneNotSupportedException e){
			throw new RuntimeException("Clone failed", e);
		}
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

class EmailTemplateRegistery{
	private static final Map<String, EmailTemplate> templates = new HashMap<>();

	static{
		templates.put("welcome", new WelcomeEmail());
		// add more templates like "discount", "feature-update" etc.
	}

	public static EmailTemplate getTemplate(String type){
		return templates.get(type).clone();		// clone avoids modifying original
	}
}

public class solution {
	public static void main(String[] args) {
		EmailTemplate welcomeEmail = EmailTemplateRegistery.getTemplate("welcome");

		EmailTemplate welcomeEmail2 = new WelcomeEmail();
		EmailTemplate welcomeEmail3 = welcomeEmail.clone();
	}
}
