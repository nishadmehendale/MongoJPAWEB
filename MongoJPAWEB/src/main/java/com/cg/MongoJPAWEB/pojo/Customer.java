package com.cg.MongoJPAWEB.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "CustomersWEB")
public class Customer{
	@Id
	private ObjectId id;
	private String name;
	private int customerId;
	public Customer(String name, int customerId) { 
		this.name = name;
		this.customerId = customerId;
	}
	public Customer() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int employeeId) {
		this.customerId = employeeId;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", customerId=" + customerId + "]";
	}
	
}
