package com.springboot.rest.example.springbootuserapp.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	int a = 0;

	/*private static List<User> users = new ArrayList<>();
	private static int usersCounts = 3;
	static {
		//users.add(new User(1, "Rahul", new Date()));
		//users.add(new User(2, "Rahul", new Date()));
		//users.add(new User(3, "Rahul", new Date()));
	}

	public List<User> findAll() {

		return users;
	}

	public User save(User user) {

		if (user.getId() == null)
			user.setId(++usersCounts);

		users.add(user);
		return user;
	}

	public User findOne(int id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}

		}
		return null;
	}
*/
	public User getUser(String userId) {
		User findOne = null;
		Query query = new Query(Criteria.where("name").is("Rahul"));
		System.out.println(query);
		findOne = mongoTemplate.findOne(query, User.class, "User");
		System.out.println(findOne);

		//User user = new User(a++, "Rahul", new Date());

		//System.out.println("started saving ");

		//mongoTemplate.save(user, "User");

		if (findOne == null) {
			throw new UserNotFoundException(userId);
		}
		return findOne;
	}
	
	public List<User> getAllUser(){
		List<User> allUser = mongoTemplate.findAll(User.class,"User");
		System.out.println("Get  All User "+allUser);
		return allUser;
	}
	
	public User saveUser(User user) {

		if (user.getId() == null)
			user.setId(++a);

		mongoTemplate.save(user, "User");
		return user;
	} 

}
