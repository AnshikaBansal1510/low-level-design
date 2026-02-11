package DesignPatterns.Creational.Singleton;

// thread safe using synchronized keyword
// inefficient way :: every call aquires lock even after obj is created

class JudgeAnalytics{

	private static JudgeAnalytics judgeAnalytics;
	private JudgeAnalytics(){}

	public static synchronized JudgeAnalytics getInstance(){

		if(judgeAnalytics == null){

			judgeAnalytics = new JudgeAnalytics();
		}

		return judgeAnalytics;
	}
}


// double-checked locking :: outside and inside synchronized block

class JudgeAnalytics{

	// Object creation is NOT atomic. It happens in 3 steps internally:

	// 1. Allocate memory
	// 2. Initialize object
	// 3. Assign reference to variable

	// volatile prevents instruction reordering and guarantees visibility.

	// So:

	// volatile ensures safe publication of object across threads.

	private static volatile JudgeAnalytics judgeAnalytics;
	private JudgeAnalytics(){}

	public static JudgeAnalytics getInstance(){

		// synchronized keyword used only for the first time
		// 1st check :: without lock
		if(judgeAnalytics == null){
			synchronized (JudgeAnalytics.class){
				// check if instance is not created in any other thread
				// 2nd check :: inside lock
				if(judgeAnalytics == null){
					judgeAnalytics = new JudgeAnalytics();
				}
			}
		}

		return judgeAnalytics;
	}
}

// bill pugh singleton
class JudgeAnalytics{

	private JudgeAnalytics(){}

	// when class loaded into the system :: inner static class is not loaded
	// when we use JudgeAnalytics class for the first time :: it is loaded
	private static class Holder{
		private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
	}

	public static JudgeAnalytics getInstance(){
		return Holder.judgeAnalytics;
	}
}

public class threadSafety {
	public static void main(String[] args) {
		
		JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
		JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();

		System.out.println(judgeAnalytics);
		System.out.println(judgeAnalytics2);
	}
}
