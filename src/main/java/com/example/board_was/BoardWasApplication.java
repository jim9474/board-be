package com.example.board_was;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.board_was.mapper")
public class BoardWasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardWasApplication.class, args);
	}

}
