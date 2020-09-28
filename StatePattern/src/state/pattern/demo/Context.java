package state.pattern.demo;

public interface Context {
	public abstract void setClock(int hour);
	public abstract void changeState(state state);
	public abstract void callSecurityCenter(String msg);
	public abstract void recordLog(String msg);
}
