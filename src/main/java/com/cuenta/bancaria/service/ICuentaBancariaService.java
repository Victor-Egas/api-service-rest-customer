package com.cuenta.bancaria.service;

import com.cuenta.bancaria.model.CuentaBancaria;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICuentaBancariaService {

	public Flux<CuentaBancaria> findAll();
	
	public Mono<CuentaBancaria> findById(String id);
	
	public Mono<CuentaBancaria> save(CuentaBancaria cuentaBancaria);
	
	public Mono<Void> delete(CuentaBancaria cuentaBancaria);
	
	public Mono<CuentaBancaria> update(CuentaBancaria cuentaBancaria);
	
}
