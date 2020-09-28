package abstractfactory.pattern.demo;

interface ITollywoodMovie {
	String MovieName();
}

interface IBollywoodMovie {
	String MovieName();
}

interface IMovieFactory {
	ITollywoodMovie GetTollywoodMovie();
	IBollywoodMovie GetBollywoodMovie();
}

//Tollywood Movie collections
class TollywoodActionMovie implements ITollywoodMovie {
	@Override
	public String MovieName() {
		return "Kranti is a Tollywood Action Movie";
	}
}
class TollywoodComedyMovie implements ITollywoodMovie {
	@Override
	public String MovieName() {
		return "BasantaBilap is a Tollywood Comdefy Movie";
	}
}
//Bollywood Movie collections
class BollywoodActionMovie implements IBollywoodMovie {
	@Override
	public String MovieName() {
		return "Bang Bang is a Bollywood Action Movie";
	}
}
class BollywoodComedyMovie implements IBollywoodMovie {
	@Override
	public String MovieName() {
		return "Munna Bhai MBBS is a Bollywood Comedy Movie";
	}
}

//Action Movie Factory
class ActionMovieFactory implements IMovieFactory {

	public IBollywoodMovie GetBollywoodMovie() {
		return new BollywoodActionMovie();
	}
	@Override
	public ITollywoodMovie GetTollywoodMovie() {
		return new TollywoodActionMovie();
	}
}
//Comedy Movie Factory
class ComedyMovieFactory implements IMovieFactory {
	public ITollywoodMovie GetTollywoodMovie() {
		return new TollywoodComedyMovie();
	}
	public IBollywoodMovie GetBollywoodMovie() {
		return new BollywoodComedyMovie();
	}
}

class AbstractFactoryPatternEx {
	public static void main(String[] args) {
		System.out.println("***Abstract Factory Pattern Demo***\n");
		ActionMovieFactory actionMovies =  new ActionMovieFactory();
		ITollywoodMovie tAction = actionMovies.GetTollywoodMovie();
		ITollywoodMovie bAction = actionMovies.GetTollywoodMovie();
		
		System.out.println("\nAction movies are : ");
		System.out.println(tAction.MovieName());
		System.out.println(bAction.MovieName());
		
		ComedyMovieFactory comedyMovies = new ComedyMovieFactory();
		ITollywoodMovie tComedy = comedyMovies.GetTollywoodMovie();
		ITollywoodMovie bComedy = comedyMovies.GetTollywoodMovie();
		
		System.out.println("\nComedy movies are : ");
		System.out.println(tComedy.MovieName());
		System.out.println(bComedy.MovieName());
	}
}
