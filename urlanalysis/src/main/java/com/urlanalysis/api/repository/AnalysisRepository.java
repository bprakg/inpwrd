package com.urlanalysis.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.urlanalysis.api.bean.Analysis;

public interface AnalysisRepository extends PagingAndSortingRepository<Analysis, Long> {

	Analysis findByUrl(String url);
}
