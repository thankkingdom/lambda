package customersearch;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerSearch {

	public static void main(String[] args) {
		List<Customer> customers = Customer.listCustomer();

		if (args.length > 0) {
			// リスト6-19
			switch (args[0]) {
			case "filter":
				customers.stream().filter(c -> (c.getAge() > 29)).filter(c -> (c.getAge() < 40))
						.forEach(CustomerPrinter::printNameAndAge);
				break;
			case "sorted":
				customers.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
						.forEach(c -> println(c.getName()));
				;
				break;
			case "collect":
				List<Customer> men = customers.stream().filter(c -> c.getGender() == Gender.MAN)
						.collect(Collectors.toList());
				List<Customer> women = customers.stream().filter(c -> c.getGender() == Gender.WOMAN)
						.collect(Collectors.toList());
				println("女性一覧");
				women.stream().sorted((c1, c2) -> (c1.getName().compareTo(c2.getName())))
						.forEach(c -> println(c.getName()));
				println("");
				println("男性一覧");
				men.stream().sorted((c1, c2) -> (c1.getName().compareTo(c2.getName())))
						.forEach(c -> println(c.getName()));
				break;
			case "anymatch":
				if (customers.stream().anyMatch(c -> (c.getAge() < 20))) {
					println("成人向け企画は中止");
				} else {
					println("問題なし");
				}
				break;
			case "count":
				for (Size s : Size.values()) {
					long sizecount = customers.stream().filter(c -> c.getSize() == s).count();
					println(s.toString() + "： " + sizecount);
				}
				break;
			}
		} else {
			customers.forEach(CustomerPrinter::printCustomer);
		}
	}

	public static void println(Object o) {
		System.out.println(o);
	}
}
