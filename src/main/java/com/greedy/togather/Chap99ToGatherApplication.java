package com.greedy.togather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan("com.greedy.togather")
public class Chap99ToGatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap99ToGatherApplication.class, args);
	}

}
