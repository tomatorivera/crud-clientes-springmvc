package com.tocttaviano.crudclientes.app.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	
	public ClienteServiceImpl(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
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
		{
			// 1. Generar un nombre único para el archivo
	        String nombreUnico = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
	        
	        // 2. Definir la ruta (puede ser absoluta o relativa)
	        Path rootPath = Paths.get("uploads").resolve(nombreUnico);
	        Path rootAbsolutPath = rootPath.toAbsolutePath();
	        
	        // 2. CREAR LA CARPETA SI NO EXISTE
	        File directorio = rootAbsolutPath.getParent().toFile();
	        if (!directorio.exists()) {
	            directorio.mkdirs(); // Esto crea toda la ruta de carpetas necesaria
	        }

            // 3. Guardar el archivo en el sistema de archivos
            Files.copy(foto.getInputStream(), rootAbsolutPath);
            
            // 4. Guardar el NOMBRE del archivo en la entidad
            cliente.setFoto(nombreUnico);
		}
		
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
