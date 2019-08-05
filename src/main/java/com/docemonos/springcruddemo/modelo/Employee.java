package com.docemonos.springcruddemo.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "surname", nullable = false)
	private String surname;
	@Min(16)
	private Integer age;
	@DecimalMin("1000.00")
	private Double salary;
	private Boolean active;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_create")
	private Date dateCreation = new Date() ;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_updated")
	private Date dateUpdated;
	
	
}
