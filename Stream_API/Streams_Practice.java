package com.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_Practice {
	public static void main(String[] args) {
			
		List<String> strings_List = Arrays.asList("india", "america", "antartica", "India", "russia", "Japan", "jamaica", "africa", "");
		List<String> strings_List1 = Arrays.asList("java", "pyhton", "sql", "html", "SQL", "Java");
		List<Integer> num_List = Arrays.asList(1,2,3,4,5,2,1,7,6,7,8);
		
//		
//		A. Basic Transformations & Filtering
//		Convert a list of strings to upper-case using streams.
//		Convert a list of integers to their squares.
//		Filter even numbers from a list.
//		Filter strings starting with a given letter.
//		Remove empty strings from a list.
//		Get distinct elements from a list.
//		Sort a list of integers in ascending order using streams.
//		Sort a list of integers in descending order using streams.
//		Find the first element in a list greater than a given number.
//
//		B. Aggregation & Reduction
//		Find the sum of all integers in a list using reduce().
//		Find the product of all integers in a list.
//		Find the maximum value in a list.
//		Find the minimum value in a list.
//		Find the average of a list of integers.
//		Count the number of elements greater than a certain value.
//		Join a list of strings into a single comma-separated string.
//		Find the length of the longest string in a list.
//		Find the total number of characters across all strings in a list.
//		Concatenate multiple lists into a single list using streams.
//
//		C. Advanced Filtering & Mapping
//		Remove duplicates from a list of strings ignoring case.
//		Find all strings that contain a given substring.
//		Convert a list of strings into a list of their lengths.
//		Replace each string with its reverse using streams.
//		Convert a list of Integer objects to primitive int[].
//		Get the second highest number from a list.
//		Get the nth largest number from a list.
//		Find numbers that appear more than once in a list.
//		Get only the palindrome strings from a list.
//		Remove all null values from a list.
//
//		D. Working with Objects
//		Given a list of Employee objects, get names of all employees.
//		Get a list of employees with salary > X.
//		Get a list of distinct departments from employees.
//		Sort employees by salary (ascending).
//		Sort employees by name (alphabetical).
//		Find the employee with the highest salary.
//		Find the employee with the lowest salary.
//		Group employees by department.
//		Count employees in each department.
//		Find average salary by department.
//
//		E. Complex Operations
//		Flatten a list of lists into a single list (flatMap).
//		Get all unique characters from a list of strings.
//		Check if all elements match a condition (allMatch).
//		Check if any element matches a condition (anyMatch).
//		Check if no element matches a condition (noneMatch).
//		Partition a list of integers into even and odd using partitioningBy.
//		Convert a list into a Map using Collectors.toMap().
//		Find the most frequent element in a list.
//		Convert a list of strings into a frequency map.
//		Find the intersection of two lists using streams.
//		
		
	// A ----------------------------------------------------------------------------------
		// Uppercase : 
		System.out.println(strings_List.stream().map(x -> x.toUpperCase()).toList());
		
		// int to their squares
		System.out.println(num_List.stream().map(x -> x*x).toList());
		
		// even number : 
		System.out.println(num_List.stream().filter(x -> x%2 == 0).toList());
		
		// string starting with given letter : 
		
		System.out.println(strings_List.stream().filter(x -> x.toLowerCase().startsWith("j")).toList());
		
		// remove empty strings from list
		System.out.println(strings_List.stream().filter(x -> !x.isEmpty()).toList());
		System.out.println(strings_List.stream().filter(x -> !x.isBlank()).toList());
		
		// distinct elements
		System.out.println(num_List.stream().distinct().toList());
		System.out.println(strings_List.stream().distinct().toList());
		
		// list in ascending and descending order :
		System.out.println(num_List.stream().sorted(Comparator.reverseOrder()).toList());
		System.out.println(num_List.stream().sorted().toList());
		
		// first element found after a given number:
		System.out.println(num_List.stream().filter(x -> x>4).findFirst().get());
		num_List.stream().filter(x -> x<4).sorted().reduce((a,b) -> b).ifPresent(System.out::println);
		
		// skip first n elements in list
		System.out.println(num_List.stream().skip(3).toList());
	
	// B ----------------------------------------------------------------------------------
		
		// sum of all elements using reduce :
		num_List.stream().reduce((x,y) -> x+y).ifPresent(System.out::println);
		
		// product of all elements using reduce :
		num_List.stream().reduce((x,y) -> x*y).ifPresent(System.out::println);
		
		// max value in list:
		System.out.println(num_List.stream().max(Integer::compareTo).get());
		System.out.println(num_List.stream().min(Integer::compareTo).get());
		
		// Avg of list :
		System.out.println(num_List.stream().mapToInt(Integer::intValue).average().orElse(0));
			
		// join list of strings with "," in-between :
		System.out.println(strings_List.stream().collect(Collectors.joining(", ")));
		
		// length of longest string in the list :
		System.out.println(strings_List.stream().mapToInt(String::length).max().getAsInt()); // find length of longest string
		System.out.println(strings_List.stream().max(Comparator.comparingInt(String::length)).get()); // find word of longest length
		
		// length of all strings in list :
		System.out.println(strings_List.stream().map(String::length).toList());
		
		// concatenate multiple lists in single :
		System.out.println(Stream.of(num_List,strings_List,strings_List1).flatMap(List::stream).toList());
		
	// C ----------------------------------------------------------------------------------
		//		Remove duplicates from a list of strings ignoring case.
		//		Find all strings that contain a given substring.
		//		Convert a list of strings into a list of their lengths.
		//		Replace each string with its reverse using streams.
		//		Convert a list of Integer objects to primitive int[].
		//		Get the second highest number from a list.
		//		Get the nth largest number from a list.
		//		Find numbers that appear more than once in a list.
		//		Get only the palindrome strings from a list.
		//		Remove all null values from a list. 
		
		// remove duplicates ignoring case :
		System.out.println(strings_List.stream().map(String::toLowerCase).distinct().toList());
		
		// find all strings containing a given substring :
		System.out.println(strings_List.stream().filter(x -> x.contains("ia")).toList());
		
		// list of strings to list of their lengths :
		System.out.println(strings_List.stream().map(String::length).toList());
		
		// replace each string with its reverse
		System.out.println(strings_List.stream().map(x -> new StringBuilder(x).reverse().toString()).toList());
		
		// convert integer to int[] :
		System.out.println(num_List.stream().mapToInt(Integer::intValue).toArray());
		
		// second highest num from list :
		System.out.println(num_List.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
		
		num_List.sort(Comparator.reverseOrder());
		if(num_List.size() >= 2) {
			System.out.println(num_List.get(1));
		}else {
			System.out.println("null");
		}
		
		// numbers that appear more than once
		Map<Integer, Integer> map =  num_List.stream().collect(Collectors.toMap(k -> k, v -> 1, (x,y) -> x+y));
		System.out.println(map.entrySet().stream()
			.filter(x -> x.getValue() > 1)
			.map(Map.Entry::getKey)
			.toList());
		
		
		
		
		
		
		
		
		
	}

}
