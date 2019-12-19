package com.barkie.barkie.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoint {
	@GetMapping("hello")
	public String test() {
		return "Hallo";
	}
}
