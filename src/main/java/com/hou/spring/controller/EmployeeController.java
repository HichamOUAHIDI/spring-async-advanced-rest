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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 *  @Api describes the whole controller
	@ApiOperation is used for description on a methods level
	@ApiParam is used for method parameters
 * */


@RestController
@RequestMapping("/v2/employees")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Employee.")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ModelMapper mapper;
	
	@ApiOperation("Returns list of all Employee in the system.")
	 @GetMapping(value="/getAll")
	 public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDO> employeDO = employeeService.getAllEmployees();
		List<EmployeeDTO> employeeDTO = employeDO.stream()
				.map(employe -> mapper.map(employe,EmployeeDTO.class))
				.collect(Collectors.toList());
		 return employeeDTO;
	  }
	@ApiOperation("Returns a specific employee by their identifier. 404 if does not exist.")
	 @GetMapping(value = "getEmp/{employeeId}")
	 public EmployeeDO getEmployee(@PathVariable(name="employeeId") Long empId) throws EntityNotFoundException {
		 return employeeService.getEmployee(empId); 
	 }
	@ApiOperation("Creates a new employee.")
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
	 @ApiOperation("Deletes a employee from the system. 404 if the empolye's identifier is not found.")
	 @DeleteMapping(value = "deleteEmp/{employeeId}")
	    public void deleteEmployee(@PathVariable Long employeeId) throws EntityNotFoundException
	    {
		 employeeService.deleteEmployee(employeeId);
	    }
}
