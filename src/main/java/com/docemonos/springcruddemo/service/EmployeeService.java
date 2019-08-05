package com.docemonos.springcruddemo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.docemonos.springcruddemo.dto.EmployeeDTO;
import com.docemonos.springcruddemo.modelo.Employee;

public interface EmployeeService {

	Employee findById(Long id) throws Exception;
	
	List<Employee> findAll(Pageable pageSize);
	
	Employee addEmployee(EmployeeDTO employee);
	
	void updateEmployee(Long idSearch, EmployeeDTO employee) throws Exception;
	
	void deleteEmployee(Long id) throws Exception;
	
	List<Employee> allActiveSalaryBetween(Double min, Double max);
	
	Long allSalaryLess(Double Salary);
	
	
}
