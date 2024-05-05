package com.crm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crm.dto.ContactDTO;
import com.crm.exception.CrmException;
import com.crm.mapper.DTOMapper;
import com.crm.model.Contact;
import com.crm.repository.ContactRepository;
import com.crm.utils.ErrorCode;
import com.crm.utils.ErrorMessage;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	DTOMapper mapper;
	
	@Autowired
	ErrorMessage errMsg;
	
	@Autowired
	ErrorCode errCode;
	
	@Override
	public List<ContactDTO> createContact(List<ContactDTO> contactDTOs) {
		return mapper.toContactDTOs(contactRepository.saveAll(mapper.toContacts(contactDTOs)));
	}

	@Override
	public ContactDTO getContact(long id) throws CrmException {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new CrmException(errMsg.getContactNotFound() + ": " +id, errCode.getContactNotFound(), HttpStatus.NOT_FOUND));
		return mapper.toContactDTO(contact);
	}

	@Override
	public ContactDTO updateContact(ContactDTO contactDTO) {
		contactRepository.findById(contactDTO.getContactId())
				.orElseThrow(() -> new CrmException(errMsg.getContactNotFound() + " " +contactDTO.getContactId(), 
						errCode.getContactNotFound(), HttpStatus.NOT_FOUND));
		Contact updatedContact = mapper.toContact(contactDTO);
		updatedContact.setContactId(contactDTO.getContactId());
		contactRepository.save(updatedContact);
		return mapper.toContactDTO(updatedContact);
	}

	@Override
	public boolean removeContact(long id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new CrmException(errMsg.getContactNotFound() + " " +id, errCode.getContactNotFound(), HttpStatus.NOT_FOUND));
		contactRepository.delete(contact);
		return contactRepository.findById(id).isEmpty();
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		List<ContactDTO> contactDTOs = mapper.toContactDTOs(contactRepository.findAll());
		return contactDTOs;
	}

	

	
}
