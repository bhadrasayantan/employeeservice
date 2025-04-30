package com.example.employeeservice.controlleradvice;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.employeeservice.exceptions.EmployeeServiceErrorResponse;
import com.example.employeeservice.exceptions.EmployeeServiceRuntimeException;
import com.example.employeeservice.exceptions.NoDataFoundException;
@RestControllerAdvice
public class EmployeeServiceControllerAdvice{
	
	@ExceptionHandler(value=NoDataFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public EmployeeServiceErrorResponse dataNotFoundException(NoDataFoundException ex) {
		return new EmployeeServiceErrorResponse(List.of(ex.getMessage()), LocalDateTime.now(), HttpStatus.NOT_FOUND.name());
		
	}

	@ExceptionHandler(value=EmployeeServiceRuntimeException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public EmployeeServiceErrorResponse employeeRunTimeException(EmployeeServiceRuntimeException ex) {
		return new EmployeeServiceErrorResponse(List.of(ex.getMessage()), LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.name());
		
	}
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public EmployeeServiceErrorResponse invalidArgumentException(MethodArgumentNotValidException  ex) {
		List<String> errorMessage = ex.getFieldErrors().stream().map(field->field.getField()+":"+field.getDefaultMessage()).toList();
		return new EmployeeServiceErrorResponse(errorMessage, LocalDateTime.now(), HttpStatus.BAD_REQUEST.name());
		
	}

}
