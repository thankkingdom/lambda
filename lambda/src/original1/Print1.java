package original1;

import java.util.function.Consumer;

public class Print1 {

	public static void main(String[] args) {
		Consumer<String> fnc = (s->System.out.println(s));
		fnc = System.out::println;
		fnc.accept("piyo");
		
	}

}
