package com.project.Service;

import com.project.Model.GoogleUser;

public interface GoogleUserService {

	public GoogleUser getData(String customername, String customerpassword) throws Exception;
	
}
