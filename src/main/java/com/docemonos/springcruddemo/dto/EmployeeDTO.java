package com.docemonos.springcruddemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"id","surname","name","age","salary","activo"})
public class EmployeeDTO {

    private Long id;
    @JsonProperty("nombre")
    private String name;
    @JsonProperty("apellidos")
    private String surname;
    @JsonProperty("edad")
    private Integer age;
    @JsonProperty("salario")
    private Double salary;
    @JsonIgnore
    private Boolean activo;
    
    
}
