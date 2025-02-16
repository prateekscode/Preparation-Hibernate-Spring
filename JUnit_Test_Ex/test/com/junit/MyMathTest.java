package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math=new MyMath();

	@Test
	void calculateSum_ThreeMemeberArray() {
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
	//Absence of failure is success
	//Test conditions or Asserts
	}

	@Test
	void calculateSum_ZeroLengthArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}
}
