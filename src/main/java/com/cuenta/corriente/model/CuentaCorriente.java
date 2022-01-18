package com.cuenta.corriente.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="cuentaCorriente")
public class CuentaCorriente {

	@Id
	private String id;
	
	@Field(name="status")
	private String status;
	
	@Field(name="type")
	private String type;
	
	private Customer customer;

	 
	
	public CuentaCorriente( String status, String type, Customer customer) {
		
		this.status = status;
		this.type = type;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [id=" + id + ", status=" + status + ", type=" + type + ", customer=" + customer + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
