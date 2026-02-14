package com.tocttaviano.crudclientes.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tocttaviano.crudclientes.app.models.Factura;

public interface IFacturaRepository extends CrudRepository<Factura, Long>{

}
