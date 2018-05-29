package com.urlanalysis.api.bean;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidatorExample {
	@NotEmpty(message = "trl cannot be null")
	private String trl;
	@NotEmpty(message = "url cannot be null")
	private String url;
}
