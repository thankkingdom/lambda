package streamtest;

import java.util.Iterator;
import java.util.List;

import historypersonsort.HistoryPerson;

public class StreamTest {

	private static void println(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		List<HistoryPerson> people = HistoryPerson.listPeople();
		if (args.length > 0) {
			// リスト6-4
			switch (args[0]) {
			case "veryold":
			default:
				println("とても古い書き方・・・");
				Iterator<HistoryPerson> it = people.iterator();
				while (it.hasNext()) {
					HistoryPerson p = it.next();
					println(p.getName());
				}
				break;
			case "foreach":
				println("forEachを用いると・・・");
				people.forEach((p) -> println(p.getName()));
				break;
			case "isborn":
				println("1540年に生まれていた人は");
				people.stream().filter((p) -> (p.getBornYear() < 1540)).forEach((p) -> println(p.getName()));
				break;
			case "active":
				println("1575年に健在だった人は");
				people.stream().filter((p) -> (p.getBornYear() < 1575)).forEach((p) -> println(p.getName()));
				break;
			}
		} else {
			for (HistoryPerson p : people) {
				println(p.getName());
			}
		}
	}

}
