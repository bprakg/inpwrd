package com.urlanalysis.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.business.AnalysisBusiness;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class AnalysisController {

	private @Autowired AnalysisBusiness business;

	// Getting environment property
    @Value("${APPNAME}")
    private String appName;

	@GetMapping
	public Analysis getAnalysis(@RequestParam (required=true) String url) {
		log.info("Name is - "+ appName);
		return business.getAnalysis(url);
	}

	@PostMapping
	public Analysis addAnalysis(@RequestBody Analysis analysis) {
		log.info("post " + analysis);

		if (analysis.getCallbackUrl() != null) {
			log.info("new process thread");
			new Thread(() -> {
				business.addAnalysis(analysis);
			}).start();

			log.info("returning for callback ");
			return null;
		} else {
			business.addAnalysis(analysis);
		}
		return analysis;
	}
}
