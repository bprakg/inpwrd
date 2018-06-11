package com.urlanalysis.api.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.repository.AnalysisRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AnalysisData {

	@Autowired
	private AnalysisRepository repo;

	public Analysis getAnalysis(String url) {
		log.info("url: " + url);
		Analysis analysis = repo.findByUrl(url);
		log.info("analysis = " + analysis);
		return analysis;
	}

	public void addAnalysis(Analysis analysis) {
		log.info("analysis = " + analysis);
		repo.save(analysis);
	}

}
