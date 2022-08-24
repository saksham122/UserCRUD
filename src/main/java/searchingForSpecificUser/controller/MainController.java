package searchingForSpecificUser.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import searchingForSpecificUser.Model.User;
import searchingForSpecificUser.dao.UserDao;

@Controller
public class MainController {
	
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public String home(Model m) 
	{
		List<User>users=userDao.getUsers();
		m.addAttribute("users",users);
		return "index";
	}
	
	@RequestMapping("/add-user")
	public String addUser(Model m)
	{
		m.addAttribute("title","Add User");
		return "add_user_form";
	}
	
	@RequestMapping(value="/handle-user", method = RequestMethod.POST)
	public RedirectView handUser(@ModelAttribute User user,HttpServletRequest request)
	{
		System.out.println(user);
		userDao.createUser(user);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/delete/{userId}")
	public RedirectView deleteUser(@PathVariable("userId")int userId ,HttpServletRequest request) 
	{
		this.userDao.deleteUser(userId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update/{userId}")
	public String updateForm(@PathVariable("userId")int uid ,Model model)
	{
		User user = new User();
	    this.userDao.getUser(uid);
		model.addAttribute("user",user);
		return "update_form";
	}
	@RequestMapping("/search-user")
	public String searchUser(@PathVariable("userId")int uid,Model model)
	{
		User user = new User();
		this.userDao.getUser(uid);
		model.addAttribute(user);
		return "search-user";
	}

}
