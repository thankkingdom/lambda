package customersearch;

import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
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
			case "sum":
				HashMap<Size, Integer> point = new HashMap<>();
				point.put(Size.SMALL, 1);
				point.put(Size.MIDDLE, 3);
				point.put(Size.LARGE, 5);
				point.put(Size.XLARGE, 10);
				int allpoints = customers.stream().mapToInt(c -> point.get(c.getSize())).sum();
				println("発生したポイントの総計：" + allpoints + "点");
				break;
			case "average":
				OptionalDouble averageAge = customers.stream().filter(c -> c.getGender() == Gender.MAN)
						.mapToDouble(c -> c.getAge()).average();
				String outString = String.format("男性の平均年齢： %.1f歳", averageAge.getAsDouble());
				println(outString);
				break;
			case "age": //オリジナル
				customers.stream().forEach(CustomerPrinter::printNameAndAge);
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
