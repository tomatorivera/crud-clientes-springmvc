package com.tocttaviano.crudclientes.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.tocttaviano.crudclientes.app.models.Cliente;

public interface IClienteService {
	List<Cliente> listar();
	Page<Cliente> listarPaginado(int numeroPagina, int tamanioPagina);
	Cliente guardar(Cliente cliente);
	Optional<Cliente> buscarPorId(Long id);
	void eliminar(Long id);
}
