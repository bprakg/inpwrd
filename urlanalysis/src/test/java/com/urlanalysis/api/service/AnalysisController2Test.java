package com.urlanalysis.api.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.annotation.Validated;

import lombok.extern.log4j.Log4j;

@WebMvcTest(AnalysisController2.class)
@RunWith(SpringRunner.class)
@Log4j
@Validated
public class AnalysisController2Test {

	@Autowired
	private MockMvc mvc;

	public @Test void getAnalysisTest1() {
		try {
			mvc.perform(get("/urlanalysis2")).andExpect(status().is4xxClientError());
		} catch (Exception e) {
			log.info("getAnalysisTest1 - logging exception", e);
		}
	}

	public @Test void getAnalysisTest2() {
		try {
			mvc.perform(get("/urlanalysis2?trl=&url=")).andExpect(status().is4xxClientError());
		} catch (Exception e) {
			log.info("getAnalysisTest2 - logging exception", e);
		}
	}

	public @Test void getAnalysisTest3() {
		try {
			mvc.perform(get("/urlanalysis2?trl=gmail.com&url=gmail.com")).andExpect(status().isOk());
		} catch (Exception e) {
			log.info("getAnalysisTest3 - logging exception", e);
		}
	}
}