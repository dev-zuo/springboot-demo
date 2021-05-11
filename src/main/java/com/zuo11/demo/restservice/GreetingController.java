package com.zuo11.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
  private static final String templatePost = "Post, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	} 

  // @PostMapping("/greeting") // @RequestBody 
	// public Greeting greetingPost(@RequestBody Greeting newGreeting) {
	// 	return new Greeting(counter.incrementAndGet(), String.format(templatePost, newGreeting.getContent()));
	// }

  @CrossOrigin(origins = "*",maxAge = 3600) // 跨域注解
  @PostMapping("/greeting") // @RequestBody 
	public ResponseEntity<Greeting> greetingPost(@RequestBody Greeting newGreeting) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(templatePost, newGreeting.getContent()));
    
    HttpHeaders responseHeaders = new HttpHeaders();
    // responseHeaders.set("Access-Control-Allow-Origin", "*");
    // responseHeaders.set("Access-Control-Allow-Methods", "*");
    // responseHeaders.set("Access-Control-Allow-Headers", "*");

    return new ResponseEntity<>(greeting, responseHeaders, HttpStatus.OK);
	}
}