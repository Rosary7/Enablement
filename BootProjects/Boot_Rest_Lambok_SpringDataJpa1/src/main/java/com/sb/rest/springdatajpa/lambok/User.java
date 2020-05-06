package com.sb.rest.springdatajpa.lambok;


/*
 * @Data - Using 'lombok' library , to generate get/set etc
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data   //'lombok' library
@Table(name = "TEST_USER")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    
}
