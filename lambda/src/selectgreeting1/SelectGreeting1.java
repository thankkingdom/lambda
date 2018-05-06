package selectgreeting1;

public class SelectGreeting1 {

	public static void main(String[] args) {
		int myTime = Integer.parseInt(args[0]);
		if (5 <= myTime && myTime <= 10) {
			println("おはようございます");
		} else if (11 <= myTime && myTime <= 16) {
			println("こんにちは");
		} else if (17 <= myTime && myTime <= 22) {
			println("こんばんは");
		} else {
			println("どうしたんですかこんな時間に");
		}
	}

	public static void println(Object o) {
		System.out.println(o);
	}

}
