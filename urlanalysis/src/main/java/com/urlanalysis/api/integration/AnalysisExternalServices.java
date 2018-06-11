package com.urlanalysis.api.integration;

import org.springframework.stereotype.Service;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.mock.MockData;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AnalysisExternalServices {

	public void addPageDetails(Analysis analysis) {
		log.info("AnalysisExternalServices.addPageDetails");
		// ResponseEntity<ResponseFormat> q = rt.getForEntity(analysis.getUrl(),
		// ResponseFormat.class);
		// log.info(q.toString());
		MockData.populatePageDetails(analysis);
	}

	public void addSentimentDetails(Analysis analysis) {
		log.info("AnalysisExternalServices.addSentimentDetails");
		MockData.populateSentimentDetails(analysis);
	}

	public void sendCallBack(Analysis analysis) {
		log.info("AnalysisExternalServices.sendCallBack");
	}
}
