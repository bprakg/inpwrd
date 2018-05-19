package com.inpwrd.api.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Analysis {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@Override
	public String toString() {
		return "Analysis [id=" + id + ", pageTitle=" + pageTitle + ", description=" + description + ", author=" + author
				+ ", polarity=" + polarity + ", subjectivity=" + subjectivity + ", text=" + text
				+ ", polarityConfidence=" + polarityConfidence + ", subjectivityConfidence=" + subjectivityConfidence
				+ ", url=" + url + ", callbackUrl=" + callbackUrl + "]";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
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
	public double getPolarityConfidence() {
		return polarityConfidence;
	}
	public void setPolarityConfidence(double polarityConfidence) {
		this.polarityConfidence = polarityConfidence;
	}
	public double getSubjectivityConfidence() {
		return subjectivityConfidence;
	}
	public void setSubjectivityConfidence(double subjectivityConfidence) {
		this.subjectivityConfidence = subjectivityConfidence;
	}
}
