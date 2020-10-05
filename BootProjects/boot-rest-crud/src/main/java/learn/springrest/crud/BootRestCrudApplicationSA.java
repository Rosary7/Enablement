package learn.springrest.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import learn.springrest.crud.profile.Project;

//@SpringBootApplication
//public class BootRestCrudApplicationSA implements CommandLineRunner{
public class BootRestCrudApplicationSA{
	@Autowired
	private Project project1;
	
	/*@Autowired
	@Qualifier("testdev")
	private Project project2;*/
	
	public static void main(String[] args) {
		SpringApplication.run(BootRestCrudApplicationSA.class, args);
		
	}
	
	//@Override
	public void run(String... args) throws Exception {
		System.out.println(project1.getProjectCodeVersion());
		System.out.println();
		//System.out.println(project2.getProjectCodeVersion());
	}

}
