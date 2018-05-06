package selectgreeting2;

public class SelectGreeting2 {

	public void morning() {
		println("おはようございます");
	}

	public void afternoon() {
		println("こんにちは");
	}

	public void evening() {
		println("こんばんは");
	}

	public void other() {
		println("どうしたんですかこんな時間に");
	}

	public static void main(String[] args) {
		int myTime = Integer.parseInt(args[0]);
		SelectGreeting2 greet = new SelectGreeting2();
		if (5 <= myTime && myTime <= 10) {
			greet.morning();
		} else if (11 <= myTime && myTime <= 16) {
			greet.afternoon();
		} else if (17 <= myTime && myTime <= 22) {
			greet.evening();
		} else {
			greet.other();
		}
	}

	public static void println(Object o) {
		System.out.println(o);
	}
}
