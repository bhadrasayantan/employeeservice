package com.example.employeeservice.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.exceptions.EmployeeServiceRuntimeException;
import com.example.employeeservice.exceptions.NoDataFoundException;
import com.example.employeeservice.repo.employee.EmployeeRepository;
import com.example.employeeservice.dto.EmployeeDTO;
import com.example.employeeservice.dto.EmployeeRevisionDTO;
import com.example.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional(transactionManager = "txJpa")
	public List<EmployeeDTO> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.size() == 0) {
			throw new NoDataFoundException("Employee", "No Employee Data Found! Add some employees first");
		}
		return employeeList.stream().map(entity -> this.convertEntitytoDTO(entity)).collect(Collectors.toList());
	}

	@Override
	@Transactional(transactionManager = "txJpa")
	public EmployeeDTO getEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
		()->{
				throw new NoDataFoundException("Employee", "No Employee Data found for Employee Id:" + employeeId);
			}
		);
		return this.convertEntitytoDTO(employee);
	}

	@Override
	@Transactional(transactionManager = "txJpa")
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Employee entity = this.convertDTOtoEntity(employeeDTO);
		try {
			employeeRepository.save(entity);
		} catch (Exception ex) {
			if(ex instanceof SQLException) {
				throw new EmployeeServiceRuntimeException("SQL Exception Occurred during adding new employee",ex);
			}
			else {
				throw new EmployeeServiceRuntimeException("An application error occurred",ex);
			}
		}
		return this.convertEntitytoDTO(entity);
	}

	@Override
	@Transactional(transactionManager = "txJpa")
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Employee entity = employeeRepository.findById(employeeDTO.employeeId()).orElseThrow(
				()-> {
					throw new NoDataFoundException("Employee", "No Employee Data Found! Add some employees first");
					}
		);
		entity.setFirstName(employeeDTO.firstName());
		entity.setLastName(employeeDTO.lastName());
		entity.setDob(employeeDTO.dob());
		try {
			employeeRepository.save(entity);
		} catch (Exception ex) {
			if(ex instanceof SQLException) {
				throw new EmployeeServiceRuntimeException("SQL Exception Occurred during updating existing employee",ex);
			}
			else {
				throw new EmployeeServiceRuntimeException("An application error occurred",ex);
			}
		}
		return this.convertEntitytoDTO(entity);
	}

	@Override
	@Transactional(transactionManager = "txJpa")
	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		employeeRepository.findById(employeeId).orElseThrow(
		()->{
			throw new NoDataFoundException("Employee", "No Employee Data found for Employee Id:" + employeeId);
			}		
		);
		employeeRepository.deleteById(employeeId);
	}

	@Override
	@Transactional(transactionManager = "txJpa")
	public List<EmployeeRevisionDTO> getRevisions(Integer employeeId) {
		List<EmployeeRevisionDTO> historyList = new ArrayList<>();
		Revisions<Integer, Employee> revisions = employeeRepository.findRevisions(employeeId);
		revisions.getContent().forEach(revision -> historyList.add(this.convertRevisionEntitytoDTO(revision.getEntity(),
				revision.getMetadata().getRevisionType().name())));
		return historyList;
	}

	private EmployeeDTO convertEntitytoDTO(Employee entity) {
		EmployeeDTO dto = new EmployeeDTO(entity.getEmployeeId(), entity.getFirstName(), entity.getLastName(),
				entity.getDob());
		return dto;
	}

	private EmployeeRevisionDTO convertRevisionEntitytoDTO(Employee entity, String revisionType) {
		EmployeeDTO dto = new EmployeeDTO(entity.getEmployeeId(), entity.getFirstName(), entity.getLastName(),
				entity.getDob(), entity.getCreatedBy(), entity.getModifiedBy(), entity.getCreatedOn(),
				entity.getModifiedOn());
		EmployeeRevisionDTO revisionDTO = new EmployeeRevisionDTO(dto, revisionType);
		return revisionDTO;
	}

	private Employee convertDTOtoEntity(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setEmployeeId(dto.employeeId());
		entity.setFirstName(dto.firstName());
		entity.setLastName(dto.lastName());
		entity.setDob(dto.dob());
		return entity;
	}

}
