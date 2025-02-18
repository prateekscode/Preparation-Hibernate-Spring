package com.spring.basics.spring_in_5_steps.cdi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.basics.spring_in_5_steps.SpringIn5StepsBasicApplication;

//Load the context
@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	// inject mock
	@InjectMocks
	SomeCdiBusiness business;

	// create mock
	@Mock
	SomeCdiDAO daoMock;

	@Test
	public void testBasicScenario() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 4 });
		int actualResult = business.findGreatest();
		assertEquals(4, actualResult);
	}
	
	@Test
	public void testBasicScenarioWithNoElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { });
		int actualResult = business.findGreatest();
		assertEquals(Integer.MIN_VALUE, actualResult);
	}
	
	@Test
	public void testBasicScenarioWithEqualElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 2 });
		int actualResult = business.findGreatest();
		assertEquals(2, actualResult);
	}

}
