package com.tocttaviano.crudclientes.app.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.tocttaviano.crudclientes.app.models.Cliente;
import com.tocttaviano.crudclientes.app.repositories.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	private final IClienteRepository clienteRepository;
	private final IFotoPerfilService fotoPerfilService;
	
	public ClienteServiceImpl(IClienteRepository clienteRepository, IFotoPerfilService fotoPerfilService) {
		this.clienteRepository = clienteRepository;
		this.fotoPerfilService = fotoPerfilService;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> listar() {
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente, MultipartFile foto) throws IOException {
		if (!foto.isEmpty())
			cliente.setFoto(fotoPerfilService.guardarFotoPerfil(foto));
		
		return clienteRepository.save(cliente);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> buscarPorId(Long id) {
		return clienteRepository.findById(id);
	}
	
	@Override
	@Transactional
	public void eliminar(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> listarPaginado(int numeroPagina, int tamanioPagina) {
		Pageable pageable = PageRequest.of(numeroPagina, tamanioPagina);
		return clienteRepository.findAll(pageable);
	}

}
