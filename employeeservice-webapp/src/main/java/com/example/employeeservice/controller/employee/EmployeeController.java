package com.example.employeeservice.controller.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.dto.EmployeeDTO;
import com.example.employeeservice.dto.EmployeeRevisionDTO;
import com.example.employeeservice.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeDTO>> getallEmployees() {
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Integer employeeId){
		return ResponseEntity.ok().body(employeeService.getEmployee(employeeId));
	}
	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO) {
		LOGGER.info(employeeDTO.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDTO));
	}
	@PutMapping("/update")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody @Valid EmployeeDTO emnployeeDTO) {
		return ResponseEntity.ok().body(employeeService.updateEmployee(emnployeeDTO));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")Integer employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok().body("EmployeeId:"+employeeId+" deleted Successfully");
	}
	@GetMapping("/get/revisions/{id}")
	public ResponseEntity<List<EmployeeRevisionDTO>> getRevisions(@PathVariable("id")Integer employeeId){
		return ResponseEntity.ok().body(employeeService.getRevisions(employeeId));
		
	}
	
}
