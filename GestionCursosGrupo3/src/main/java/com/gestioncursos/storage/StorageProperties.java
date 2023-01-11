package com.gestioncursos.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix="storage")

public class StorageProperties {
	
	private String location = "src/main/resources/static/resources";	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
