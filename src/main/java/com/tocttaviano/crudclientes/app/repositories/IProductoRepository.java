package com.tocttaviano.crudclientes.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tocttaviano.crudclientes.app.models.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long> {
	
	public List<Producto> findByNombreContaining(String nombre);
	
}
