package com.paul.webrestfulcrud.controller;

import com.paul.webrestfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/3/31 18:34
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "hello";
    }

//    @RequestMapping({"/","/index.html"})
////    public String index(){
////        return "index";
////    }
}
