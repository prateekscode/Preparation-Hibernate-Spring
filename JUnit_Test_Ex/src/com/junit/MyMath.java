package com.junit;

public class MyMath {
	public int calculateSum(int[] numbers) {
		
		int sum = 0;
		
		for (int a : numbers)
			sum = sum + a;
		return sum;
	}
}
