package com.hou.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.hou.spring.domain.EmployeeDO;

public interface EmployeeRepository extends CrudRepository<EmployeeDO, Long>{

}
