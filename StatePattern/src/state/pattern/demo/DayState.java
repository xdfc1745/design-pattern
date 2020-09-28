package state.pattern.demo;

public class DayState implements state{
	private static DayState singleton = new DayState();
	private DayState() {
	}
	public static state getInstance() {
		return singleton;
	}
	public void doClock (Context context, int hour) {
		if (hour == 12) {
			context.changeState(LunchState.getInstance());
		}
		else if (hour < 9 || 17 <= hour) {
			context.changeState(NightState.getInstance());
		}
	}
	public void doUse(Context context) {
		context.recordLog("금고사용(주간)");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(주간)");
	}
	public void doPhone(Context context) {
		context.callSecurityCenter("일반통화(주간)");
	}
	public String toString() {
		return "[주간]";
	}
}
