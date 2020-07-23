package com.loja.desafio.api.exception;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.loja.desafio.domain.service.exception.DuplicidadeNomeException;
import com.loja.desafio.domain.service.exception.DuplicidadeRGException;
import com.loja.desafio.domain.service.exception.EntidadeEmUsoException;
import com.loja.desafio.domain.service.exception.EntidadeInvalidaException;
import com.loja.desafio.domain.service.exception.QuantidadeInsuficiente;

import lombok.Getter;
import lombok.Setter;

@ControllerAdvice
public class LivroExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = camposComErro(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, status, request);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		String mensagemUsu = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
		String mensagemDev = ex.getMessage();
		return handleExceptionInternal(ex, new Erro(mensagemUsu, mensagemDev), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(DuplicidadeRGException.class)
	public ResponseEntity<Object> handleDuplicidadeException(DuplicidadeRGException ex, WebRequest request) {
		String mensagemUsu = messageSource.getMessage("recurso.campo-duplicado-rg", null, LocaleContextHolder.getLocale());
		String mensagemDev = ExceptionUtils.getRootCauseMessage(ex);
		return handleExceptionInternal(ex, new Erro(mensagemUsu, mensagemDev), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(DuplicidadeNomeException.class)
	public ResponseEntity<Object> handleDuplicidadeException(DuplicidadeNomeException ex, WebRequest request) {
		String mensagemUsu = messageSource.getMessage("recurso.campo-duplicado-nome", null, LocaleContextHolder.getLocale());
		String mensagemDev = ExceptionUtils.getRootCauseMessage(ex);
		return handleExceptionInternal(ex, new Erro(mensagemUsu, mensagemDev), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(QuantidadeInsuficiente.class)
	public ResponseEntity<Object> handleDuplicidadeException(QuantidadeInsuficiente ex, WebRequest request) {
		String mensagemUsu = messageSource.getMessage("recurso.entidade-quantidade", null, LocaleContextHolder.getLocale());
		String mensagemDev = ExceptionUtils.getRootCauseMessage(ex);
		return handleExceptionInternal(ex, new Erro(mensagemUsu, mensagemDev), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(EntidadeInvalidaException.class)
	public ResponseEntity<Object> handleEntidadeInvalidaException(EntidadeInvalidaException ex, WebRequest request) {
		String mensagemUsu = messageSource.getMessage("recurso.entidade-nao-existe", null, LocaleContextHolder.getLocale());
		String mensagemDev = ex.toString();
		return handleExceptionInternal(ex, new Erro(mensagemUsu, mensagemDev), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<Object> handleEntidadeEmUsoException(EntidadeEmUsoException ex, WebRequest request) {
		String mensagemUsu = messageSource.getMessage("recurso.entidade-em-uso", null, LocaleContextHolder.getLocale());
		String mensagemDev = ExceptionUtils.getRootCauseMessage(ex);
		return handleExceptionInternal(ex, new Erro(mensagemUsu, mensagemDev), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> camposComErro(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<Erro>();
		for(FieldError field: bindingResult.getFieldErrors()) {
			String mensagemUsu = messageSource.getMessage(field, LocaleContextHolder.getLocale());
			String menStringDev = field.toString();
			erros.add(new Erro(mensagemUsu, menStringDev));
		}
		return erros;
	}
	
	@Getter
	@Setter
	public static class Erro {
		
		private String mensagemUsu;
		private String mensagemDev;
		
		public Erro(String mensagemUsu, String mensagemDev) {
			this.mensagemUsu = mensagemUsu;
			this.mensagemDev = mensagemDev;
		}		
		
	}
}
