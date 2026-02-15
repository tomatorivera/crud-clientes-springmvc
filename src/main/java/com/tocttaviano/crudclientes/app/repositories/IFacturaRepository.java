package com.tocttaviano.crudclientes.app.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tocttaviano.crudclientes.app.models.Factura;

public interface IFacturaRepository extends CrudRepository<Factura, Long>{
	
	@Query("SELECT f FROM Factura f JOIN FETCH f.cliente c JOIN FETCH f.items i JOIN FETCH i.producto p WHERE f.id = :id")
	public Factura findFacturaByIdWithClienteWithItemFacturaWithProducto(Long id);
	
}
