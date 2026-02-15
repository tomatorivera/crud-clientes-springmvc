package com.tocttaviano.crudclientes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tocttaviano.crudclientes.app.models.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> // <-- Permite implementar paginación y CRUD
{ 

	@Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.facturas f WHERE c.id = :id")
	public Cliente findByIdWithFactura(Long id);

}