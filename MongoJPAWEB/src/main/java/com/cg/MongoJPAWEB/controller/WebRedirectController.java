package com.cg.MongoJPAWEB.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.MongoJPAWEB.pojo.Account;
import com.cg.MongoJPAWEB.pojo.Customer;

@Controller
public class WebRedirectController {
	
	static final String URL_CUSTOMER = "http://localhost:8080/customers/";
	static final String URL_ACCOUNT = "http://localhost:8080/accounts/";
	static final RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("")
	public String viewHome(Model model) {
		return "home";
	}
	
	@RequestMapping("/customers")
	public String viewAllCustomers(Model model) {
		ResponseEntity<?> responseEntity = restTemplate.exchange(URL_CUSTOMER, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});
		
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) 
			model.addAttribute("customers", responseEntity.getBody());
		else
			model.addAttribute("customers", null);
		return "viewAllCustomers";
	}
	
	@RequestMapping("/customers/{id}")
	public String viewCustomer(Model model, @PathVariable int id) {
		ResponseEntity<?> responseEntity = restTemplate.getForEntity(URL_CUSTOMER+id, Customer.class);
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
			System.out.println(responseEntity);
			model.addAttribute("customer", responseEntity.getBody());
			System.out.println(responseEntity.getStatusCodeValue()+" STAUS CODE VALUE");
			System.out.println(responseEntity.getHeaders()+" HEADERSSS");
			System.out.println(responseEntity.getStatusCode()+" STATUS CODE");
			System.out.println(responseEntity.getClass()+" CLASSS");
//			model.addAttribute("link", responseEntity.);
		}
		else
			model.addAttribute("customer", null);
		return "viewCustomer";
	}
	
	@RequestMapping("/accounts")
	public String viewAllAccounts(Model model) {
		ResponseEntity<?> responseEntity = restTemplate.exchange(URL_ACCOUNT, HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>(){});
		if(responseEntity.getStatusCode().equals(HttpStatus.OK))
			model.addAttribute("accounts", responseEntity.getBody());
		else
			model.addAttribute("accounts", null);
		return "viewAllAccounts";
	}
	
	@RequestMapping("/accounts/{id}")
	public String viewAccount(Model model, @PathVariable int id) {
		ResponseEntity<?> responseEntity = restTemplate.getForEntity(URL_ACCOUNT+id, Account.class);
		if(responseEntity.getStatusCode().equals(HttpStatus.OK))
			model.addAttribute("account", responseEntity.getBody());
		else
			model.addAttribute("account", null);
		return "viewAccount";
	}
}
