package com.urlanalysis.api.service;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.business.AnalysisBusiness;

import lombok.extern.log4j.Log4j;

@RestController
@Validated
@Log4j
public class AnalysisController {

	private @Autowired AnalysisBusiness business;

	public @RequestMapping(method = RequestMethod.GET) Analysis getAnalysis(
			@RequestParam @NotEmpty(message = "url cannot be null") String url) {
		log.info("GET - " + url);
		return business.getAnalysis(url);
	}

	public @RequestMapping(method = RequestMethod.POST) Analysis addAnalysis(@RequestBody Analysis analysis) {
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
