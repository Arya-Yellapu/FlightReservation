package com.project.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.DAO.GoogleUserDAO;
import com.project.Model.GoogleUser;

@Transactional
@Service
public class GoogleUserServiceImpl implements GoogleUserService  {

	@Autowired
	private GoogleUserDAO googleuserDAO;
	
	@Override
	public GoogleUser getData(String customeremail, String customerpassword) throws Exception{
	GoogleUser g = googleuserDAO.getData(customeremail, customerpassword);
	if(g==null)
	{
		throw new Exception("No Data Found");
	}
	return g;
		
	}
}
