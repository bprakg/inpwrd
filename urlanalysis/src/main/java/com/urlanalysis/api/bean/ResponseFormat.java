package com.urlanalysis.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseFormat {

    private String page_title;
    private String description;
	private String author;
	private String polarity;
	private String subjectivity;
	private String text;
	private double polarity_confidence;
	private double subjectivity_confidence;
	public String getPage_title() {
		return page_title;
	}
	public void setPage_title(String page_title) {
		this.page_title = page_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPolarity() {
		return polarity;
	}
	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}
	public String getSubjectivity() {
		return subjectivity;
	}
	public void setSubjectivity(String subjectivity) {
		this.subjectivity = subjectivity;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getPolarity_confidence() {
		return polarity_confidence;
	}
	public void setPolarity_confidence(double polarity_confidence) {
		this.polarity_confidence = polarity_confidence;
	}
	public double getSubjectivity_confidence() {
		return subjectivity_confidence;
	}
	public void setSubjectivity_confidence(double subjectivity_confidence) {
		this.subjectivity_confidence = subjectivity_confidence;
	}
	@Override
	public String toString() {
		return "Quote [page_title=" + page_title + ", description=" + description + ", author=" + author + ", polarity="
				+ polarity + ", subjectivity=" + subjectivity + ", text=" + text + ", polarity_confidence="
				+ polarity_confidence + ", subjectivity_confidence=" + subjectivity_confidence + "]";
	}
}