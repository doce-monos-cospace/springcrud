package com.docemonos.springcruddemo.mapper;

import java.util.List;

import com.docemonos.springcruddemo.dto.EmployeeDTO;
import com.docemonos.springcruddemo.modelo.Employee;

public interface EmployeeMapper {

	EmployeeDTO employeeDaoToDto (Employee employee);
	
	List<EmployeeDTO> employeeListDaoToDto ( List<Employee> employees);
	
}
