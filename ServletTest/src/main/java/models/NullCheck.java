package models;

public class NullCheck {
	public static boolean isNull(String s) {
		if (s == null || s.isBlank()) {
			return true;
		} else {
			return false;
		}
	}

}
