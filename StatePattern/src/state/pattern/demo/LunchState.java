package state.pattern.demo;

public class LunchState implements state{
	private static LunchState singleton = new LunchState();
	private LunchState() {
	}
	public static state getInstance() {
		return singleton;
	}
	public void doClock (Context context, int hour) {
		if (hour != 12) {
			context.changeState(DayState.getInstance());
		}
	}
	public void doUse(Context context) {
		context.callSecurityCenter("비상 : 점심시간금고 사용! ");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(점심시간)");
	}
	public void doPhone(Context context) {
		context.recordLog("점심시간통화 녹음");
	}
	public String toString() {
		return "[점심시간]";
	}
}
