package com.urlanalysis.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class ResponseFormat {

	private String page_title;
	private String description;
	private String author;
	private String polarity;
	private String subjectivity;
	private String text;
	private double polarity_confidence;
	private double subjectivity_confidence;
}