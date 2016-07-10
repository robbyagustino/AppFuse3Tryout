package com.test.webapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ExamControllerTest extends BaseControllerTestCase {
	
	@Autowired
    private ExamController controller;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
 
        mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(viewResolver).build();
    }
 
    @Test
    public void testHandleRequest() throws Exception {
        mockMvc.perform(get("/exams"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("questionList"))
                .andExpect(view().name("exams"));
    }
    
}
