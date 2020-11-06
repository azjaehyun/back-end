package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import lombok.extern.slf4j.Slf4j;

@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class DemoControllerTest2 {
   
	@InjectMocks
	private DemoController demoController ;
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
	}
	
	
//	@Test
//	public void 컨트롤러테스트() throws Exception {
//		mockMvc.perform(get("/test/api")).andExpect(status().isOk()).andExpect(view().name("index")).andExpect(model().attribute("result","hellow world"));
//	}
//	
	@Test
	public void 컨트롤러스트링리턴테스트() throws Exception {
		mockMvc.perform(get("/api/test").param("test", "execute")).andDo(print()).andExpect(status().isOk());
		
		MvcResult result = mockMvc.perform(get("/api/test").param("test", "execute")).andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		
		Assert.assertEquals(content, "execute");
		
	}
	
	
	//private static ObjectMapper objectMapper = new ObjectMapper();
//	
//	final TestVO testVO = TestVO.builder().age(20).email("jaehyun").build();
//	
//	@Before
//	public void setup() throws Exception {
//		String param = objectMapper.writeValueAsString(testVO);
//		this.mockMvc.perform(post("/test/v1").contentType(MediaType.APPLICATION_JSON).content(param)).andExpect(status().isOk()).andDo(print());
//	}
//	
	
}
