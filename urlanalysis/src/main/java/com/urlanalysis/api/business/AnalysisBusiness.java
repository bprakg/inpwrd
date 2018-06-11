package com.urlanalysis.api.business;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.data.AnalysisData;
import com.urlanalysis.api.integration.AnalysisExternalServices;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
@Validated
public class AnalysisBusiness {

	@Autowired
	private AnalysisData data;

	@Autowired
	private AnalysisExternalServices aes;

	public Analysis getAnalysis(@NotBlank (message = "{blank.url}") String url) {
		log.info("inside getAnalysis");
		return data.getAnalysis(url);
	}

	public void addAnalysis(Analysis analysis) {

		log.info("AnalysisBusiness.addAnalysis");

		Thread t1 = new Thread(() -> {
			aes.addPageDetails(analysis);
			log.info("done with t1");
		});

		Thread t2 = new Thread(() -> {
			aes.addSentimentDetails(analysis);
			log.info("done with t2");
		});
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("adding to db");
		data.addAnalysis(analysis);
		if (analysis.getCallbackUrl() != null)
			aes.sendCallBack(analysis);
	}
}
