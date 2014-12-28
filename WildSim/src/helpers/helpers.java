package helpers;

public class helpers {

	
	public static String msToString(int ms) {
		
		long millis = ms % 1000;
		long second = (ms / 1000) % 60;
		long minute = (ms / (1000 * 60)) % 60;
		long hour = (ms / (1000 * 60 * 60));

		String time = String.format("%04d:%02d:%02d:%03d", hour, minute, second, millis);
		
		return time;
	}
}
