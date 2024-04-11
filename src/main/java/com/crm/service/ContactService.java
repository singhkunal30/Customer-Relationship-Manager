package com.crm.service;

import java.util.List;

import com.crm.dto.ContactDTO;

public interface ContactService {
	
	ContactDTO createContact(ContactDTO contactDTO);
	
	ContactDTO getContact(long id);
	
	ContactDTO updateContact(ContactDTO contactDTO);
	
	boolean removeContact(long id);

	List<ContactDTO> getAllContacts();
	
}
