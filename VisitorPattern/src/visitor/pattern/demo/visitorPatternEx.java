package visitor.pattern.demo;
import java.util.Iterator;
import java.util.ArrayList;

abstract class Visitor {
	public abstract void visit(File file);
	public abstract void visit(Directory directory);
}

interface Element {
	public abstract void accept (Visitor v);
}

abstract class Entry implements Element {
	public abstract String getName();
	public abstract int getSize();
	
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}

class File extends Entry {
	private String name;
	private int size;
	public File(String name, int size) {
		this.name = name;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public int getSize() {
		return size;
	}
	public void accept(Visitor v) {
		v.visit(this);
	}
}

class Directory extends Entry {
	private String name;
	private ArrayList dir = new ArrayList();
	public Directory (String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getSize() {
		int size = 0;
		Iterator it = dir.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			size += entry.getSize();
		}
		return size;
	}
	public Entry add(Entry entry) {
		dir.add(entry);
		return this;
	}
	public Iterator iterator() {
		return dir.iterator();
	}
	public void accept(Visitor v) {
		v.visit(this);
	}
}
class ListVisitor extends Visitor {
	private String currentdir = "";
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	public void visit(Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();
		Iterator it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
		currentdir = savedir;
	}
}
class FileTreatmentException extends RuntimeException {
	public FileTreatmentException() {
	}
	public FileTreatmentException(String msg) {
		super(msg);
	}
}

class FileFindVisitor extends Visitor {
	private String filetype;
	private ArrayList found = new ArrayList();
	public FileFindVisitor(String filetype) {
		this.filetype = filetype;
	}
	public Iterator getFoundFiles() {
		return found.iterator();
	}
	public void visit(File file) {
		if(file.getName().contains(filetype)) found.add(file);
	}
	public void visit (Directory directory) {
		Iterator it = directory.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
	}
}

public class visitorPatternEx {
	public static void main(String[] args) {
		try {
			System.out.println("Making root entries...");
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			bindir.add(new File("vi", 10000));
			bindir.add(new File("latex", 20000));
			rootdir.accept(new ListVisitor());
			
			Directory Kim = new Directory("Kim");
			Directory Lee = new Directory("Lee");
			Directory Park = new Directory("Park");
			usrdir.add(Kim);
			usrdir.add(Lee);
			usrdir.add(Park);
			Kim.add(new File("HyejaKim.html", 100));
			Kim.add(new File("GayoungKim.java", 200));
			Lee.add(new File("LeeHyeja.txt", 300));
			Lee.add(new File("YoungheeLee.html", 350));
		
			Park.add(new File("JunPark.doc", 400));
			Park.add(new File("ParkHyeja.mail", 500));
			
			FileFindVisitor ffv = new FileFindVisitor("Hyeja");
			rootdir.accept(ffv);
			System.out.println("Hyeja files are : ");
			Iterator it = ffv.getFoundFiles();
			while(it.hasNext()) {
				File file = (File)it.next();
				System.out.println(file.toString());
			}
		}catch(FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
