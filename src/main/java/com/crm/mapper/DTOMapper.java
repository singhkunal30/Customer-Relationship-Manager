package com.crm.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.crm.dto.ContactDTO;
import com.crm.dto.UserDTO;
import com.crm.model.Contact;
import com.crm.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DTOMapper {
	
	Contact toContact(ContactDTO ContactDTO);
	
	ContactDTO toContactDTO(Contact Contact);
	
	List<ContactDTO> toContactDTOs(List<Contact> Contacts);

	List<Contact> toContacts(List<ContactDTO> Contacts);
	
	User toUser(UserDTO userDTO);
	
	UserDTO toUserDTO(User user);
	
	List<UserDTO> toUserDTOs(List<User> users);

	List<User> toUsers(List<UserDTO> users);
}
