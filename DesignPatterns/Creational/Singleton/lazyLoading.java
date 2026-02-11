package DesignPatterns.Creational.Singleton;

class JudgeAnalytics{

	// when class is loaded :: this is not initialised
	// not thread safe :: instance created during execution time
	// only initialises objects which are required
	private static JudgeAnalytics judgeAnalytics;

	private JudgeAnalytics(){}

	public static JudgeAnalytics getInstance(){

		// if no obj is created :: create object once
		if(judgeAnalytics == null){

			judgeAnalytics = new JudgeAnalytics();
		}

		return judgeAnalytics;
	}
}

public class lazyLoading {
	public static void main(String[] args) {
		
		JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
		JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();

		// both refer to same object
		System.out.println(judgeAnalytics);
		System.out.println(judgeAnalytics2);
	}
}
