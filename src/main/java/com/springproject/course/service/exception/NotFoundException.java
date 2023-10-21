package com.springproject.course.service.exception;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundException(Object id) {
		super("Não achou MALUCO HAHAHA id:  " + id);
	}

}
