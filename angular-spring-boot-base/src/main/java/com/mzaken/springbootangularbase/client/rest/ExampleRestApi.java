package com.mzaken.springbootangularbase.client.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestApi {

	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello World!";
	}
}
