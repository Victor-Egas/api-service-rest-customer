package com.cuenta.bancaria.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Document(collection="cuentaBancaria")
public class CuentaBancaria {

	@Id
	private String id;
	
	@Field(name="status")
	private String status;
	
	@Field(name="type")
	private String type;
	
	@Field(name="amount")
	private double amount;
	
	private Customer customer;

	 
	
	public CuentaBancaria( String status, String type, Customer customer) {
		
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

	public double getAmount() {
		return amount;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
