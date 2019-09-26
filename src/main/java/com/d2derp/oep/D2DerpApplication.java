package com.d2derp.oep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.d2derp.oep")
@SpringBootApplication
public class D2DerpApplication {

	public static void main(String[] args) {
		SpringApplication.run(D2DerpApplication.class, args);
	}

}
