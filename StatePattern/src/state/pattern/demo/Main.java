package state.pattern.demo;

public class Main {
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("State sample ");
//		frame.state = NightState.getInstance();
		while(true) {
			for (int hour = 0; hour < 24; hour ++) {
				frame.setClock(hour);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					
				}
			}
		}
	}
}
