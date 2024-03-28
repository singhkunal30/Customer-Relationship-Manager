package com.crm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crm.dto.ContactDTO;
import com.crm.exception.ContactException;
import com.crm.mapper.DTOMapper;
import com.crm.model.Contact;
import com.crm.repository.ContactRepository;
import com.crm.utils.ErrorCode;
import com.crm.utils.ErrorMessage;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactRepository ContactRepository;
	
	@Autowired
	DTOMapper mapper;
	
	@Autowired
	ErrorMessage errMsg;
	
	@Autowired
	ErrorCode errCode;
	
	@Override
	public ContactDTO createContact(ContactDTO ContactDTO) {
		Contact Contact = mapper.toContact(ContactDTO);
		Contact savedContact = ContactRepository.save(Contact);
		return mapper.toContactDTO(savedContact);
	}

	@Override
	public ContactDTO getContact(long id) throws ContactException {
		Contact Contact = ContactRepository.findById(id)
				.orElseThrow(() -> new ContactException(errMsg.getContactNotFound() + ": " +id, errCode.getContactNotFound(), HttpStatus.NOT_FOUND));
		return mapper.toContactDTO(Contact);
	}

	@Override
	public ContactDTO updateContact(ContactDTO ContactDTO) {
		Contact Contact = ContactRepository.findById(ContactDTO.getContactId())
				.orElseThrow(() -> new ContactException(errMsg.getContactNotFound() + " " +ContactDTO.getContactId(), 
						errCode.getContactNotFound(), HttpStatus.NOT_FOUND));
		Contact updatedContact = mapper.toContact(ContactDTO);
		updatedContact.setContactId(ContactDTO.getContactId());
		ContactRepository.save(updatedContact);
		return mapper.toContactDTO(updatedContact);
	}

	@Override
	public boolean removeContact(long id) {
		Contact c = ContactRepository.findById(id)
				.orElseThrow(() -> new ContactException(errMsg.getContactNotFound() + " " +id, errCode.getContactNotFound(), HttpStatus.NOT_FOUND));
		ContactRepository.delete(c);
		return true;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		List<ContactDTO> ContactDTOs = mapper.toContactDTOs(ContactRepository.findAll());
		return ContactDTOs;
	}

	
}
