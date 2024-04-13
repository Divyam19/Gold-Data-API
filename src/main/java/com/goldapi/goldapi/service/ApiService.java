package com.goldapi.goldapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

	@Autowired
	private final RestTemplate restTemplate;
	
	public ApiService (RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	public ResponseEntity<String> fetchDataFromApi() {
		String urlString="http://www.randomnumberapi.com/api/v1.0/random";
		ResponseEntity<String> response=restTemplate.getForEntity(urlString,String.class);
		if(response.getStatusCode().is2xxSuccessful()) {
			return new ResponseEntity<>(response.getBody(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Failed to fetch data from the api. Status Code: INterna server error " , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Double> getNewGoldRate(Double addValue) {
	    ApiService apiService = new ApiService(new RestTemplate());
	    ResponseEntity<String> responseData = apiService.fetchDataFromApi();
	    
	    
	    //extracting number from string
	    String responseString =responseData.getBody();
	    String numberString=responseString.replaceAll("[^0-9]","");
	    Double number =Double.parseDouble(numberString);
	    //Double addNumber=Double.parseDouble(addValue);
	    //Double newRate=number+addNumber;
	    Double newRate=number+addValue;
	    //String newRateString=newRate.toString();
	    
	    return new ResponseEntity<>(newRate,HttpStatus.OK);
	}


	
	
	
}
