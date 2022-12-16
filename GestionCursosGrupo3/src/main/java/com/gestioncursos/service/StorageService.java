package com.gestioncursos.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	void init();
	
	String store(MultipartFile file, int id);
	
	Stream<Path> loadAll();
	
	Path load(String filename);
	
	Resource loadAsResource(String filename);
	
	void delete(String filename);
	
	void deleteAll();
	

}
