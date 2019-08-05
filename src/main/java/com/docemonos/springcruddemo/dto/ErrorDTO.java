package com.docemonos.springcruddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {

	private Integer codigo;
	private String mensaje;
	
}
