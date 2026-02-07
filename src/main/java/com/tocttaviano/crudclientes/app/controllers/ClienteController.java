package com.tocttaviano.crudclientes.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tocttaviano.crudclientes.app.models.Cliente;
import com.tocttaviano.crudclientes.app.services.IClienteService;

@Controller
public class ClienteController {

	private final IClienteService clienteService;
	private final Logger logger;
	
	public ClienteController(IClienteService clienteService) {
		this.clienteService = clienteService;
		this.logger = LoggerFactory.getLogger(ClienteController.class);
	}
	
	@GetMapping({"/", "/index", "/listar"})
	public String listar(Model model) {
		model.addAttribute("clientes", clienteService.listar());
		return "index";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "crearForm";
	}
	
	@PostMapping("/crear")
	public String guardar(Cliente cliente) {
		logger.info("Nuevo cliente: " + cliente);
		return "redirect:/index";
	}
}
