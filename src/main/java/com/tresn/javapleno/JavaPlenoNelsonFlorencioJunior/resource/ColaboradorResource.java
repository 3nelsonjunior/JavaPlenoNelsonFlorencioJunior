package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.dto.ColaboradorDTO;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Colaborador;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service.ColaboradorService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping("/lista")
	@ResponseStatus(HttpStatus.OK)
	public List<Colaborador> findAll() {
		return colaboradorService.findAll();
	}
	
	@GetMapping("/page")
	@ResponseStatus(HttpStatus.OK)
	public Page<Colaborador> getPage(
			@RequestParam(value = "nome", required = false) String nome,
			Pageable pageable) {
		return colaboradorService.findPage(nome, pageable);
	}
	
	@GetMapping("/lista-por-setor")
	@ResponseStatus(HttpStatus.OK)
	public List<ColaboradorDTO> findBySetorDTO(@RequestParam(value = "setorId", required = false) String setorId) {
		return colaboradorService.findBySetorDTO(setorId);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Colaborador getId(@PathVariable("id") String id) {
		return colaboradorService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Colaborador post(@Valid @RequestBody Colaborador colaborador) {
		return colaboradorService.save(colaborador);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Colaborador put(@RequestBody Colaborador colaborador, @PathVariable("id") String id) {
		return colaboradorService.update(id, colaborador);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		colaboradorService.delete(id);
	}
	
	@DeleteMapping("/deletar-por-setor")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAllBySetor(@PathVariable("setorId") String setorId) {
		colaboradorService.deleteAllBySetor(setorId);
	}
	

}
