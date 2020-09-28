package state.pattern.demo;

public class ImergencyState implements state{
	private static ImergencyState singleton = new ImergencyState();
	private ImergencyState() {
	}
	public static state getInstance() {
		return singleton;
	}
	public void doClock (Context context, int hour) {
		
	}
	public void doUse(Context context) {
		context.callSecurityCenter("비상 : 비상시 금고 사용! ");
	}
	public void doAlarm(Context context) {
		context.callSecurityCenter("비상벨(비상시)");
	}
	public void doPhone(Context context) {
		context.callSecurityCenter("일반통화(비상시)");
	}
	public String toString() {
		return "[비상시]";
	}
}
