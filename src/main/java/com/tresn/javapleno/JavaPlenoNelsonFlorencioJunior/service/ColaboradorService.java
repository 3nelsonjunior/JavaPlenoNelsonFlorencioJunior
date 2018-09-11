package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.dto.ColaboradorDTO;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.type.ObjectNotFoundException;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Colaborador;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.repository.ColaboradorRepository;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.util.CriteriaBuilder;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.util.MongoUtil;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public List<Colaborador> findAll() {
		return colaboradorRepository.findAll();
	}
	
	public Page<Colaborador> findPage(String nome, Pageable pageable) {
		Criteria criteria = new CriteriaBuilder()
				.is("nome", Optional.ofNullable(nome)).build();
		return colaboradorRepository.getPage(criteria, pageable);
	}
	
	@SuppressWarnings("null")
	public List<ColaboradorDTO> findBySetorDTO(String setorId) {
		Criteria criteria = new CriteriaBuilder()
				.is("setor.$id", MongoUtil.createObjectId(setorId))
				.build();
		List<Colaborador> listaColaboradores = colaboradorRepository.findAll(criteria);
		List<ColaboradorDTO> listaDTO = null;
		for (Colaborador col : listaColaboradores) {
			listaDTO.add(new ColaboradorDTO(col));
		}
		return listaDTO;
	}
	
	public List<Colaborador> findBySetor(String setorId) {
		Criteria criteria = new CriteriaBuilder()
				.is("setor.$id", MongoUtil.createObjectId(setorId))
				.build();
		return colaboradorRepository.findAll(criteria);
	}
	
	public Colaborador findById(String id) {
		Colaborador colaborador = colaboradorRepository.findById(id);
		if (colaborador != null) {
			return colaborador;
		} else {
			throw new ObjectNotFoundException("Recurso não encontrado!");
		} 
	}
	
	public Colaborador findByOne(String label, String value) {
		Criteria criteria = new CriteriaBuilder()
				.is(label, Optional.ofNullable(value))
				.build();
		Colaborador colaborador = colaboradorRepository.findByOne(criteria);
		if (colaborador != null) {
			return colaborador;
		} else {
			throw new ObjectNotFoundException("Recurso não encontrado!");
		} 
	}
	
	public boolean findExistsString(String label, String value) {
		Criteria criteria = new CriteriaBuilder().is(label, Optional.ofNullable(value)).build();
		return colaboradorRepository.findExists(criteria);

	}
	
	public Colaborador findByOneStringValidation(String label, String value) {
		Criteria criteria = new CriteriaBuilder().is(label, Optional.ofNullable(value)).build();
		Colaborador colaborador = colaboradorRepository.findByOne(criteria);
		return colaborador;
	}
	
	public Colaborador save(Colaborador colaborador) {
		colaborador.setId(null);
		return colaboradorRepository.save(colaborador);
	}

	public Colaborador update(String id, Colaborador colaborador) {
		Colaborador col = colaboradorRepository.findById(id);
		if(col != null) {
			colaborador.setId(col.getId());
		}
		return colaboradorRepository.save(colaborador);
	}

	public void delete(String id) {
		Colaborador colaborador = findById(id);
		colaboradorRepository.delete(colaborador);
	}
	
	public void deleteAllBySetor(String setorId) {
		List<Colaborador> listaColaboradores = findBySetor(setorId);
		for (Colaborador col : listaColaboradores) {
			if(col.getSetor().getId() == setorId) {
				colaboradorRepository.delete(col);
			}
		}
	}
	
}
