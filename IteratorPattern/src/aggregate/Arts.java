package aggregate;
import iterator.*;

public class Arts implements ISubject{
	private String[] subjects;
	
	public Arts() { // init arts array
		subjects = new String[2];
		subjects[0] = "Bengali";
		subjects[1] = "English";
	}
	
	public IIterator CreateIterator() { // create iterator for arts
		return new ArtsIterator(subjects);
	}
	
	//Containing the ArtsIterator
	public class ArtsIterator implements IIterator {
		private String[] subjects;
		private int position;
		public ArtsIterator(String[] subjects) {
			this.subjects = subjects;
			position = 0;
		}
		public void First() { // move first position
			position = 0;
		}
		public String Next() { // return next item 
			return subjects[position++];
		}
		public Boolean IsDone() { // check done subject array
			return position >= subjects.length;
		}
		public String CurrentItem() { // print position item
			return subjects[position];
		}
	} 
}
