package com.mockito.example.mockito_demo.business;

public class SomeBusinessImpl {
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue=Integer.MIN_VALUE;
		for(int val: data) {
			if(val> greatestValue)
				greatestValue=val;
		}
		return greatestValue;		
	}
}

interface DataService{
	int[] retrieveAllData();
}