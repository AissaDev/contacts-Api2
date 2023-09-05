package com.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.entities.Contact;
import com.application.repositories.ContactRepository;




@SpringBootApplication(scanBasePackages = "com.application")
public class ContactsApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApi2Application.class, args);
	}
	
	 @Bean
	    public CommandLineRunner initDb(final ContactRepository contactRepository) {
	        return args -> {
	          if (contactRepository != null) {
	        	  contactRepository.deleteAll();
		            contactRepository.save(new Contact("Jean", "Dupond", 35L));
		            contactRepository.save(new Contact("John", "Doe", 37L));
			}
	            
	        };
	    }

}
