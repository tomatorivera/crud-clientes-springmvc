package com.tocttaviano.crudclientes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tocttaviano.crudclientes.app.models.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> // <-- Permite implementar paginación y CRUD
{ }