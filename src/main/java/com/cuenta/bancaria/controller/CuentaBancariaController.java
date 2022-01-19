package com.cuenta.bancaria.controller;

import java.net.URI;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuenta.bancaria.model.CuentaBancaria;
import com.cuenta.bancaria.model.Customer;
import com.cuenta.bancaria.service.ICuentaBancariaService;
import com.cuenta.bancaria.service.Impl.ConsumeApi;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/cuentaBancaria")
public class CuentaBancariaController {


	@Autowired
	private ICuentaBancariaService service;
	
	@Autowired
	public ConsumeApi repo;
	
	@GetMapping("/findAll")
	public Mono<ResponseEntity<Flux<CuentaBancaria>>> findAll(){
		Flux<CuentaBancaria> fxCuentaBancaria=service.findAll();
		return Mono.just(ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fxCuentaBancaria)
				);
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<CuentaBancaria>> findById(@PathVariable String id){
		return  service.findById(id).map(cuenta -> ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(cuenta))
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public Mono<ResponseEntity<CuentaBancaria>> insert(@RequestBody CuentaBancaria cuentaBancaria , final ServerHttpRequest req){
		return service.save(cuentaBancaria)
				.map(cuenta -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(cuenta.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(cuenta)
						);
	}
	
	@PutMapping
	public Mono<ResponseEntity<CuentaBancaria>> update(@RequestBody CuentaBancaria cuentaBancaria ){
		return service.update(cuentaBancaria)
				.map(cuenta -> ResponseEntity
						.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(cuenta)
						);
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
		return service.findById(id).flatMap(cuenta ->{
			return service.delete(cuenta).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/consume")
	public Mono<ResponseEntity<Flux<Customer>>> listar(){
		Flux<Customer> fxCustomer=repo.findAll();
		return Mono.just(ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fxCustomer)
				);
		
	}
	
	@GetMapping("/customer")
	public Mono<ResponseEntity<Customer>> lista(final ServerHttpRequest req){
		Mono<Customer> fxCustomer=repo.findByExists("46808509");
		return fxCustomer.map(cuenta -> ResponseEntity.created(URI.create(req.getURI().toString()))
				.contentType(MediaType.APPLICATION_JSON)
				.body(cuenta)
				);
		
	}
	
	
	/*
	@PostMapping("/insert")
	public Mono<ResponseEntity<CuentaBancaria>> create(@RequestBody CuentaBancaria cuentaCorriente , final ServerHttpRequest req){
		if(repo.findById(cuentaCorriente.getCustomer().getId()) != null){
			System.out.println("YA EXISTE UNA CUENTA DE AHORROS : "+repo.findById(cuentaCorriente.toString()));
			return null;
		}else {
		
		return service.save(cuentaCorriente)
				.map(c -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(c.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(c)
						);
		}
		
		
	}
	
	@PostMapping("/insertar")
	public Flux<CuentaBancaria> ingresarlo(@RequestBody CuentaBancaria cuentaCorriente )  {
		//if(repo.findById(cuentaCorriente.getCustomer().getId()))
		/*repo.findById(cuentaCorriente.getCustomer().getId())
		.filter(cuenta -> !cuenta.getId().equals(""))
		.doOnNext(cuenta -> System.out.println("nombre : "+cuenta.getCustomer().getFirstName()))
		.subscribe();*/
		//Mono<CuentaCorriente> cuenta=Mono.just(cuentaCorriente);
	/*return	//service.save(cuentaCorriente);
			repo.findById(cuentaCorriente.getCustomer().getId())
				.defaultIfEmpty(new CuentaAhorro())
				.filter(cuenta -> cuenta.getId() == null)
				.map(cuenta -> new CuentaBancaria(cuentaCorriente.getStatus(),cuentaCorriente.getType(),cuenta.getCustomer()))
				.doOnNext(c -> service.save(c));
				
				
				
	}*/
	/*@GetMapping("/consume")
	public Flux<Customer> listar(){
		return repo.findAll();
	}*/ 
	}

