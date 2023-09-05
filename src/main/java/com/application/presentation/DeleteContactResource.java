package com.application.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.application.repositories.ContactRepository;





@CrossOrigin(origins = "*")
@RestController
public class DeleteContactResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteContactResource.class);

    @Autowired
    private ContactRepository contactRepository;

    @DeleteMapping("/contacts/delete-contact/{id}")
    public void deleteContact(@PathVariable("id") String id) {
        LOGGER.info("Command for deleting contact {}", id);
        contactRepository.deleteById(id);
        LOGGER.info("Contact {} deleted", id);
    }
}
