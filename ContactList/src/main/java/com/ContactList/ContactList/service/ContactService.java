package com.ContactList.ContactList.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ContactList.ContactList.entity.Contact;
import com.ContactList.ContactList.repository.ContactRepository;

@Service
public class ContactService 
{
	@Autowired
	 private ContactRepository contactRepository;
	
	public Contact createContact(Contact contact) 
	{
		 return contactRepository.save(contact);
		
	}
	 public void deleteContact(Long id) 
	 	{
	        contactRepository.deleteById(id);
	    }

	    public List<Contact> getAllContacts() 
	    {
	        return contactRepository.findAll();
	    }

	    public Contact getContactById(Long id) 
	    {
	        return contactRepository.findById(id).orElse(null);
	    }
	    
	    public Contact updateContact(Long id, Contact contact) {
	        if (contactRepository.existsById(id)) {
	            contact.setId(id);
	            return contactRepository.save(contact);
	        }
	        return null;
	    }
		public Contact getContactByName(String name) {
			 	        return contactRepository.findByName(name).orElse(null);

		}

}
