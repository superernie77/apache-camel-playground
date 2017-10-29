package com.wds.example.camel.cameldemo;

import org.springframework.stereotype.Component;

@Component
public class GreeterBean {
	
	public String sayHello(String name) {
		return "Hello "+name +"!";
	}
}
