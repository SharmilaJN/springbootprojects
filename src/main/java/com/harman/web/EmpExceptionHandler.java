package com.harman.web;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harman.dto.ErrorMsg;
import com.harman.exception.EmpNotFoundException;
import com.harman.exception.IdAlreadyExistsException;

@RestControllerAdvice
public class EmpExceptionHandler {
	
	@ExceptionHandler(EmpNotFoundException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ErrorMsg handleEmpNotfoundException (EmpNotFoundException ex) {
		return new ErrorMsg(ex.getMessage(),HttpStatus.CONFLICT.toString());
	}
		
	@ExceptionHandler(IdAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
	public ErrorMsg handleIdAlreadyExists (IdAlreadyExistsException ex) {
		return new ErrorMsg(ex.getMessage(),HttpStatus.NOT_ACCEPTABLE.toString());	
}
}
