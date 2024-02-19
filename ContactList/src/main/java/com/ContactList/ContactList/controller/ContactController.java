package com.ContactList.ContactList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ContactList.ContactList.entity.Contact;
import com.ContactList.ContactList.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController 
{
	@Autowired
	  private ContactService contactService;
	
	
	@PostMapping
	 public ResponseEntity<Contact> createContact(@RequestBody Contact contact)
	{
		System.out.println(contact.getName());
        Contact createdContact = contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
	        contactService.deleteContact(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping
	    public ResponseEntity<List<Contact>> getAllContacts() {
	        List<Contact> contacts = contactService.getAllContacts();
	        return ResponseEntity.ok(contacts);
	    }

	    @GetMapping("/{name}")
	    public ResponseEntity<Contact> getContactById(@PathVariable String  name) {
	        Contact contact = contactService.getContactByName(name);
	        if (contact != null) {
	            return ResponseEntity.ok(contact);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
	        Contact updatedContact = contactService.updateContact(id, contact);
	        if (updatedContact != null) {
	            return ResponseEntity.ok(updatedContact);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
}
