package com.product.web.controller.exhandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.product.model.service.ProductNotFoundException;

@RestController // contrl+resbody
@ControllerAdvice
public class ExceptionHandlerRestCntrl extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails details = new ErrorDetails("validation failed", LocalDate.now(), ex.getBindingResult().toString(),
				"https://www.hcl.com/custcare");
		return new ResponseEntity<Object>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlebookNotFoundEx(ProductNotFoundException ex, WebRequest req) {
		

		ErrorDetails details1 = new ErrorDetails("product  not found", LocalDate.now(), req.getDescription(false),
				"https://www.hcl.com/custCare");
		return new ResponseEntity<ErrorDetails>(details1, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> AllOtherException(Exception ex, WebRequest req) {

		ErrorDetails details = new ErrorDetails("product  not found", LocalDate.now(), req.getDescription(false),
				"https://www.hcl.com/custCare");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
