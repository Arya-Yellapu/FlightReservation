package com.project.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.project.Entity.GoogleUserEntity;
import com.project.Model.GoogleUser;

@Repository
public class GoogleUserDAOImpl implements GoogleUserDAO{

@PersistenceContext
private EntityManager em;

@Override
public GoogleUser getData(String customeremail, String customerpassword) {
	
GoogleUser g = null;	

GoogleUserEntity ge = em.find(GoogleUserEntity.class, customeremail);
if(ge!=null)
{
	if(ge.getPassword().equals(customerpassword))
	{
	g=new GoogleUser();
	g.setDob(ge.getDob());
	g.setEmail(ge.getEmail());
	g.setFirstname(ge.getFirstname());
	g.setLastname(ge.getLastname());
	g.setName(ge.getName());
	g.setPassword(ge.getPassword());
	}
}
return g;
	
}

	
}
