package iteratorpattern.demo;
import iterator.*;
import aggregate.*;

class IteratorPatternEx {
	public static void main(String[] args) {
		System.out.println("***Iterator Pattern Demo***\n");
		ISubject Sc_subject = new Science();
		ISubject Ar_subject = new Arts(); // create science, art 
		
		IIterator Sc_iterator = Sc_subject.CreateIterator();
		IIterator Ar_iterator = Ar_subject.CreateIterator(); // create iterator 
		
		System.out.println("\nScience subject : ");
		Print(Sc_iterator); //print Science
		
		System.out.println("\nArts subject : ");
		Print(Ar_iterator); // print arts
	}
	public static void Print(IIterator iterator) {
		while(!iterator.IsDone()) { //until done array or linkedlist
			System.out.println(iterator.Next());
		}
	}
}
