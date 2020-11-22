package com.demo.complaintsystem;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.complaintsystem.dao.ComplaintDao;
import com.demo.complaintsystem.entities.Complaint;

@Controller
public class App 
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	
    @RequestMapping("/fileComplaint")
    public String hello()
    {
//    	Complaint p = new Complaint("Hello","bob","bob@gmail.com");
//    	ComplaintDao dao =  new ComplaintDao(sessionFactory);
//    	dao.insertComplain(p);
//    	for(Complaint i:dao.getAllComplaints())
//    	{
//    		System.out.println(i.getMessage());
//    	}
    	System.out.println("filing");
    	return "Welcome";
    }
    
    @RequestMapping("/submitComplaint")
    public String submitComplaint(@RequestParam("Message") String message,
    		@RequestParam("email") String email,
    		@RequestParam("name") String name)
    {
    	ComplaintDao c =  new ComplaintDao(sessionFactory);
    	Complaint d = new Complaint(message,name,email);
    	c.insertComplain(d);
    	return "submitComplaint";
    }
    
   
    
    @RequestMapping("/showComplaints")
    public String showComplaints(Model model)
    {
    	ComplaintDao dao =  new ComplaintDao(sessionFactory);
    	List<Complaint> compl = dao.getAllComplaints();
    	model.addAttribute("complaints",compl);
    	return "showResult";
    	
    }
    
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logoutpage(HttpServletRequest request,HttpServletResponse response)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth!=null)
    	{
    		new SecurityContextLogoutHandler().logout(request,response,auth);
    	}
    	return "logsuccess";
    }
    
    
    
    
}
