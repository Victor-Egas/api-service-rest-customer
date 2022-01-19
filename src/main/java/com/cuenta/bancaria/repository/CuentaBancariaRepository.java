package com.cuenta.bancaria.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cuenta.bancaria.model.CuentaBancaria;

public interface CuentaBancariaRepository extends ReactiveMongoRepository<CuentaBancaria, String> {

}
