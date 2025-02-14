package com.spring.basics.spring_in_5_steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Named
public class SomeCdiBusiness {
	
	@Inject
	private SomeCdiDAO cdiDAO;

	public SomeCdiDAO getCdidao() {
		return cdiDAO;
	}

	public void setCdidao(SomeCdiDAO cdidao) {
		this.cdiDAO = cdidao;
	}
	
	
}
