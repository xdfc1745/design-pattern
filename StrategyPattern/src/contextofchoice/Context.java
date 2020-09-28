package contextofchoice;
import choices.IChoice;

public class Context {
	IChoice myC;
	public void SetChoice(IChoice ic) {
		myC = ic;
	}
	
	public void ShowCoice(String s1, String s2) {
		myC.myChoice(s1, s2);
	}
}
