package com.urlanalysis.api.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.urlanalysis.api.bean.Analysis;
import com.urlanalysis.api.business.AnalysisBusiness;

@WebMvcTest(AnalysisController.class)
@RunWith(SpringRunner.class)
public class AnalysisControllerTest {

	@MockBean
	private AnalysisBusiness businessMock;

	@Autowired
	private AnalysisBusiness business;

	@Autowired
	private MockMvc mvc;

	public @Test void getAnalysisTest1() throws Exception {
		Analysis analysis = Analysis.builder().build();
		analysis.setUrl("google.com");
		given(this.businessMock.getAnalysis(anyString())).willReturn(analysis);
		mvc.perform(get("/urlanalysis?url=gmail.com")).andExpect(status().isOk());
	}

	public @Test void getAnalysisTest2() throws Exception {
		Analysis analysis = Analysis.builder().build();
		analysis.setUrl("google.com");
		given(this.businessMock.getAnalysis(anyString())).willReturn(analysis);
		mvc.perform(get("/urlanalysis")).andExpect(status().is4xxClientError());
	}

	@Test
	public void getAnalysisTest3() throws Exception {
		try {
			mvc.perform(get("/urlanalysis?url="));
		} catch (ConstraintViolationException cve) {
			assertThat(cve.getMessage()).contains("url cannot be null");
			return;
		}
		org.junit.Assert.fail("Expecting ConstraintViolationException for url");
	}

	@Test
	public void validationTest1() {
		try {
			business.getAnalysis(null);
		} catch (ConstraintViolationException cve) {
			assertThat(cve.getMessage()).contains("url cannot be null");
			return;
		}
		org.junit.Assert.fail("Expecting ConstraintViolationException for url");
	}
}