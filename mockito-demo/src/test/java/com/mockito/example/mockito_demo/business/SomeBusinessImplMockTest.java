package com.mockito.example.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	@Test
	void findGreatestFromAllData_basic_scenario () {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,80});
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(80, result);
	}
	 
	@Test
	void findGreatestFromAllData_one_value_test () {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		SomeBusinessImpl businessImpl=new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(15, result);
	}
	
	@Test
	void findGreatestFromAllData_empty_array_test () {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		SomeBusinessImpl businessImpl=new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(Integer.MIN_VALUE, result);
	}
}