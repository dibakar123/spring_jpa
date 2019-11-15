package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(path= "/greet",method=RequestMethod.GET)    
    public String greet(){
         System.out.println("greet is invoked");
         return "show";
    }
}