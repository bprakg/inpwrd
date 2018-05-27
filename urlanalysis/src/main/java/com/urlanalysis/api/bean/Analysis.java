package com.urlanalysis.api.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Analysis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String pageTitle;
	private String description;
	private String author;
	private String polarity;
	private String subjectivity;
	private String text;
	private double polarityConfidence;
	private double subjectivityConfidence;
	private String url;
	private String callbackUrl;
}
