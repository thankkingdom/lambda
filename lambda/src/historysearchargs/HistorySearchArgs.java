package historysearchargs;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import historypersonsort.HistoryPerson;

public class HistorySearchArgs {

	static final double FUJIYAMA = 138.4339;
	static final int NAGASHINO = 1575;

	public static void search(List<HistoryPerson> people, Predicate<HistoryPerson> searchby,
			Consumer<HistoryPerson> write) {
		for (HistoryPerson p : people) {
			if (searchby.test(p)) {
				write.accept(p);
			}
		}
	}

	public static void main(String[] args) {
		List<HistoryPerson> people = HistoryPerson.listPeople();
		Predicate<HistoryPerson> isBorn = (p) -> (p.getBornYear() < NAGASHINO);
		Predicate<HistoryPerson> notDead = (p) -> (p.getDeadYear() > NAGASHINO);
		Predicate<HistoryPerson> inEast = (p) -> (p.getCastleLongitude() > FUJIYAMA);
		Consumer<HistoryPerson> resultYear = (p) -> System.out
				.println(p.getName() + "さんは、" + (NAGASHINO - p.getBornYear()) + "歳");
		Consumer<HistoryPerson> resultCastle = (p) -> System.out.println(p.getName() + "さんがお住まいの" + p.getCastleName());

		System.out.println("1575年の時点で");
		search(people, isBorn.and(notDead), resultYear);
		System.out.println();
		System.out.println("富士山から東側にあったのは");
		search(people, inEast, resultCastle);
	}
}
