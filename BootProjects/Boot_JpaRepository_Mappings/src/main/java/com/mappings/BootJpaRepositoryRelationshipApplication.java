package com.mappings;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.mappings.inheritance_mappings.tableperclass.ContractEmployee_TPC;
import com.mappings.inheritance_mappings.tableperclass.ContractEmployee_TPCRepository;
import com.mappings.inheritance_mappings.tableperclass.Employee_TPC;
import com.mappings.inheritance_mappings.tableperclass.Employee_TPCRepository;
import com.mappings.inheritance_mappings.tableperclass.PermanentEmployee_TPC;
import com.mappings.inheritance_mappings.tableperclass.PermanentEmployee_TPCRepository;
import com.mappings.inheritancemappings.mappedsuperclass.PostMSC;
import com.mappings.inheritancemappings.mappedsuperclass.PostMSCRepository;
import com.mappings.inheritancemappings.singletablestrategy.ContractEmployee;
import com.mappings.inheritancemappings.singletablestrategy.Employee;
import com.mappings.inheritancemappings.singletablestrategy.EmployeeRepository;
import com.mappings.inheritancemappings.singletablestrategy.PermanentEmployee;
import com.mappings.many2many.Post1;
import com.mappings.many2many.Post1Repository;
import com.mappings.many2many.Tag;
import com.mappings.many2many.TagRepository;
import com.mappings.many2one.CommentRepository;
import com.mappings.many2one.PostRepository;
import com.mappings.one2one.Gender;
import com.mappings.one2one.User;
import com.mappings.one2one.UserProfile;
import com.mappings.one2one.UserProfileRepository;
import com.mappings.one2one.UserRepository;

@EnableJpaAuditing
@SpringBootApplication
public class BootJpaRepositoryRelationshipApplication implements CommandLineRunner {

	// one2one
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private UserProfileRepository userProfileRepository;
	
	//many2many
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private Post1Repository post1Repository;

	//many2One
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(BootJpaRepositoryRelationshipApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		one2One_LoadTestData_And_Test();
		many2Many_LoadTestData_And_Test();
		
		many2One_DeleteTestData();
		

	}

	private void one2One_LoadTestData_And_Test(){
		// Clean up database tables
		userProfileRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();
		
		// Create a User instance
		User user = new User("Amal", "Raj", "raj@test.com","xyz");

		// Create a UserProfile instance
		UserProfile userProfile = new UserProfile("+91-123456793", Gender.MALE,"chennai");

		// Set child reference(userProfile) in parent entity(user)
		user.setUserProfile(userProfile);

		// Set parent reference(user) in child entity(userProfile)
		userProfile.setUser(user);

		// Save Parent Reference (which will save the child as well)
		userRepository.save(user);
	}

	private void many2Many_LoadTestData_And_Test() throws Exception{
		// Clean up database tables
		post1Repository.deleteAllInBatch();
		tagRepository.deleteAllInBatch();
		

		// Create a Post
		Post1 post1 = new Post1(" Many2Many Example with Spring Boot & Hibernate",
				"Learn  many to many relationship using hibernate",
				"Sample code with description");

		// Create two tags
		Tag tag1 = new Tag("Spring Boot");
		Tag tag2 = new Tag("Hibernate");


		// Add tag references in the post
		post1.getTags().add(tag1);
		post1.getTags().add(tag2);

		// Add post reference in the tags
		tag1.getPosts().add(post1);
		tag2.getPosts().add(post1);

		post1Repository.save(post1);
	}

	private void many2One_DeleteTestData(){
		postRepository.deleteAllInBatch();
		commentRepository.deleteAllInBatch();
	}

	

}
