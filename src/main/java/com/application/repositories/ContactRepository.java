package com.application.repositories;

import org.springframework.data.repository.ListCrudRepository;

import org.springframework.stereotype.Repository;

import com.application.entities.Contact;


@Repository
public interface ContactRepository extends ListCrudRepository<Contact, String> {
}
