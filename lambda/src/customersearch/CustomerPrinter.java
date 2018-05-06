package customersearch;

public class CustomerPrinter {

	public static void printCustomer(Customer c) {
		StringBuffer printbuffer = new StringBuffer();
		printbuffer.append("名前：" + c.getName().toString() + ",");
		printbuffer.append("性別：" + c.getGender().toString() + ",");
		printbuffer.append("サイズ：" + c.getSize().toString() + ",");
		printbuffer.append("誕生日：" + c.getBirthay().toString());
		System.out.println(printbuffer.toString());
	}

	public static void printNameAndAge(Customer c) {
		System.out.println("名前：" + c.getName() + ", 年齢：" + c.getAge());
	}
}
