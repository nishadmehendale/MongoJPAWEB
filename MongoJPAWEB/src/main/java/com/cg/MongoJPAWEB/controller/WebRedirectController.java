package com.cg.MongoJPAWEB.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cg.MongoJPAWEB.pojo.Account;
import com.cg.MongoJPAWEB.pojo.Customer;

@Controller
public class WebRedirectController {
	
	static final String URL_CUSTOMER_SERVICE = "http://localhost:8080/customers/";
	static final String URL_ACCOUNT_SERVICE = "http://localhost:8080/accounts/";
	static final String URL_ACCOUNT = "http://localhost:8989/accounts/";
	static final String URL_CUSTOMER = "http://localhost:8989/customers/";
	static final RestTemplate restTemplate = new RestTemplate();
	@RequestMapping("")
	public String viewHome(Model model) {
		return "home";
	}
	
	@RequestMapping("/customers")
	public String viewAllCustomers(Model model) {
		try {
		ResponseEntity<?> responseEntity = restTemplate.exchange(URL_CUSTOMER_SERVICE, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});	
			model.addAttribute("customers", responseEntity.getBody());
		}catch(RestClientException e) {
			model.addAttribute("customers", null);
		}
		return "viewAllCustomers";
	}
	
	@RequestMapping("/customers/{id}")
	public String viewCustomer(Model model, @PathVariable int id) {
		try {
		ResponseEntity<?> responseEntity = restTemplate.getForEntity(URL_CUSTOMER_SERVICE+id, Customer.class);
			model.addAttribute("customer", responseEntity.getBody());
		}
		catch(RestClientException e) {       
			model.addAttribute("customer", null);
		}	
		model.addAttribute("link", URL_CUSTOMER);
		return "viewCustomer";
	}
	
	@RequestMapping("/accounts")
	public String viewAllAccounts(Model model) {
		try {
		ResponseEntity<?> responseEntity = restTemplate.exchange(URL_ACCOUNT_SERVICE, HttpMethod.GET, null, new ParameterizedTypeReference<List<Account>>(){});
		model.addAttribute("accounts", responseEntity.getBody());
		}
		catch(RestClientException e) {
			model.addAttribute("accounts", null);
		}
		return "viewAllAccounts";
	}
	
	@RequestMapping("/accounts/{id}")
	public String viewAccount(Model model, @PathVariable int id) {
		try {
		ResponseEntity<?> responseEntity = restTemplate.getForEntity(URL_ACCOUNT_SERVICE+id, Account.class);
			model.addAttribute("account", responseEntity.getBody());}
		catch(RestClientException e) {
			model.addAttribute("account", null);
		}
		model.addAttribute("link", URL_ACCOUNT);
		return "viewAccount";
	}
	
	@RequestMapping(value="/customers/add"/*, method=RequestMethod.POST*/)
	public String addAccount(Model model) { 
		ResponseEntity<ArrayList> responseEntity = restTemplate.getForEntity(URL_ACCOUNT_SERVICE, ArrayList.class);
		System.out.println(responseEntity);
		return "home";
	}
	
	@RequestMapping("/account")
	public String viewA(Model model,@RequestParam("num") int sender) {
		
		return viewAccount(model, sender);
	}
	
	@RequestMapping("/search")
	public String searchAC() {
		return "searchAccount";
	}
}
