package com.ninja.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ninja.entity.Ninja;

@Repository(value="ninjaRepository")
public interface NinjaRepository extends CrudRepository<Ninja, Integer> {
		public Iterable<Ninja> findAll();
		public Optional<Ninja> findById(Integer Id);	
		public Optional<Ninja> findByName(String name);
}
