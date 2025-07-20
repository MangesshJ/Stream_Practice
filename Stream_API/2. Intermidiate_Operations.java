package Stream_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Intermidiate_Operations {
	// Converts a stream into another stream for that specific period
	// Are Lazy, means don't execute/show result until a terminal operation is
	// invoked.

	public static void main(String[] args) {

		// Sample Lists
		List<String> word_List = Arrays.asList("America", "Africa", "India", "Paris", "Peru", "Italy", "Africa", "India", "Peru");
		List<Integer> num_List = Arrays.asList(1,4,6,2,9,4,9,0,12,23,54,52,52,7);
		List<List<String>> nested_List = List.of(List.of("Books", "Authors"), List.of("Movie", "Directors"));
		
// 1. filter(); -----------------------------------------------------
	/* works on true/false logic */
		long totalCount = word_List.stream().filter(x -> x.startsWith("A")).count();
		System.out.println("filter() : " + totalCount);
		
// 2. map(); -----------------------------------------------------
	/* Performs some function logic */
		List<String> uppperCase = word_List.stream().map(String::toUpperCase).toList();
		System.out.println("map() : " + uppperCase);

// 3. sorted(); -----------------------------------------------------
		/* Sorts the stream */
		List<String> sortedList = word_List.stream().sorted().toList();
		System.out.println("sorted() : " + sortedList);
		
// 4. distinct(); -----------------------------------------------------
		/* gives only unique elements */
		List<String> distinctWords = word_List.stream().distinct().toList();  // NORMAL WAY
		System.out.println("distinct()_normalWay : " + distinctWords);  
		
		List<Integer> distinctNums = num_List.stream().distinct().toList();
		System.out.println("distinct()_normalWay : " + distinctNums);
		
		List<String> conditoned_distinctWords = word_List.stream().filter(x -> x.startsWith("A")).distinct().toList(); // With CONDITION
		System.out.println("distinct()_withConditon : " + conditoned_distinctWords);
		
// 5. limit(); -----------------------------------------------------
		/* can give a limit to stream */
		System.out.println("limit() : " + Stream.iterate(1, x -> x+1).limit(21).toList());
		
// 6. skip(); -----------------------------------------------------
		/* can skip 1st few elements in iteration */
		System.out.println("skip() : " + Stream.iterate(1, x -> x+1).skip(10).limit(20).toList());
		
// 7. flatMap(); -----------------------------------------------------
		/* Converts flatMap into single stream of individual string */
		System.out.println("flatMap() : " + nested_List.stream().flatMap(List -> List.stream().map(String::toUpperCase)).toList());

	}
}
