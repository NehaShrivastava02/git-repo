package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Enquiry;

public interface EnquiryDao extends JpaRepository<Enquiry, Long> {

}
