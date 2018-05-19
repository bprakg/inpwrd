package com.inpwrd.api.service;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inpwrd.api.bean.Analysis;
import com.inpwrd.api.business.AnalysisBusiness;

@RestController
@Validated
public class AnalysisController {

	private static Logger LOGGER = LoggerFactory.getLogger("AnalysisController");

	@Autowired
	private AnalysisBusiness business;

	@RequestMapping(method = RequestMethod.GET)
	public Analysis analyze(@RequestParam @NotEmpty String url) {
		LOGGER.info("GET - " + url);
		return business.getAnalysis(url);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Analysis addAnalysis(@RequestBody Analysis analysis) {
		LOGGER.info("post " + analysis);

		if (analysis.getCallbackUrl() != null) {
			LOGGER.info("new process thread");
			new Thread(() -> {
				business.addAnalysis(analysis);
			}).start();

			LOGGER.info("returning for callback ");
			return null;
		} else {
			business.addAnalysis(analysis);
		}
		return analysis;
	}
}
