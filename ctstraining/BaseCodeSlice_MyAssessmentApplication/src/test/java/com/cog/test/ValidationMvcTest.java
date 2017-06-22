package com.cog.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.validator.ValidatedAccountController;

public class ValidationMvcTest {
	private MockMvc mockMvc;
    
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new ValidatedAccountController()).build();
    }
	@Test
	public void getShouldResultAccountHomePage() throws Exception{
	    this.mockMvc.perform(get("/validateAccount")).andExpect(view().name("accountHome"));
	}
	@Test
	public void postShouldResultAccountHomePage() throws Exception{
	    this.mockMvc.perform(post("/validateAccount")).andExpect(view().name("accountHome"));
	}
    @Test
    public void stringIsNotValidParameter() 
      throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
          .post("/validateAccount")
          .accept(MediaType.TEXT_HTML)
          .param("account", "aa"))
          .andExpect(view().name("accountHome"))
          .andExpect(model().errorCount(1))
          .andExpect(status().isOk())
          .andDo(print());
    }
    
    @Test
    public void blankStringIsNotValidParameter() 
      throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
          .post("/validateAccount")
          .accept(MediaType.TEXT_HTML)
          .param("account", ""))
          .andExpect(view().name("accountHome"))
          .andExpect(model().errorCount(1))
          .andExpect(status().isOk());
    }
    
    @Test
    public void post6DigitAccountNumber() throws Exception {
    	String accountNum = "012345";
        this.mockMvc.perform(MockMvcRequestBuilders
        		.post("/validateAccount")
                .accept(MediaType.TEXT_HTML)
                .param("account", accountNum))
                .andExpect(model().attribute("message", "Successfully saved account: "+accountNum))
                .andExpect(view().name("validAccount"))
                .andExpect(status().isOk());
    }
}
