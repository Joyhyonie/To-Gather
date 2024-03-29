package com.greedy.togather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Chap99ToGatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap99ToGatherApplication.class, args);
	}

}

