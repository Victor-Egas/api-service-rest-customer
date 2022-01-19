package com.cuenta.bancaria.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuenta.bancaria.model.CuentaBancaria;
import com.cuenta.bancaria.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsumeApi {
	
	@Autowired
	private WebClient client;
	
	public Flux<Customer> findAll() {
		return client.get()
				.uri("/findAll")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMapMany(response -> response.bodyToFlux(Customer.class));
	}	

	
	public Mono<Customer> findByExists(String dni){
		return client.get()
				.uri("/findAll")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMap(response -> response.bodyToMono(Customer.class))
				.doOnNext(customer -> System.out.println("nombre : "+customer.getFirstName()))
				.filter(customer -> customer.getDocument().equals(dni));
		
	}
	/*	public Flux<CuentaAhorro> findById(String id) {
		Flux<CuentaAhorro> fx=findAll();
		System.out.println("consume");
		fx.filter(c -> c.getCustomer().getId().equals(id))
		.subscribe(c -> System.out.println(c.getCustomer().getFirstName() + "HOLA"));
		return 
				findAll().filter(cuenta -> cuenta.getCustomer().getId().equals(id))
				.defaultIfEmpty(new CuentaAhorro())
				.doOnNext(cuenta -> System.out.println("idClass : "+cuenta.getId()));
				
						
				
			client.get()
				.uri("/findById/"+id)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMap(response -> response.bodyToMono(CuentaAhorro.class));
	}*/
	
}
