package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Enquiry;
import com.springboot.entity.User;
import com.springboot.exception.EnquiryErrorResponse;
import com.springboot.exception.EnquiryNotFoundException;
import com.springboot.exception.UserErrorResponse;
import com.springboot.exception.UserNotFoundException;
import com.springboot.service.EnquiryService;

@Controller
public class EnquiryController {

	private EnquiryService enquiryService;

	public EnquiryController(EnquiryService enquiryService) {
		super();
		this.enquiryService = enquiryService;
	}
	
	//Handler Method to handle list of enquiries
	
	@GetMapping("/enquiries")
	public String listEnquiries(Model model)
	{
		model.addAttribute("enquiries", enquiryService.getAllEnquiries());
		return "enquiries";
	}
	
	//
	
	public Enquiry getEnquiry(@PathVariable int enquiryId)
	{
		List<Enquiry> theEnquiry = new ArrayList();
		if(enquiryId < 0 || enquiryId > theEnquiry.size())
		{
			String errorMessage = "Enquiey Id Not Found:" +enquiryId;
			throw new EnquiryNotFoundException(errorMessage);
		}
		return theEnquiry.get(enquiryId);
	}
	// Exception Handler
	@ExceptionHandler
	 public ResponseEntity<EnquiryErrorResponse> handleException(EnquiryNotFoundException ene)

	 {
		EnquiryErrorResponse error = new EnquiryErrorResponse();
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(ene.getMessage());
		 error.setTimeStamp(System.currentTimeMillis());
		 return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		 
	 }
	
	//Handler method to handle new enquiry
	
	@GetMapping("/enquiries/new")
	public String createEnquiryForm(Model model)
	{
		// create enquiry object to hold enquiry form data
		
		Enquiry enquiry = new Enquiry();
		model.addAttribute("enquiry", enquiry);
		return "create-enquiry";
	}
	
	// Handler to save new enquiry
	
	@PostMapping("/enquiries")
	public String saveEnquiry(@ModelAttribute("enquiry") Enquiry enquiry)
	{
		enquiryService.saveEnquiry(enquiry);
		return "redirect:/enquiries";
	}
	
	@GetMapping("/enquiries/edit/{id}")
	public String editEnquiryForm(@PathVariable Long id, Model model)
	{
		model.addAttribute("enquiry", enquiryService.getEnquiryById(id));
		return "edit-enquiry";
	}
	
	@PostMapping("/enquiries/{id}")
	public String updateEnquiry(@PathVariable Long id,
			@ModelAttribute("enquiry") Enquiry enquiry,
			Model model)
			{
				// get enquiry from database by id
				Enquiry existingEnquiry = enquiryService.getEnquiryById(id);
				existingEnquiry.setFirstName(enquiry.getFirstName());
				existingEnquiry.setLastName(enquiry.getLastName());
				existingEnquiry.setEmail(enquiry.getEmail());
				existingEnquiry.setMessage(enquiry.getMessage());
				
				// save updated enquiry object
				enquiryService.updateEnquiry(existingEnquiry);
				return "redirect:/enquiries";
			}
	
	//Handler Method to delete
	@GetMapping("/enquiries/{id}")
	public String deleteEnquiry(@PathVariable Long id)
	{
		enquiryService.deleteEnquiryById(id);
		return "redirect:/enquiries";
	}
	
	
}
