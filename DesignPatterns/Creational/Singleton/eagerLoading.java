package DesignPatterns.Creational.Singleton;

class JudgeAnalytics{

	// created using class loading time :: thread safe :: eager loading
	// every object is initialised where needed or not :: memory wastage
	private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();

	// private :: no one can create instance of this outside this class
	private JudgeAnalytics(){}

	public static JudgeAnalytics getInstance(){
		return judgeAnalytics;
	}
}

public class eagerLoading {
	public static void main(String[] args) {

		JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
		JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();

		// both refer to same object
		System.out.println(judgeAnalytics);
		System.out.println(judgeAnalytics2);
	}
}
