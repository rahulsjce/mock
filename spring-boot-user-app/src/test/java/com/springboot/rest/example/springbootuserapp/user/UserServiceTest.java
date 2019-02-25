package com.springboot.rest.example.springbootuserapp.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserDaoService daoService;
	
	@Mock
	private MongoTemplate  mongoTemplate;
	
	@Test
	public void getAllUser_Test()
	{
		when(mongoTemplate.findAll(User.class,"User")).thenReturn(Arrays.asList(new User(0,"Rahul","Sun Feb 24 15:53:56 IST 2019"),
								 new User(1,"Raj","Mon Feb 25 11:58:01 IST 2019")));
		List<User> users = daoService.getAllUser();
		//System.out.println(users);
		
		//assertEquals("Rahul",users.get(0).getName());
		assertEquals("Rahul", users.get(0).getName());
	}

}
