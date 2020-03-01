package com.lopes.curso.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lopes.curso.domain.Cliente;
import com.lopes.curso.domain.enums.TipoCliente;
import com.lopes.curso.dto.ClienteNewDTO;
import com.lopes.curso.repositories.ClienteRepository;
import com.lopes.curso.resources.exceptions.FieldMessage;
import com.lopes.curso.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repository;
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid (ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCpf(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","Cpf inválido"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCnpj(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","Cnpj inválido"));
		}
		
		Cliente aux = repository.findByEmail(objDto.getEmail());
		
		if(aux != null) {
			list.add(new FieldMessage("email","email já existente"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
