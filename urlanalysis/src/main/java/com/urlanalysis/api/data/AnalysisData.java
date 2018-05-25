package com.urlanalysis.api.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.repository.AnalysisRepository;

@Service
public class AnalysisData {

	private static Logger LOGGER = LoggerFactory.getLogger("AnalysisData");

	@Autowired
	private AnalysisRepository repo;

	public Analysis getAnalysis(String url) {
		LOGGER.info("url: " + url);
		Analysis analysis = repo.findByUrl(url);
		LOGGER.info("analysis = "+analysis);
		return analysis;
	}

	public void addAnalysis(Analysis analysis) {
		LOGGER.info("analysis = "+analysis);
		repo.save(analysis);
	}

}
