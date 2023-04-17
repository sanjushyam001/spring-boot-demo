package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }


    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public User user(){
        User user=new User();
        user.setId(1);
        user.setName("Shabir");
        user.setEmail("shabir@yahoo.in");
        return user;
    }
    @GetMapping("/user/{id}")
    public String pathvariable(@PathVariable String id){

        return "Requested id is : "+id;
    }
    @GetMapping("/user/info")
    public String requestparam(
            @RequestParam String name,
            @RequestParam(name ="email" ,required = false,defaultValue = "JHON") String emailAddress){

        return "Requested name is : "+name +" and email is : "+emailAddress;
    }
}
