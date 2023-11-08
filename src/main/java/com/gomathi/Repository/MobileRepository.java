package com.gomathi.Repository;

import java.util.ArrayList;

import com.gomathi.Model.Customer;
import com.gomathi.Model.Mobile;

public interface MobileRepository
{
	ArrayList<Mobile> getMobiles();
	Mobile getMobileById(int mobileId);
	Mobile addMobile(Mobile mobile);
	Mobile updateMobile(int mobileId, Mobile mobile);
	void deleteMobile(int mobileId);
	Customer getMobileCustomer(int mobileId);
}
