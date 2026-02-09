package com.tocttaviano.crudclientes.app.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoPerfilServiceImpl implements IFotoPerfilService{

	@Override
	public String guardarFotoPerfil(MultipartFile foto) throws IOException {
		// 1. Generar un nombre único para el archivo
        String nombreUnico = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
        
        // 2. Definir la ruta
        Path rootPath = Paths.get("uploads").resolve(nombreUnico);
        Path rootAbsolutPath = rootPath.toAbsolutePath();
        
        // 2. CREAR LA CARPETA SI NO EXISTE
        File directorio = rootAbsolutPath.getParent().toFile();
        if (!directorio.exists()) {
            directorio.mkdirs(); // Esto crea toda la ruta de carpetas necesaria
        }

        // 3. Guardar el archivo en el sistema de archivos
        Files.copy(foto.getInputStream(), rootAbsolutPath);
        
        return nombreUnico;
	}

}
