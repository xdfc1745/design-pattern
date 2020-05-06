package singleton.pattern.demo;

class MakeACaptain {
	private static MakeACaptain _captain;
	//We make the constructor private to prevent the use of "new"
	private MakeACaptain() {}
	
	private static class SingletonHelper {
		//Nested class is referenced after getCaptain() is called
//		private static final MakeACaptain _captain;
	}
	public static MakeACaptain getCaptain() {
		
		//Lazy initialization
		if (_captain == null) {
			_captain = new MakeACaptain();
			System.out.println("New Captain selected for our team");
		}
		else {
			System.out.println("You already have a Captain for your team.");
			System.out.println("Send him for the toss.");
		}
		return _captain;
//		return SingletonHelper._captain;
	}
}

class SingletonPatternEx {
	public static void main(String[] args) {
		System.out.println("***Singleton Pattern Demo***\n");
		System.out.println("Trying to make another captain for our team");
		MakeACaptain c1 = MakeACaptain.getCaptain();
//		System.out.println("c1 = " + c1);
		System.out.println("Trying to make another captain for our team.");
		MakeACaptain c2 = MakeACaptain.getCaptain();
//		System.out.println("c2 = " + c2);
		if (c1 == c2) {
			System.out.println("c1 and c2 are same instance");
		}
	}
}
