package command;
import java.util.*;

public class MacroCommand implements Command{
	private Stack commands = new Stack();
	private Stack undoHistoryForRedo = new Stack();
	public void execute() {
		Iterator it = commands.iterator();
		while(it.hasNext()) {
			((Command)it.next()).execute();
		}
	}
	public void append(Command cmd) {
		if (cmd != this) 
			commands.push(cmd);
	}
	public void undo() {
		if (!commands.empty()) {
			commands.pop();
			undoHistoryForRedo.push(commands.pop());
		}
	}
	public void redo() {
		if (!undoHistoryForRedo.isEmpty())
			commands.push(undoHistoryForRedo.pop());
	}

	public void clear() {
		commands.clear();
	}
}
