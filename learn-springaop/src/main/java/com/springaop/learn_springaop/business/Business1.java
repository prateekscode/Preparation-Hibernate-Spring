package com.springaop.learn_springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springaop.learn_springaop.data.Dao1;
import com.springaop.learn_springaop.data.TrackTime;

@Service
public class Business1 {
	
	@Autowired
	private Dao1 dao1;
	
	@TrackTime
	public String calculateSomething() {
		return dao1.retrievesomething();
	}
	
}
