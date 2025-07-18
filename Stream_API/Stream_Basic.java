package Stream_API;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Stream_Basic {

	public static void main(String[] args) {

// 1. PREDICATE : -----------------------------------------------------------------------
// (Functional Interface = Boolean value function)
		// 1.
		Predicate<Integer> isEven = x -> x % 2 == 0;
		System.out.println("Is Num Even : " + isEven.test(4));
		// 2.
		Predicate<String> startsWithA = x -> x.startsWith("M");
		Predicate<String> endsWithA = x -> x.endsWith("H");
		Predicate<String> and = startsWithA.and(endsWithA);
		System.out.println("Start & End condition : " + and.test("MANGESH"));

// 2. FUNCTION : -----------------------------------------------------------------------
// (Performs some function, It works for you)
		// 1.
		Function<Integer, Integer> doubleIt = x -> x * 2;
		Function<Integer, Integer> tripleIt = x -> x * 3;
		// 2.
		System.out.println("Function executed : " + doubleIt.andThen(tripleIt).apply(20));
		System.out.println("Function executed : " + doubleIt.compose(tripleIt).apply(20)); // Its just the reverse of andThen (1st tripleIt and the doubleIt)

// 3. CONSUMER : -----------------------------------------------------------------------
// (Takes something and uses it, But gives nothing extra)
		Consumer<Integer> print = x -> System.out.println("Consumer : " + x);
		print.accept(5);

// 4. SUPPLIER : -----------------------------------------------------------------------
// (Takes Nothing, Only gives)
		Supplier<String> giveHello = () -> "HELLO";
		System.out.println("Supplier : " + giveHello.get());
	
	//-------------------- COMBINED EXAMPLE : ---------------------
		Predicate<Integer> predicate = x -> x % 2 == 0;
		Function<Integer, Integer> function = x -> x*x;
		Consumer<String> consumer = x -> System.out.println(x);
		Supplier<String> supplier = () -> "hello";
	
// 5. BI-PREDICATE : -----------------------------------------------------------------------
		BiPredicate<Integer, Integer> biPredicate = (x,y) -> (x+y) % 2 == 0;
		
// 6. BI-FUNCTION : -----------------------------------------------------------------------
		BiFunction<String, String, Integer> bi_Function = (x,y) -> (x+y).length();
		System.out.println("BI_Function : " + bi_Function.apply("a", "bc"));
		
// 7. BI-CONSUMER : -----------------------------------------------------------------------
		BiConsumer<Integer, String> bi_Consumer = (x,y) -> {
			System.out.println(x);
			System.out.println(y);
		};
		
	}
}
