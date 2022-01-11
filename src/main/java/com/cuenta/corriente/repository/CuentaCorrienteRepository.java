package com.cuenta.corriente.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cuenta.corriente.model.CuentaCorriente;

public interface CuentaCorrienteRepository extends ReactiveMongoRepository<CuentaCorriente, String> {

}
