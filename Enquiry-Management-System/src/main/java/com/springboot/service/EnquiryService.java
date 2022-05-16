package com.springboot.service;

import java.util.List;

import com.springboot.entity.Enquiry;
import com.springboot.entity.User;

public interface EnquiryService {
	
	List<Enquiry> getAllEnquiries();
	
	Enquiry saveEnquiry(Enquiry enquiry);
	
	Enquiry getEnquiryById(Long id);
	
	Enquiry updateEnquiry(Enquiry enquiry);
	
	void deleteEnquiryById(Long id);

}
