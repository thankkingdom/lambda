package historypersonsearch;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import historypersonsort.HistoryPerson;

public class HistoryPersonSearch {

	public static void main(String[] args) {
		List<HistoryPerson> people = HistoryPerson.listPeople();
		if (args.length > 0) {
			// リスト5-24
			int argYear = Integer.parseInt(args[0]);
			Predicate<HistoryPerson> isborn = (p) -> p.getBornYear() < argYear;
			Predicate<HistoryPerson> notdead = (p) -> p.getDeadYear() > argYear;
			Consumer<HistoryPerson> write = (p) -> System.out
					.println(p.getName() + "は" + (argYear - p.getBornYear() + "歳でした"));
			System.out.println(argYear + "年には");
			for (HistoryPerson p : people) {
				if (isborn.and(notdead).test(p)) {
					write.accept(p);
				}
			}
		} else {
			// リスト5-23
			Predicate<HistoryPerson> okehazama = (person) -> person.getBornYear() < 1560;
			System.out.println("桶狭間の戦いのとき");
			for (HistoryPerson p : people) {
				if (okehazama.test(p)) {
					System.out.println(p.getName() + "は" + (1560 - p.getBornYear()) + "歳でした");
				}
			}
		}

	}

}
