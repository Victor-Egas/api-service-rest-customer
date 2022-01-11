package com.cuenta.corriente.service;

import com.cuenta.corriente.model.CuentaCorriente;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICuentaCorrienteService {

public Flux<CuentaCorriente> findAll();
	
	public Mono<CuentaCorriente> findById(String id);
	
	public Mono<CuentaCorriente> save(CuentaCorriente CuentaCorriente);
	
	public Mono<Void> delete(CuentaCorriente CuentaCorriente);
	
	public Mono<CuentaCorriente> update(CuentaCorriente CuentaCorriente);
	
}
