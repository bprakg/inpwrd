package com.urlanalysis.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urlanalysis.api.bean.ValidatorExample;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class AnalysisController2 {

	public @RequestMapping(method = RequestMethod.GET, value = "/urlanalysis2") void getAnalysis(
			@RequestParam String trl, @RequestParam String url) {

		ValidatorExample ve = ValidatorExample.builder().trl(trl).url(url).build();
		log.info("VE = " + ve);
	}
}