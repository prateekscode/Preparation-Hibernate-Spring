package com.mockito.example.mockito_demo.business.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {
	@Test
	void simpleTest() {
		List listM = mock(List.class);
		when(listM.size()).thenReturn(3);
		assertEquals(3, listM.size());
	}
	
	@Test
	void multipleReturns() {
		List listM = mock(List.class);
		when(listM.size()).thenReturn(1).thenReturn(2);
		assertEquals(1, listM.size());
		assertEquals(2, listM.size());
		assertEquals(2, listM.size());
		assertEquals(2, listM.size());
	}
	
	@Test
	void specificParameters() {
		List listM = mock(List.class);
		when(listM.get(0)).thenReturn("Some Message");
		assertEquals("Some Message", listM.get(0));
	}
	
	@Test
	void genericParameters() {
		List listM = mock(List.class);
		when(listM.get(Mockito.anyInt())).thenReturn("Some other Message");
		assertEquals("Some other Message", listM.get(0));
		assertEquals("Some other Message", listM.get(2));
	}
}
