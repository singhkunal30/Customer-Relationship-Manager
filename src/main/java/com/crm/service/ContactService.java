package com.crm.service;

import java.util.List;

import com.crm.dto.ContactDTO;

public interface ContactService {
	
	List<ContactDTO> createContact(List<ContactDTO> contactDTOs);
	
	ContactDTO getContact(long id);
	
	ContactDTO updateContact(ContactDTO contactDTO);
	
	boolean removeContact(long id);

	List<ContactDTO> getAllContacts();
	
}
