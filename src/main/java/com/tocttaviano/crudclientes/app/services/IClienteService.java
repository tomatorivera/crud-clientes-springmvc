package com.tocttaviano.crudclientes.app.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.tocttaviano.crudclientes.app.models.Cliente;

public interface IClienteService {
	List<Cliente> listar();
	Page<Cliente> listarPaginado(int numeroPagina, int tamanioPagina);
	Cliente guardar(Cliente cliente, MultipartFile foto) throws IOException;
	Optional<Cliente> buscarPorId(Long id);
	void eliminar(Cliente cliente) throws IOException;
}
