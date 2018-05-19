package com.inpwrd.api.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.inpwrd.api.bean.Analysis;
import com.inpwrd.api.mock.MockData;

@Service
public class AnalysisExternalServices {

	private static Logger LOGGER = LoggerFactory.getLogger("AnalysisExternalServices");

	public void addPageDetails(Analysis analysis) {
		LOGGER.info("AnalysisExternalServices.addPageDetails");
		// ResponseEntity<ResponseFormat> q = rt.getForEntity(analysis.getUrl(),
		// ResponseFormat.class);
		// LOGGER.info(q.toString());
		MockData.populatePageDetails(analysis);
	}

	public void addSentimentDetails(Analysis analysis) {
		LOGGER.info("AnalysisExternalServices.addSentimentDetails");
		MockData.populateSentimentDetails(analysis);
	}

	public void sendCallBack(Analysis analysis) {
		LOGGER.info("AnalysisExternalServices.sendCallBack");
	}
}
