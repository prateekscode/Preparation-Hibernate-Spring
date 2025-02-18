package com.springaop.learn_springaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
	@TrackTime
	public String retrievesomething() {
		return "dao1";
	}
}
