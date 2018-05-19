package com.inpwrd.api.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inpwrd.api.bean.Analysis;
import com.inpwrd.api.data.AnalysisData;
import com.inpwrd.api.integration.AnalysisExternalServices;

@Component
public class AnalysisBusiness {

	private static Logger LOGGER = LoggerFactory.getLogger("AnalysisBusiness");

	@Autowired
	private AnalysisData data;
	
	@Autowired
	private AnalysisExternalServices aes;

	public Analysis getAnalysis(String url) {
		return data.getAnalysis(url);
	}

	public void addAnalysis(Analysis analysis) {
		
		LOGGER.info("AnalysisBusiness.addAnalysis");
		
		Thread t1 = new Thread(() -> {
			aes.addPageDetails(analysis);
			LOGGER.info("done with t1");
		});
		
		Thread t2 = new Thread(() -> {
			aes.addSentimentDetails(analysis);
			LOGGER.info("done with t2");
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("adding to db");
		data.addAnalysis(analysis);
		if(analysis.getCallbackUrl() != null) aes.sendCallBack(analysis);
	}
}
