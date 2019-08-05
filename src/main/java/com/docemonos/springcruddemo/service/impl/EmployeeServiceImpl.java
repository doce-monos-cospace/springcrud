package com.docemonos.springcruddemo.service.impl;

import java.util.Date;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.docemonos.springcruddemo.dao.EmployeeRepository;
import com.docemonos.springcruddemo.dto.EmployeeDTO;
import com.docemonos.springcruddemo.modelo.Employee;
import com.docemonos.springcruddemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee findById(Long id) throws Exception {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new Exception("Error: Employee con id '" + id + "' inexistente"));
	}

	@Override
	public List<Employee> findAll(Pageable pageSize) {
		int page = pageSize.getPageNumber();
		int size = pageSize.getPageSize();
		return employeeRepository.findAll(PageRequest.of(page, size))
					.getContent();

	}

	@Override
	public Employee addEmployee(EmployeeDTO employee) {
		Employee employeeNew = new Employee();
		
		employeeNew.setName(employee.getName());
		employeeNew.setSurname(employee.getSurname());
		employeeNew.setAge(employee.getAge());
		employeeNew.setSalary(employee.getSalary());
		employeeNew.setActive(employee.getActivo());
		
		return employeeRepository.save(employeeNew);
		
		
	}

	@Override
	public void updateEmployee(Long idSearch, EmployeeDTO employee) throws Exception {
		Employee employeeSearch = this.findById(idSearch);
		
		employeeSearch.setName(employee.getName());
		employeeSearch.setSurname(employee.getSurname());
		employeeSearch.setAge(employee.getAge());
		employeeSearch.setSalary(employee.getSalary());
		employeeSearch.setActive(employee.getActivo());
		employeeSearch.setDateUpdated(new Date());
		
		employeeRepository.save(employeeSearch);
		
	}

	@Override
	public void deleteEmployee(Long id) throws Exception {
		Employee employee = this.findById(id);
		employeeRepository.delete(employee);
		
	}

	@Override
	public List<Employee> allActiveSalaryBetween(Double min, Double max) {
		return employeeRepository.findEmployeesByActiveTrueAndSalaryBetweenOrderByNameAscSurnameAsc(min, max);
	}

	@Override
	public Long allSalaryLess(Double Salary) {
		return employeeRepository.totalEmployeeSalaryLess(Salary);
	}

}
