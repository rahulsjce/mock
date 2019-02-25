package com.springboot.rest.example.springbootuserapp.user;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(UserResource.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserDaoService userDaoService;
	
	@Test
	public void retriveAllUser_test() throws Exception {
		when(userDaoService.getAllUser()).
		thenReturn(Arrays.asList(new User(0,"Rahul","Sun Feb 24 15:53:56 IST 2019"),
								 new User(1,"Raj","Mon Feb 25 11:58:01 IST 2019")));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/user").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = (MvcResult) mockMvc.perform(requestBuilder)
					.andExpect(status().isOk())
					.andExpect(content()
					.json("[{id:0,name:Rahul,birthDate:Sun Feb 24 15:53:56 IST 2019},{id:1,name:Raj,birthDate:Mon Feb 25 11:58:01 IST 2019}]"))
					.andReturn();
							
						
	}

}
