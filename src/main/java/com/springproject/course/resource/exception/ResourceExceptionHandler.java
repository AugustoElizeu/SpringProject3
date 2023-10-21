package com.springproject.course.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springproject.course.service.exception.DBException;
import com.springproject.course.service.exception.NotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //Intercepta as excesões e da um possível tratamento
public class ResourceExceptionHandler {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> resouceNotFound(NotFoundException e, HttpServletRequest request){
		String error = "Não achou MALUCO HAHAHA id:";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(DBException.class)
	public ResponseEntity<StandardError> database(DBException e, HttpServletRequest request){
		String error = "Banco Explodiu meu nobre";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
