package com.alax.controller;
import com.alax.Service.QuestionService;
import com.alax.dto.QuestionDTO;
import com.alax.mapper.QuestionMapper;
import com.alax.mapper.UserMapper;
import com.alax.model.Question;
import com.alax.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length !=0)
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
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }
}
