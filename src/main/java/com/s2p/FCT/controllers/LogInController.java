package com.s2p.FCT.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.s2p.FCT.model.CustomerModel;
import com.s2p.FCT.model.LoginModel;
import com.s2p.FCT.services.CustomerService;

@CrossOrigin(origins = "*")
@RestController
public class LogInController {
	
	private CustomerService customerService;
	
	@Autowired
	public LogInController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<CustomerModel> logIn(@RequestBody LoginModel loginModel) {
		 CustomerModel model = customerService.logIn(loginModel.getEmail(),loginModel.getPassword());
		 if(model != null) {
			 return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(model);
		 }else {
			 return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(model);
		 }
		 
	}

}
