package com.application.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.Contact;
import com.application.exceptions.ContactNotFoundException;
import com.application.repositories.ContactRepository;





@Service
public class ContactService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactService.class);

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(final ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public Contact updateContact(final UpdateContactCommand command) {
        LOGGER.debug("Update contact {}", command);
        return contactRepository.findById(command.getId())
                .map(contact -> updateAndSave(command))
                .orElseThrow(() -> new ContactNotFoundException(String.format("Contact unknown with id %s", command.getId())));
    }

    private Contact updateAndSave(final UpdateContactCommand command) {
        final Contact newContact = new Contact(command.getFirstName(), command.getLastName(), command.getAge(), command.getId());
        return contactRepository.save(newContact);
    }
}