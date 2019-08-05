package com.docemonos.springcruddemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.docemonos.springcruddemo.dto.EmployeeDTO;
import com.docemonos.springcruddemo.mapper.EmployeeMapper;
import com.docemonos.springcruddemo.modelo.Employee;
import com.docemonos.springcruddemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeMapper mapper;
	
	@GetMapping(value = "/primero", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeDTO devuelvePrimero() {
		
		EmployeeDTO employee = new EmployeeDTO(1L, "Juan", "Lopez", 23, 1200.00, true);
		return employee;
	}
	
    @GetMapping(value = "/all",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<EmployeeDTO> getAll(@RequestParam(defaultValue = "0", required = false) Integer page,
	                              @RequestParam(defaultValue = "10", required = false) Integer size) {
        return mapper.employeeListDaoToDto(this.employeeService.findAll(PageRequest.of(page,size)));
    }
	
	@GetMapping("/{id}")
	public EmployeeDTO findById(@PathVariable("id") Long idEmployee) throws Exception {
		return mapper.employeeDaoToDto(employeeService.findById(idEmployee));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public EmployeeDTO addEmploy(@RequestBody EmployeeDTO employee) {
		return mapper.employeeDaoToDto(employeeService.addEmployee(employee));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void updateEmployee(@PathVariable("id") Long idEmployee
								, @RequestBody EmployeeDTO employeeData) throws Exception {
		
		employeeService.updateEmployee(idEmployee, employeeData);
		
	}
	

	
}
