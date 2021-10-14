package com.sendotp.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.NotFoundException;

@RestControllerAdvice
public class ErrorAdvice {
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiError handleNotFoundException(NotFoundException e, HttpServletRequest request) {
		ApiError error = new ApiError(404, e.getMessage(), request.getServletPath());
		return error;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleMethodArgNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		ApiError error = new ApiError(404, e.getMessage(), request.getServletPath());
		BindingResult bindingResult = e.getBindingResult();
		Map<String, String> validationErrors = new HashMap<>();
		for(FieldError fieldError: bindingResult.getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validationErrors);
		return error;
	}
}