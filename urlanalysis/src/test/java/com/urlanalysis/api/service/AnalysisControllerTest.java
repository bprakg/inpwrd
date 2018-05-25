package com.urlanalysis.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.business.AnalysisBusiness;

public @SpringBootTest @RunWith(SpringRunner.class) class AnalysisControllerTest {

	private @MockBean AnalysisBusiness business;

	private @Autowired AnalysisController analysisController;

	public @Test void getAnalysisTest1() {
		Analysis analysis = new Analysis();
		analysis.setUrl("google.com");
		given(this.business.getAnalysis(anyString())).willReturn(analysis);
		assertThat(analysisController.getAnalysis("abc").getUrl()).isEqualTo("google.com");
	}
}