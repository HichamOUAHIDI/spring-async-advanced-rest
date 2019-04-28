package com.hou.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hou.spring.domain.EmployeeDO;
import com.hou.spring.exception.EntityNotFoundException;
import com.hou.spring.mapper.EmployeeDTO;

public interface EmployeeService {
	
	 public void addEmployee(EmployeeDO employee);
	 public List<EmployeeDO> getAllEmployees();
	 public EmployeeDO getEmployee(Long empId)   throws EntityNotFoundException;
	 public void deleteEmployee(Long employeeId) throws EntityNotFoundException;
	
}
