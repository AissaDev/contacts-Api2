package com.application.presentation;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.entities.Contact;
import com.application.services.ContactService;
import com.application.services.UpdateContactCommand;




@CrossOrigin(origins = "*")
@RestController
public class UpdateContactResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateContactResource.class);

    @Autowired
    private ContactService contactService;

    @PutMapping("/contacts/update-contact")
    public Contact updateContact(@RequestBody UpdateContactCommand command) {
        LOGGER.info("Command for updating contact {}", command);
        return contactService.updateContact(command);
    }
}
