package com.gomathi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gomathi.Model.Customer;
import com.gomathi.Model.Mobile;
import com.gomathi.Repository.CustomerJpaRepository;
import com.gomathi.Repository.MobileJpaRepository;
import com.gomathi.Repository.MobileRepository;

@Service
public class MobileJpaService implements MobileRepository
{
	@Autowired
	private MobileJpaRepository mobileJpaRepository;
	
	@Autowired
	private CustomerJpaRepository customerJpaRepository;

	@Override
	public ArrayList<Mobile> getMobiles() 
	{
		List mobileList=mobileJpaRepository.findAll();
		ArrayList<Mobile> mobiles=new ArrayList<>(mobileList);
		return mobiles;
	}

	@Override
	public Mobile getMobileById(int mobileId)
	{
		try 
		{
		Mobile mobile= mobileJpaRepository.findById(mobileId).get();
		return mobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Mobile addMobile(Mobile mobile)
	{
		 Customer customer=mobile.getCustomer(); 
		 //"customer": {"id":2}
		 int customerId=customer.getId(); //2
		 try 
		 {
			 Customer customer1=customerJpaRepository.findById(customerId).get();
		     mobile.setCustomer(customer1);
		     mobileJpaRepository.save(mobile);
		     return mobile;
		 }
		 catch(Exception e)
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		 
	}

	@Override
	public Mobile updateMobile(int mobileId, Mobile mobile) {
		
		try 
		{
		Mobile existingMobile= mobileJpaRepository.findById(mobileId).get();
		if(mobile.getName()!=null)
		{
			existingMobile.setName(mobile.getName());
		}
		if(mobile.getImage()!=null)
		{
			existingMobile.setImage(mobile.getImage());
		}
		if(mobile.getCustomer()!=null)
		{
			Customer customer=mobile.getCustomer(); //
			int customerId=customer.getId(); //2
			Customer newCustomer=customerJpaRepository.findById(customerId).get();
			existingMobile.setCustomer(newCustomer);
		}
		mobileJpaRepository.save(existingMobile);
		return existingMobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteMobile(int mobileId)
	{
		try 
		{
		Mobile mobile= mobileJpaRepository.findById(mobileId).get();
		if(mobile!=null)
		{
			mobileJpaRepository.deleteById(mobileId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public Customer getMobileCustomer(int mobileId)
	{
		try 
		{
		Mobile mobile=mobileJpaRepository.findById(mobileId).get();
		return mobile.getCustomer();
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
}
