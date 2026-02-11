package SolidPrinciples;

// In my design, the high-level module RecommendationAlgorithm does not depend on concrete recommendation implementations like TrendingRecommendation. Instead, it depends on the abstraction RecommendationStrategy. The concrete implementations implement this interface. Dependency is injected via constructor, ensuring loose coupling and making the system extensible and testable.

// abstraction layer
interface RecommendationStrategy{
	void recommend();
}

// contain actual implementation details :: define how recommendation is done
class TrendingRecommendation implements RecommendationStrategy{
	public void recommend(){}
}

class GenreRecommendation implements RecommendationStrategy{
	public void recommend(){}
}

// low level module
class RecentRecommendation implements RecommendationStrategy{
	//public void recentRecommend(){}
	public void recommend(){}
}


// high level layer :: controller by person who is going to use it
// does not care how recommendation works
// depend on recommendation strategy interface
class RecommendationAlgorithm{
	private RecommendationStrategy recommendationStrategy;

	public RecommendationAlgorithm(RecommendationStrategy recommendationStrategy){

		this.recommendationStrategy = recommendationStrategy;
	}

	public void recommend(){
		recommendationStrategy.recommend();
	}
}

public class DIP {
	// high level module
	public static void main(String[] args) {
		
		TrendingRecommendation trendingRecommendation = new TrendingRecommendation();
		trendingRecommendation.recommend();

		// high level module depending on low level module(concrete class) :: tightly coupled
		RecentRecommendation recentRecommendation = new RecentRecommendation();
		//recentRecommendation.recentRecommend();

		// depending on abstraction
		RecommendationStrategy recommendationStrategy = new TrendingRecommendation();
		recommendationStrategy.recommend();

		RecommendationAlgorithm recommendationAlgorithm = new RecommendationAlgorithm(new TrendingRecommendation());  // constructor injection :: injecting dependency from outside
		recommendationAlgorithm.recommend();
	}
}
