package com.alax.controller;
import com.alax.mapper.UserMapper;
import com.alax.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                 User user =userMapper.findByToken(token);
                 if (user !=null){
                     request.getSession().setAttribute("user",user);
                 }
                 break;

            }
        }

        return "index";
    }
}
