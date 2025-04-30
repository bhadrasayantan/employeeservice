package com.example.employeeservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public record EmployeeDTO(
		Integer employeeId,
		@NotBlank(message = "First Name should not be blank")
		@Size(min = 8,max=50,message="First Name should be minimum 8 characters and maximum 50 chacters long")
		String firstName,
		@NotBlank(message = "Last Name should not be blank")
		@Size(min = 8,max=50,message="Last Name should be minimum 8 characters and maximum 50 chacters long")
		String lastName,
		@NotNull(message = "Date of Birth should not be blank")
		@Past(message = "Date of Birth should be in the past")
		LocalDate dob,
		String createdBy,
		String modifiedBy,
		LocalDateTime createdOn,
		LocalDateTime modifiedOn) {
	public EmployeeDTO(){
		this(null,null,null,null,null,null,null,null);
	}
	public EmployeeDTO(Integer employeeId,String firstName,String lastName,LocalDate dob){
		this(employeeId,firstName,lastName,dob,null,null,null,null);
	}
}
