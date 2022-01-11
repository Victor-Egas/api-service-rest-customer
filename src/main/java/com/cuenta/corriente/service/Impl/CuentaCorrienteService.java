package com.cuenta.corriente.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuenta.corriente.model.CuentaCorriente;
import com.cuenta.corriente.repository.CuentaCorrienteRepository;
import com.cuenta.corriente.model.CuentaCorriente;
import com.cuenta.corriente.service.ICuentaCorrienteService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CuentaCorrienteService implements ICuentaCorrienteService {

	@Autowired
	private CuentaCorrienteRepository repo;
	
	@Override
	public Flux<CuentaCorriente> findAll() {
		return repo.findAll();
	}

	@Override
	public Mono<CuentaCorriente> findById(String id) {
		return repo.findById(id);
	}

	@Override
	public Mono<CuentaCorriente> save(CuentaCorriente cuentaCorriente) {
		return repo.save(cuentaCorriente);
	}

	@Override
	public Mono<Void> delete(CuentaCorriente cuentaCorriente) {
		return repo.delete(cuentaCorriente);
	}

	@Override
	public Mono<CuentaCorriente> update(CuentaCorriente cuentaCorriente) {
		return repo.save(cuentaCorriente);
	}

}
