package com.ninja.service;

import java.util.List;

import com.ninja.dto.NinjaDTO;
import com.ninja.exception.NinjaException;

public interface NinjaService {
	public Integer addNinja(NinjaDTO ninja) throws NinjaException;
	public NinjaDTO findById(Integer ninjaId) throws NinjaException;
	public List<NinjaDTO> getAllNinjas() throws NinjaException;
	public void modifyNinja( String name, String designation ) throws NinjaException;
	
	//TEST FUNCTION
	public String testHitAPI();
}
