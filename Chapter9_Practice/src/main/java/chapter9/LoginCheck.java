package chapter9;

public class LoginCheck {

	/*public static void Login(String s) {
		
	}*/
	
	public static void NullCheck(String s) throws Exception {
		if(s == null || s.isEmpty() || s.isEmpty()) {
			throw new Exception("未入力データがあります。");
		}
	}
}
