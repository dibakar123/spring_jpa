package com.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDao;
import com.model.RestResponse;
import com.model.User;

 
@RestController
public class SpringRestController {
	
	@Autowired
	UserDao userdao;
	
	@RequestMapping(value = "/userlist", method = RequestMethod.GET,headers="Accept=application/json")
	public RestResponse getUser() {
		List<User> ulist= userdao.getUsers();
		RestResponse response= new RestResponse();
		if(ulist.size()>0){
			response.setCode(200);
			response.setMessage("get records");
			response.setData(ulist);
		}
		else {
			response.setCode(404);
			response.setMessage("not found records");
			response.setData(ulist);
		}
		return response;  	}
	
	@RequestMapping(value = "/userlist/{uid}", method = RequestMethod.GET)
	public RestResponse getUserById(@PathVariable String uid) {
		RestResponse response= new RestResponse();
		User user= userdao.getUser(uid);
		ArrayList<User> alist =new ArrayList<User>();
		alist.add(user);
		if(user!=null){
			response.setCode(200);
			response.setMessage("get record");
			response.setData(alist);
		}
		else {
			response.setCode(404);
			response.setMessage("not found records");
			response.setData(alist);
		}
			return response;  
			
		}
	
	@PostMapping(value = "/adduser",headers = "Accept=application/json")
	public RestResponse addUser(@RequestBody User user) {
		int result = userdao.register(user);
		RestResponse response= new RestResponse();
		ArrayList<User> alist =new ArrayList<User>();
		alist.add(user);
		if (result>0) {
			response.setCode(200);
			response.setMessage("insert record");
			response.setData(alist);
		}
		else {
			response.setCode(404);
			response.setMessage("insert not record");
			response.setData(alist);
		}
		return response;  }
	
  }