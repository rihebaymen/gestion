package com.meta.store.base.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.meta.store.base.Entity.BaseEntity;
import com.meta.store.base.error.RecordNotFoundException;
import com.meta.store.base.repository.BaseRepository;
import com.meta.store.base.security.entity.Role;

import jakarta.persistence.MappedSuperclass;
import lombok.RequiredArgsConstructor;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>,ID extends Number> {

	@Autowired
	private BaseRepository<T, ID> baseRepository;
	
	public List<T> getAll(){
		return  baseRepository.findAll();
	}
	
	public ResponseEntity<T> getById(ID id) {
		Optional<T> entity =  baseRepository.findById(id);
		if(entity.isPresent()) {
			return ResponseEntity.ok(entity.get());
		}else {
			throw new RecordNotFoundException("this record with id: "+id+" not found");
		}
	}
	
	public ResponseEntity<T> insert(T entity) {
		

		baseRepository.save(entity);
		return	new ResponseEntity<T>(HttpStatus.OK);
	}
	
	public ResponseEntity<T> insertAll(List<T> articles){
		baseRepository.saveAll(articles);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public void deleteById(ID id) {
				baseRepository.deleteById(id);
	}

	
	
	
}
