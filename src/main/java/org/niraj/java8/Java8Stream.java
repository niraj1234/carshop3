package org.niraj.java8;

import java.util.stream.IntStream;

public class Java8Stream {

	public static void main(String[] args) {

		
		int[] numbers = {1,34,23,83,5,0,43,11,8,3,2,5,7};

/*		int count = (int) IntStream.of(numbers).max().getAsInt();
		System.out.println(count);
*/
	

		int sum = IntStream.of(numbers)
		.distinct()
		.sorted()
		.limit(10)
		.sum();
		
		System.out.println(sum);
	}

}
