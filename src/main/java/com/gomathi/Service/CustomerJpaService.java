package com.gomathi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gomathi.Model.Customer;
import com.gomathi.Repository.CustomerJpaRepository;
import com.gomathi.Repository.CustomerRepository;

@Service
public class CustomerJpaService implements CustomerRepository
{
	
	@Autowired
	private CustomerJpaRepository customerJpaRepository;
	
	@Override
	public ArrayList<Customer> getCustomers()
	{
		List<Customer> customerList=customerJpaRepository.findAll();
		ArrayList<Customer> customers=new ArrayList<>(customerList);
		return customers;
	}
	@Override
	public Customer getCustomerById(int customerId)
	{
		try
		{
		Customer customer= customerJpaRepository.findById(customerId).get();
		return customer;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public Customer addCustomer(Customer customer) 
	{
		customerJpaRepository.save(customer);
		 return customer;
	}
	@Override
	public Customer updateCustomer(int customerId, Customer customer)
	{
		try
		{
		Customer existingCustomer= customerJpaRepository.findById(customerId).get();
		if(customer.getName()!=null)
		{
			existingCustomer.setName(customer.getName());
		}
		 customerJpaRepository.save(existingCustomer);
		return existingCustomer;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public void deleteCustomer(int customerId)
	{
		try
		{
		Customer customer= customerJpaRepository.findById(customerId).get();
		if(customer!=null)
		{
			customerJpaRepository.deleteById(customerId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
}
