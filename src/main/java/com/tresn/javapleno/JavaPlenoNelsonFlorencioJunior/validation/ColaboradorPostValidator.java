package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.FieldMessage;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Colaborador;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service.ColaboradorService;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.validation.interfaceValidation.ColaboradorPost;


public class ColaboradorPostValidator implements ConstraintValidator<ColaboradorPost, Colaborador> {

	@Autowired
	private ColaboradorService colaboradorService;

	@Override
	public void initialize(ColaboradorPost ann) {

	}

	@Override
	public boolean isValid(Colaborador novoColaborador, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		// validações campo nome*
		if (novoColaborador.getNome() == null || novoColaborador.getNome().trim().length() == 0) {
			list.add(new FieldMessage("nome", "Campo 'nome' não pode ser nulo!"));
		} else if (novoColaborador.getNome().length() > 50) {
			list.add(new FieldMessage("nome", "Tamanho máximo do campo 'nome' igual 50 caracteres"));
		} else if (colaboradorService.findExistsString("nome", novoColaborador.getNome()) == true) {
			list.add(new FieldMessage("nome", "Valor 'nome' já existente na base de dados!!!"));
		}

		// validações campo email
		if (novoColaborador.getEmail().length() > 50) {
			list.add(new FieldMessage("email", "Tamanho máximo do campo 'email' igual 50 caracteres"));
		} else if (novoColaborador.getEmail().trim().length() < 7) {
			list.add(new FieldMessage("email", "Tamanho mínimo do campo 'email' igual 7 caracteres"));
		} else if (colaboradorService.findExistsString("email", novoColaborador.getEmail()) == true) {
			list.add(new FieldMessage("email", "Valor 'email' já existente na base de dados!!!"));
		} else if (!validateEmail(novoColaborador.getEmail())) {
			list.add(new FieldMessage("email", "Campo 'email' inválido!"));
		}

		// validações campo telefone
		if (novoColaborador.getTelefone() == null || novoColaborador.getTelefone().trim().length() == 0) {
			list.add(new FieldMessage("telefone", "Campo 'telefone' não pode ser nulo!"));
		} else if (novoColaborador.getTelefone().length() > 20) {
			list.add(new FieldMessage("telefone", "Tamanho máximo do campo 'telefone' igual 20 caracteres!"));
		}
		
		// validações campo setor
		if (novoColaborador.getSetor() == null || novoColaborador.getTelefone().trim().length() == 0) {
			list.add(new FieldMessage("setor", "Campo 'setor' não pode ser nulo!"));
		} 


		// passa cada objeto do FieldMessage para a lista de erros do Framework
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
	
	public boolean validateEmail(String email) {
		Pattern p = Pattern.compile("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();
		return matchFound;
	}

}
