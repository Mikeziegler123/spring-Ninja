package com.ninja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ninja.dto.NinjaDTO;
import com.ninja.entity.Ninja;
import com.ninja.exception.NinjaException;
import com.ninja.repository.NinjaRepository;

@Service(value="ninjaService")
@Transactional
public class NinjaServiceImpl implements NinjaService{

	@Autowired
	NinjaRepository ninjaRepository;
	
	//(1)ADD_NINJA( NinjaDTO )
	@Override
	public Integer addNinja(NinjaDTO ninjaDTO) 
			throws NinjaException {
		Ninja newNinja = new Ninja(ninjaDTO.getName(), ninjaDTO.getDesignation());
		
		Ninja response = ninjaRepository.save(newNinja);
		
		Integer Id = response.getId();
		return Id;
	}
	
	//(2)GET_NINJA()
	@Override
	public NinjaDTO findById(Integer ninjaId) throws NinjaException {
		Optional<Ninja> optional = ninjaRepository.findById(ninjaId);
		Ninja ninja = optional.orElseThrow(() -> new NinjaException("Service.NINJA_NOT_FOUND"));
		NinjaDTO ninjaDto = new NinjaDTO();
		ninjaDto.setId(ninja.getId());
		ninjaDto.setName(ninja.getName());
		ninjaDto.setDesignation(ninja.getDesignation());
		return ninjaDto;
	}
	
	//(2b)GET_ALL_NINJAS()
	@Override
	public List<NinjaDTO> getAllNinjas() throws NinjaException {
		Iterable<Ninja> ninjas = ninjaRepository.findAll();
		List<NinjaDTO> ninjaDTOs = new ArrayList<>();
		ninjas.forEach(ninja -> {
			NinjaDTO ninjaDto = new NinjaDTO();
			ninjaDto.setId(ninja.getId());
			ninjaDto.setName(ninja.getName());
			ninjaDto.setDesignation(ninja.getDesignation());
			ninjaDTOs.add(ninjaDto);
		});
		if (ninjaDTOs.isEmpty())
			throw new NinjaException("Service.NINJAS_NOT_FOUND");
		return ninjaDTOs;
	}
	
	//(3)MODIFYNINJA()
		@Override
		public void modifyNinja(String name, String designation)
				throws NinjaException {
			//retrieving ninja details from repository
			Optional<Ninja> optionalNinja = ninjaRepository.findByName(name);
			Ninja ninja2 = optionalNinja.orElseThrow(() -> new NinjaException("Service.NOT_FOUND"));
			//updating name and designation of ninja
			ninja2.setName(name);
			ninja2.setDesignation(designation);
		}
	
	
	
	////TEST SERVICE FUNCTION
	@Override
	public String testHitAPI() {
		String message = "Successfully hit API! - Service - testHitAPI()";
		return message;
	}

}
