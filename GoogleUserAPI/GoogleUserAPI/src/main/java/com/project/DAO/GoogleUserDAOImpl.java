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
//Query query = em.createQuery("select g from GoogleUserEntity g where g.name=?1 and g.password=?2");
//query.setParameter(1, customername);
//query.setParameter(2, customerpassword);
//List<GoogleUserEntity> list = query.getResultList();
//if(!list.isEmpty())
//{
//	g=new GoogleUser();
//	g.setName(list.get(0).getName());
//	g.setPassword(list.get(0).getPassword());
//	g.setDob(list.get(0).getDob());
//	g.setEmail(list.get(0).getEmail());
//	g.setFirstname(list.get(0).getFirstname());
//	g.setLastname(list.get(0).getLastname());
//}

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
