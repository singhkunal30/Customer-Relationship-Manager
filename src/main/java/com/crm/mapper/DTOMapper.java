package com.crm.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.crm.dto.CustomerDTO;
import com.crm.dto.UserDTO;
import com.crm.model.Customer;
import com.crm.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DTOMapper {
	
	Customer toCustomer(CustomerDTO customerDTO);
	
	CustomerDTO toCustomerDTO(Customer customer);
	
	List<CustomerDTO> toCustomerDTOs(List<Customer> customers);

	List<Customer> toCustomers(List<CustomerDTO> customers);
	
	User toUser(UserDTO userDTO);
	
	UserDTO toUserDTO(User user);
	
	List<UserDTO> toUserDTOs(List<User> users);

	List<User> toUsers(List<UserDTO> users);
}
