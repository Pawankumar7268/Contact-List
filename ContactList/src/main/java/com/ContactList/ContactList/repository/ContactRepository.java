package com.ContactList.ContactList.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ContactList.ContactList.entity.Contact;

public interface ContactRepository extends  JpaRepository<Contact, Long> 
{

	Optional<Contact> findByName(String name);

}