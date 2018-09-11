package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.resource;

import java.util.List;

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

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Setor;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service.SetorService;


@RestController
@RequestMapping("/setores")
public class SetorResource {
	
	@Autowired
	private SetorService setorService;
	
	
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Setor> getAll() {
		return setorService.findAll();
	}
	
	@GetMapping("/page")
	@ResponseStatus(HttpStatus.OK)
	public Page<Setor> getPage(@RequestParam(value = "descricao", required = false) String descricao, Pageable pageable) {
		return setorService.findPage(descricao, pageable);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Setor getId(@PathVariable("id") String id) {
		return setorService.findById(id);
	}
	

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Setor post(@RequestBody Setor setor) {
		return setorService.save(setor);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Setor put(@RequestBody Setor setor, @PathVariable("id") String id) {
		return setorService.update(id, setor);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		setorService.delete(id);
	}
}
