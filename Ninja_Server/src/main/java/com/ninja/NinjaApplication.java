package com.ninja;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.ninja.dto.NinjaDTO;
import com.ninja.service.NinjaServiceImpl;

@SpringBootApplication
public class NinjaApplication implements CommandLineRunner {
	
	public static final Log LOGGER = LogFactory.getLog(NinjaApplication.class);
	
	@Autowired
	NinjaServiceImpl ninjaService;
	
	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(NinjaApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		//addNinja();
		getNinja();
		findAllNinjas();
	}
	
	public Integer addNinja() {
		NinjaDTO ninja = new NinjaDTO();
		ninja.setId(66);
		ninja.setName("Harry");
		ninja.setDesignation("Test-Ninja");
		Integer ninjaId = ninja.getId();
		try {
			ninjaId = ninjaService.addNinja(ninja);
			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS"));
		} catch (Exception e) {
			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
		return ninjaId;
	}
	
	public void getNinja() {
		try {
			NinjaDTO ninja = ninjaService.findById(1);
			LOGGER.info(ninja);
		} catch (Exception e) {
			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
	}
	
	public void findAllNinjas() {
		try {
			ninjaService.getAllNinjas().forEach(LOGGER::info);
		} catch (Exception e) {
			if (e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(),
						"Something went wrong. Please check log file for more details."));
		}
	}
}
