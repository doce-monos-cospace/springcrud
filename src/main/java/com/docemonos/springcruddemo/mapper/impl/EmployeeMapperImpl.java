package com.docemonos.springcruddemo.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.docemonos.springcruddemo.dto.EmployeeDTO;
import com.docemonos.springcruddemo.mapper.EmployeeMapper;
import com.docemonos.springcruddemo.modelo.Employee;

@Component
public class EmployeeMapperImpl implements EmployeeMapper{

	@Autowired
	DozerBeanMapper mapper;
	
	@Override
	public EmployeeDTO employeeDaoToDto(Employee employee) {
		return mapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> employeeListDaoToDto(List<Employee> employees) {
		return employees.stream()
				.map(employeeCurrent -> mapper.map(employeeCurrent, EmployeeDTO.class))
				.collect(Collectors.toList());
	}

}
