package com.hou.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hou.spring.domain.EmployeeDO;
import com.hou.spring.exception.EntityNotFoundException;
import com.hou.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void addEmployee(EmployeeDO employee) {
		employeeRepository.save(employee);
	}
	@Override
	public List<EmployeeDO> getAllEmployees() {
		return (List<EmployeeDO>) employeeRepository.findAll();
	}
	@Override
	public EmployeeDO getEmployee(Long empId) throws EntityNotFoundException{
		return employeeRepository.findById(empId).orElseThrow(() 
				-> new EntityNotFoundException("Employee", "empId", empId.toString()));
	}
	@Override
	public void deleteEmployee(Long employeeId) throws EntityNotFoundException {
		EmployeeDO employee = employeeRepository.findById(employeeId).orElseThrow(() 
				-> new EntityNotFoundException("Employee", "empId", employeeId.toString()));
		employeeRepository.delete(employee);
	}
}
