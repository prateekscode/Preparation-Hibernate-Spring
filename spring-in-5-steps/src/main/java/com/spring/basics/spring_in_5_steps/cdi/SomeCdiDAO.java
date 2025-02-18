package com.spring.basics.spring_in_5_steps.cdi;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named
public class SomeCdiDAO {
	public int[] getData() {
		return new int[] { 5, 89, 100 };
	}
}
