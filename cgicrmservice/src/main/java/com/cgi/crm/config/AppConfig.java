package com.cgi.crm.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author skurapati
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cgi.crm")
public class AppConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}