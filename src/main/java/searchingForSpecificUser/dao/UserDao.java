package searchingForSpecificUser.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import searchingForSpecificUser.Model.User;

@Component
public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createUser(User user) 
	{
		this.hibernateTemplate.save(user);
	}
	
	public List<User> getUsers()
	{
		List<User> users =this.hibernateTemplate.loadAll(User.class);
		return users;
	}
	

	@Transactional
	public void deleteUser(int uid)
	{
		User u =this.hibernateTemplate.load(User.class, uid);
		this.hibernateTemplate.delete(u);
	}
	
	public void getUser(int uid)
	{
		this.hibernateTemplate.get(User.class, uid);
	}

}
