package com.springboot.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.dao.EnquiryDao;
import com.springboot.entity.Enquiry;
import com.springboot.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {
	
	private EnquiryDao enquiryDao;
	
	

	public EnquiryServiceImpl(EnquiryDao enquiryDao) {
		super();
		this.enquiryDao = enquiryDao;
	}



	@Override
	public List<Enquiry> getAllEnquiries() {
		
		return enquiryDao.findAll();
	}



	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {
		
		return enquiryDao.save(enquiry);
	}



	@Override
	public Enquiry getEnquiryById(Long id) {
		
		return enquiryDao.findById(id).get();
	}



	@Override
	public Enquiry updateEnquiry(Enquiry enquiry) {
		return enquiryDao.save(enquiry);
	}



	@Override
	public void deleteEnquiryById(Long id) {
		enquiryDao.deleteById(id);
		
	}

}
