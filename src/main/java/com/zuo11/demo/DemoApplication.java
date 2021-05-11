// package com.zuo11.demo;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class DemoApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemoApplication.class, args);
// 	}

// }

package com.zuo11.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// bind annotation 绑定注解
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		// http://localhost:8080/hello?name=234
		//http://localhost:8080/hello
		return String.format("Hello %s!", name);
	}

	@GetMapping("/user")
	public String user(@RequestParam(value = "name", defaultValue = "World") String name) {
		// http://localhost:8080/hello?name=234
		//http://localhost:8080/hello
		return String.format("Hello %s!", name);
	}

}