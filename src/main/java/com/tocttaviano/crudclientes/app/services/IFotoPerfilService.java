package com.tocttaviano.crudclientes.app.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFotoPerfilService {
	String guardarFotoPerfil(MultipartFile foto) throws IOException;
}
