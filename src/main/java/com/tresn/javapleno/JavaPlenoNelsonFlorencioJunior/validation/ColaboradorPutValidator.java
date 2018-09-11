package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.exception.FieldMessage;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Colaborador;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service.ColaboradorService;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.validation.interfaceValidation.ColaboradorPost;


public class ColaboradorPutValidator implements ConstraintValidator<ColaboradorPost, Colaborador> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ColaboradorService colaboradorService;

	@Override
	public void initialize(ColaboradorPost ann) {

	}

	@Override
	public boolean isValid(Colaborador colaboradorEditado, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String uriId = map.get("id");

		List<FieldMessage> list = new ArrayList<>();
		Colaborador colAux = new Colaborador();

		// validações campo nome*
		if (colaboradorEditado.getNome() == null || colaboradorEditado.getNome().trim().length() == 0) {
			list.add(new FieldMessage("nome", "Campo nome não pode ser nulo!"));
		} else if (colaboradorEditado.getNome().length() > 50) {
			list.add(new FieldMessage("nome", "Tamanho máximo do campo 'nome' igual 50 caracteres"));
		}
		

		// validações campo cpf*
		colAux = new Colaborador();
		colAux = colaboradorService.findByOneStringValidation("cpf", colaboradorEditado.getCpf());
		if (colAux != null && !colAux.getId().equals(uriId)) {
			list.add(new FieldMessage("cpf", "Valor 'apelido' já existente na base de dados!"));
		} else if (colaboradorEditado.getCpf() == null || colaboradorEditado.getCpf().trim().length() == 0) {
			list.add(new FieldMessage("cpf", "Campo 'cpf' não pode ser nulo!"));
		} else if (colaboradorEditado.getCpf().length() > 20) {
			list.add(new FieldMessage("cpf", "Tamanho máximo do campo 'cpf' igual 11 caracteres!"));
		}


		// validações campo email
		colAux = new Colaborador();
		colAux = colaboradorService.findByOneStringValidation("email", colaboradorEditado.getEmail());
		if (colAux != null && !colAux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Valor 'email' já existente na base de dados!"));
		} else if (colaboradorEditado.getEmail().length() > 50) {
			list.add(new FieldMessage("email", "Tamanho máximo do campo 'email' igual 50 caracteres"));
		} else if (colaboradorEditado.getEmail().trim().length() < 7) {
			list.add(new FieldMessage("email", "Tamanho mínimo do campo 'email' igual 7 caracteres"));
		} else if (!validateEmail(colaboradorEditado.getEmail())) {
			list.add(new FieldMessage("email", "Campo 'email' inválido!"));
		}
		
		// validações campo setor
		if (colaboradorEditado.getSetor() == null || colaboradorEditado.getTelefone().trim().length() == 0) {
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
		Pattern p = Pattern.compile(".+@.+\\.[A-Za-z0-9]+");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();
		return matchFound;
	}

}
