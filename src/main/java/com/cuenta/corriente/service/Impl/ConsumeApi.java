package com.cuenta.corriente.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuenta.corriente.model.CuentaAhorro;
import com.cuenta.corriente.model.CuentaCorriente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConsumeApi {
	
	@Autowired
	private WebClient client;
	
	public Flux<CuentaAhorro> findAll() {
		return client.get()
				.uri("/findAll")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMapMany(response -> response.bodyToFlux(CuentaAhorro.class));
	}	

	public Flux<CuentaAhorro> findById(String id) {
		/*Flux<CuentaAhorro> fx=findAll();
		System.out.println("consume");
		fx.filter(c -> c.getCustomer().getId().equals(id))
		.subscribe(c -> System.out.println(c.getCustomer().getFirstName() + "HOLA"));*/
		return 
				findAll().filter(cuenta -> cuenta.getCustomer().getId().equals(id))
				.defaultIfEmpty(new CuentaAhorro())
				.doOnNext(cuenta -> System.out.println("idClass : "+cuenta.getId()));
				
						
				
			/*	client.get()
				.uri("/findById/"+id)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMap(response -> response.bodyToMono(CuentaAhorro.class));*/
	}
	
}
