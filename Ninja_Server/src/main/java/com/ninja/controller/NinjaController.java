package com.ninja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.dto.NinjaDTO;
import com.ninja.exception.NinjaException;
import com.ninja.service.NinjaServiceImpl;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class NinjaController {

	@Autowired
	private NinjaServiceImpl ninjaService;
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/register/ninja")		   //  http://localhost:8080/api/register/ninja
	public ResponseEntity<String> addNinja(@RequestBody NinjaDTO ninjaDTO) throws NinjaException{
		Integer ninjaId = ninjaService.addNinja(ninjaDTO);
		String message = environment.getProperty("API.INSERT_SUCCESS") + ninjaId;
        return new ResponseEntity<>(message,  HttpStatus.OK);
	}
	

	@GetMapping(value = "/ninjas/{Id}")            //  http://localhost:8080/api/ninjas/{Id}
	public ResponseEntity<NinjaDTO> getNinja(@PathVariable Integer Id) throws NinjaException{
			NinjaDTO ninjaDTO = ninjaService.findById(Id);
			return new ResponseEntity<>(ninjaDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/ninjas")            //  http://localhost:8080/api/ninjas
	public ResponseEntity<List<NinjaDTO>> getAllNinjas() throws NinjaException{
		    List<NinjaDTO> ninjaList = ninjaService.getAllNinjas();
			return new ResponseEntity<>(ninjaList, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/edit")
	public ResponseEntity<String> modifyNinja(@RequestBody NinjaDTO ninjaDTO)
			throws NinjaException {
		
		ninjaService.modifyNinja(ninjaDTO.getName(), ninjaDTO.getDesignation());
		String message = environment.getProperty("NinjaAPI.UPDATE_SUCCESS");
		return new ResponseEntity<>(message, HttpStatus.OK);

	}
	

	@GetMapping(value="/test")                    //  http://localhost:8080/api/test
	public ResponseEntity<String> testHitAPI(){
		String testMessage = ninjaService.testHitAPI();
		return new ResponseEntity<>(testMessage, HttpStatus.OK);
	}
	
}