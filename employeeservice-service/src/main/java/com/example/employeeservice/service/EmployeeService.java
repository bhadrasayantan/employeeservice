package com.example.employeeservice.service;

import java.util.List;

import com.example.employeeservice.dto.EmployeeDTO;
import com.example.employeeservice.dto.EmployeeRevisionDTO;

public interface EmployeeService {
	public List<EmployeeDTO> getAllEmployees();
	public EmployeeDTO getEmployee(Integer employeeId);
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
	public void deleteEmployee(Integer employeeId);
	public List<EmployeeRevisionDTO> getRevisions(Integer employeeId);
}
