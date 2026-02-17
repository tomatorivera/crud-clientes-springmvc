package com.tocttaviano.crudclientes.app.controllers;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/login")
	public String login(
			Model model, 
			Principal principal, 
			RedirectAttributes mensajeria,
			@RequestParam(required = false) String error,
			@RequestParam(required = false) String logout,
			Locale locale
	){
		// Si el usuario ya ha iniciado sesión, redirige a la página de inicio
		if (principal != null) {
			mensajeria.addFlashAttribute("mensajeError", messageSource.getMessage("Text.login.error.tieneSesion", null, locale));
			return "redirect:/";
		}
		
		// Si se ha producido un error de autenticación, muestra un mensaje de error
		if (error != null) {
			model.addAttribute("mensajeError", messageSource.getMessage("Text.login.error.credencialesIncorrectas", null, locale));
		}
		
		// Si llega la bandera de logout, cierro sesión del usuario
		if (logout != null) {
			model.addAttribute("mensajeExito", messageSource.getMessage("Text.login.exito.cerrarSesion", null, locale));
		}
		
		return "auth/login";
	}
	
}
