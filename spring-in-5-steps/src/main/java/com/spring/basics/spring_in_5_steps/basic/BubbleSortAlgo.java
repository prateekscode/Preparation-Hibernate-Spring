package com.spring.basics.spring_in_5_steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubble")
public class BubbleSortAlgo implements SortAlgorithm{
	@Override
public int[] sort(int[] nums) {
	// TODO Auto-generated method stub
	return null;
}
}
