package com.cuenta.corriente.controller;

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

import com.cuenta.corriente.model.CuentaCorriente;
import com.cuenta.corriente.service.ICuentaCorrienteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/cuentaCorriente")
public class CuentaCorrienteController {


	@Autowired
	private ICuentaCorrienteService service;
	
	@GetMapping("/findAll")
	public Mono<ResponseEntity<Flux<CuentaCorriente>>> findAll(){
		Flux<CuentaCorriente> fxCuentaCorriente=service.findAll();
		return Mono.just(ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fxCuentaCorriente)
				);
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<CuentaCorriente>> findById(@PathVariable String id){
		return  service.findById(id).map(c -> ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public Mono<ResponseEntity<CuentaCorriente>> insert(@RequestBody CuentaCorriente CuentaCorriente , final ServerHttpRequest req){
		return service.save(CuentaCorriente)
				.map(c -> ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(c.getId())))
						.contentType(MediaType.APPLICATION_JSON)
						.body(c)
						);
	}
	
	@PutMapping
	public Mono<ResponseEntity<CuentaCorriente>> update(@RequestBody CuentaCorriente CuentaCorriente ){
		return service.update(CuentaCorriente)
				.map(c -> ResponseEntity
						.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(c)
						);
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
		return service.findById(id).flatMap(c ->{
			return service.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	
}
