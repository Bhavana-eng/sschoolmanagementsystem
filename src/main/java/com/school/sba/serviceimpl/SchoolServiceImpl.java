package com.school.sba.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.sba.entity.School;
import com.school.sba.repository.SchoolRepo;
import com.school.sba.service.SchoolService;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolRepo schoolRepo;

	@Override
	public School saveSchool(School school) {

		return schoolRepo.save(school);
	}








}
