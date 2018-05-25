package com.urlanalysis.api.mock;

import org.springframework.stereotype.Component;

import com.urlanalysis.api.bean.Analysis;

@Component
public class MockData {

	public static void populatePageDetails(Analysis analysis) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		analysis.setPageTitle("mytitle");
		analysis.setDescription("some discription");
		analysis.setAuthor("Prakash");
	}

	public static void populateSentimentDetails(Analysis analysis) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		analysis.setPolarity("positive");
		analysis.setPolarityConfidence(0.1234567891234567);
		analysis.setSubjectivity("subjectivity");
		analysis.setSubjectivityConfidence(0.1234567891234567);
		analysis.setText("some random text");
	}
}
