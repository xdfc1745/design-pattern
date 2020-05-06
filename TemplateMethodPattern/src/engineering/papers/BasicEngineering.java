package engineering.papers;

public abstract class BasicEngineering {
	//Papers() in the template method
	public void Papers() {
		//Common Papers
		Math();
		SoftSkills();
		//Specialized Paper;
		SpecialPaper();
	}
	//Non-Abstract method math(), SoftSkill() are //already implemented by Template class
	private void Math() {
		System.out.println("Mathmatics");
	}
	private void SoftSkills() {
		System.out.println("SoftSkills");
	}
	//Abstract method SpecialPaper() must be implemented in derived classes
	public abstract void SpecialPaper();

}
