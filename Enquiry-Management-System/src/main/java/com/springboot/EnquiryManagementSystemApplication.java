package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.dao.EnquiryDao;
import com.springboot.dao.UserDao;
import com.springboot.entity.Enquiry;
import com.springboot.entity.User;

@SpringBootApplication
public class EnquiryManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EnquiryManagementSystemApplication.class, args);
	}

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EnquiryDao enquiryDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * User user1 = new User("Neha", "Shrivastava", "ns@gmail.com");
		 * userDao.save(user1);
		 * 
		 * User user2 = new User("Niasha", "Sharma", "sn@gmail.com");
		 * userDao.save(user2);
		 * 
		 * User user3 = new User("Joe", "Flex", "jf@gmail.com"); userDao.save(user3);
		 * 
		 * User user4 = new User("Kim", "stuert", "kis@gmail.com"); userDao.save(user4);
		 */
		
		
		/*
		 * Enquiry enquiry1 = new Enquiry("Neha", "Shrivastava",
		 * "ns@gmail.com","Available Courses"); enquiryDao.save(enquiry1);
		 */
	}

}
