package com.docemonos.springcruddemo.controller.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

	@Bean
	public DozerBeanMapper getDozzer() {
		return new DozerBeanMapper();
	}
}
