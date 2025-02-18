package com.mockito.example.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findGreatestFromAllData_basic_sceanario () {
		DataService dataService=new DataServiceStub();
		SomeBusinessImpl businessImpl=new SomeBusinessImpl(dataService);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(70, result);
	}
	
	@Test
	void findGreatestFromAllData_one_value () {
		DataService dataService=new DataServiceStub1();
		SomeBusinessImpl businessImpl=new SomeBusinessImpl(dataService);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(99, result);
	}

}

class DataServiceStub implements DataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {25,15,70};
	}
}

class DataServiceStub1 implements DataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {99};
	}
}