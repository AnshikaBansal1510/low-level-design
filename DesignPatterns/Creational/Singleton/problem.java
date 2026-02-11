package DesignPatterns.Creational.Singleton;

// we need cnt of how many times run and submit functionality is used

class JudgeAnalytics{
	private int run = 0;
	private int submit = 0;

	public void countRun(){
		run++;
	}
	
	public void countSubmit(){
		submit++;
	}

	public int getRunCount(){
		return run;
	}

	public int getSubmitCount(){
		return submit;
	}
}

public class problem {
	public static void main(String[] args) {
		
		// problem :: code when used by different services will create different objects
		// 			  and we need value under global circumstances
		// single object to be used across my services
		JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
		judgeAnalytics.countRun();		// when run is triggered
		judgeAnalytics.countSubmit();	// when submit is triggered
	}
}
