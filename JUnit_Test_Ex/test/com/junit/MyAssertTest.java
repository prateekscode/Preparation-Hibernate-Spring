package com.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {
	List<String> todos=Arrays.asList("Aws","Azure","Ibm");
	@Test
	void test() {
		boolean test=todos.contains("Aws");
		boolean test2=todos.contains("GCP");
		//		assertEquals(true, test);
		assertTrue(test);
		assertFalse(test2);
//		assertNull(); assertNotNull();
		assertArrayEquals(new int[]  {5,8,3}, new int[] {5,8,3});
		assertEquals(3, todos.size());
	}

}
