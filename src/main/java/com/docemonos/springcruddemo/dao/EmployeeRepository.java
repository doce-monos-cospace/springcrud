package com.docemonos.springcruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.docemonos.springcruddemo.modelo.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
	
	List<Employee> findEmployeesByActiveTrueAndSalaryBetweenOrderByNameAscSurnameAsc(Double min, Double max);
	
    @Query(value = "Select count(e) from Employee e where e.salary< :minValue and e.active=true ")
    Long totalEmployeeSalaryLess(@Param("minValue") Double minSalary);

}
