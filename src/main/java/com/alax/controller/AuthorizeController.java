package com.alax.controller;

import com.alax.domain.AccessTokenDTO;
import com.alax.domain.GithubUser;
import com.alax.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizeController {

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;

    @Autowired
    private GithubProvider githubProvider;

    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                            HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        if (user !=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            return "redirect:/";
        }

    }
}
