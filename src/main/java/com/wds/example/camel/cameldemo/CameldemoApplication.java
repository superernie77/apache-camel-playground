package com.wds.example.camel.cameldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;

@SpringBootApplication(exclude = { AopAutoConfiguration.class, WebSocketServletAutoConfiguration.class })
public class CameldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CameldemoApplication.class, args);
	}
	
}
