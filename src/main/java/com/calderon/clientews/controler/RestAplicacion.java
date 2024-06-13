package com.calderon.clientews.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.greeting.GetGreetingRequest;
import com.example.greeting.GetGreetingResponse;


@RestController
@RequestMapping("/soap")
public class RestAplicacion {

	@Autowired
    private SoapClient soapClient;	
	
	@GetMapping(value = "/hola", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> hola() {
		GetGreetingRequest request = new GetGreetingRequest(); 
		request.setName("Ivan");
        GetGreetingResponse response = (GetGreetingResponse) soapClient.callWebService(request);
        System.out.println(response.getGreeting());
		return new ResponseEntity<>(response.getGreeting(), HttpStatus.OK);
	}

}
