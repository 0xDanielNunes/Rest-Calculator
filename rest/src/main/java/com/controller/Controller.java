package com.controller;

import com.config.ResponseEntityMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ComponentScan(basePackages = "com.service")
public class Controller {


	private final ResponseEntityMaker responseMaker;

	@Autowired
	public Controller(ResponseEntityMaker responseMaker) {

		this.responseMaker = responseMaker;

	}

	@GetMapping(value = "/sum")
	public ResponseEntity<String> sum(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return responseMaker.newResponseEntity(a,b,"sum");
	}

	@GetMapping(value = "/sub")
	public ResponseEntity<String> sub(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return responseMaker.newResponseEntity(a,b,"sub");
	}

	@GetMapping(value = "/mul")
	public ResponseEntity<String> mul(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return responseMaker.newResponseEntity(a,b,"mul");
	}

	@GetMapping(value = "/div")
	public ResponseEntity<String> div(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b){
		return responseMaker.newResponseEntity(a,b,"div");
	}
}
