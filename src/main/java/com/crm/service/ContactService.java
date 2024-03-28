package com.crm.service;

import java.util.List;

import com.crm.dto.ContactDTO;

public interface ContactService {
	
	ContactDTO createContact(ContactDTO ContactDTO);
	
	ContactDTO getContact(long id);
	
	ContactDTO updateContact(ContactDTO ContactDTO);
	
	boolean removeContact(long id);

	List<ContactDTO> getAllContacts();
	
}
