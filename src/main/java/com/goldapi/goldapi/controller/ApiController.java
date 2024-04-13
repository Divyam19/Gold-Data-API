package com.goldapi.goldapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.goldapi.goldapi.service.ApiService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	public ApiController(ApiService apiService) {
		this.apiService=apiService;
	}

	@PostMapping("/getgoldrate")
	public ResponseEntity<Double> getNewGoldRateService(@RequestBody Double addValue){
		return apiService.getNewGoldRate(addValue);
	}
	
	@GetMapping("/hi")
	public ResponseEntity<String> hi(){
		return new ResponseEntity<>("hiiiiiii",HttpStatus.OK);
	}
	
}
