package com.urlanalysis.api.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.data.AnalysisData;
import com.urlanalysis.api.integration.AnalysisExternalServices;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class AnalysisBusiness {

	@Autowired
	private AnalysisData data;

	@Autowired
	private AnalysisExternalServices aes;

	public Analysis getAnalysis(String url) {
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
