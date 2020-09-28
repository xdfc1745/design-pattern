package state.pattern.demo;

public class SnackState implements state{
	private static SnackState singleton = new SnackState();
	private SnackState() {
	}
	public static state getInstance() {
		return singleton;
	}
	public void doClock(Context context, int hour) {
		if (hour != 23 || hour != 0) {
			if (hour <= 9 || hour >17) {
				context.changeState(NightState.getInstance());
			}
		}
//		if (hour != 23 && hour != 0) {
//			if (9 <= hour && hour < 17) {
//				context.changeState(NightState.getInstance());
//			} else if (hour > 9 || hour >= 17) {
//				context.changeState(DayState.getInstance());
//			}
//		}
	}
	public void doUse(Context context) {
		context.callSecurityCenter("비상 : 야식시간금고 사용! ");
		context.recordLog("금고사용(야식시간)");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(야식시간)");
	}
	public void doPhone(Context context) {
		context.recordLog("야식시간통화 녹음");
	}
	public String toString() {
		return "[야식시간]";
	}
}
