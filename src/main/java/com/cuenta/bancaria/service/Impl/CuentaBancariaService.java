package com.cuenta.bancaria.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cuenta.bancaria.model.CuentaBancaria;
import com.cuenta.bancaria.repository.CuentaBancariaRepository;
import com.cuenta.bancaria.service.ICuentaBancariaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CuentaBancariaService implements ICuentaBancariaService {

	@Autowired
	private CuentaBancariaRepository repo;
	
	@Override
	public Flux<CuentaBancaria> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<CuentaBancaria> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<CuentaBancaria> save(CuentaBancaria cuentaBancaria) {
		return repo.save(cuentaBancaria)
				.doOnNext(cuenta -> System.out.println("id : "+cuenta.getId()));
	}

	@Override
	public Mono<Void> delete(CuentaBancaria cuentaBancaria) {
		return repo.delete(cuentaBancaria);
	}

	@Override
	public Mono<CuentaBancaria> update(CuentaBancaria cuentaBancaria) {
		return repo.save(cuentaBancaria);
	}

}
