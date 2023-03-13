package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 어노테이션 : 스프링에서 지원하는 다양한 어노테잉션 중에 하나
// 스츠링부트를 통해 앱을 실행하려면 SpringBootApplication 어노테이션이 있어야 한다.
// Servlet을 쓰려면 servlet 어노테이션을 Application 클래스 위에 선언해줘야 한다.
@ServletComponentScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
