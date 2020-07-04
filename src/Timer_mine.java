public class Timer_mine {
	static String timeBuffer;
	static int oldTime;	
	
	public static void stopwatch(int onOff) {
		if(onOff == 1)
		oldTime = (int) System.currentTimeMillis() / 1000;
		
		if(onOff == 0)
			secToHHMMSS( ((int) System.currentTimeMillis() / 1000) - oldTime);
	}
	
	public static void secToHHMMSS(int secs) {
		int sec = secs % 60;
		int min = secs / 60 % 60;
		int hour = secs / 3600 % 60;
		
		timeBuffer = String.format("%02d : %02d : %02d", hour,min,sec);
	}
	
	public static String returnTime() {
		return timeBuffer;
	}
}
