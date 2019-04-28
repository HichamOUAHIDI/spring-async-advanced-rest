package com.hou.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hou.spring.domain.EmployeeDO;
import com.hou.spring.exception.EntityNotFoundException;
import com.hou.spring.mapper.EmployeeDTO;
import com.hou.spring.service.EmailService;
import com.hou.spring.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ModelMapper mapper;
	
	
	 @GetMapping(value="/getAll")
	 public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDO> employeDO = employeeService.getAllEmployees();
		List<EmployeeDTO> employeeDTO = employeDO.stream()
				.map(employe -> mapper.map(employe,EmployeeDTO.class))
				.collect(Collectors.toList());
		 return employeeDTO;
	  }

	 @GetMapping(value = "getEmp/{employeeId}")
	 public EmployeeDO getEmployee(@PathVariable(name="employeeId") Long empId) throws EntityNotFoundException {
		 return employeeService.getEmployee(empId); 
	 }
	 
	 @PostMapping(value = "AddEmp")
	 public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		 System.out.println("Entered in addEmployee with : "+employeeDTO);
		 EmployeeDO employeeDO = mapper.map(employeeDTO, EmployeeDO.class);
		 employeeService.addEmployee(employeeDO);
		 System.out.println("Employee saved into database");
		 emailService.sendMail(employeeDO.getEmail());
		 System.out.println("Exited from addEmployee");
		 return new  ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping(value = "deleteEmp/{employeeId}")
	    public void deleteEmployee(@PathVariable Long employeeId) throws EntityNotFoundException
	    {
		 employeeService.deleteEmployee(employeeId);
	    }
}
