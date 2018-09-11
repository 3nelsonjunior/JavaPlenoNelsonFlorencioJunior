package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.type.ObjectNotFoundException;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Setor;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.repository.SetorRepository;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.util.CriteriaBuilder;


@Service
public class SetorService {
	
	@Autowired
	private SetorRepository setorRepository;

	public List<Setor> findAll() {
		return setorRepository.findAll();
	}
	
	public Page<Setor> findPage(String descricao, Pageable pageable) {
		Criteria criteria = new CriteriaBuilder()
				.is("descricao", Optional.ofNullable(descricao)).build();
		return setorRepository.getPage(criteria, pageable);
	}

	public Setor findById(String id) {
		Setor setor = setorRepository.findById(id);
		if (setor != null) {
			return setor;
		} else {
			throw new ObjectNotFoundException("Recurso não encontrado!");
		} 
	}
	
	public Setor save(Setor setor) {
		setor.setId(null);
		return setorRepository.save(setor);
		
	}

	public Setor update(String id, Setor setor) {
		validateExistSetor(id);
		setor.setId(id);
		return setorRepository.save(setor);
	}

	public void delete(String id) {
		validateExistSetor(id);
		Setor setor = findById(id);
		setorRepository.delete(setor);
	}
	
	private boolean validateExistSetor(String id) {
		Criteria criteria = new CriteriaBuilder().is("id", Optional.ofNullable(id)).build();
		if (!setorRepository.findExists(criteria)) {
			throw new ObjectNotFoundException("Recurso não encontrado!");
		} else {
			return true;
		}
	}
	

}
