package com.springtesting.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController
{
    private Logger log=LoggerFactory.getLogger(LoginController.class);

    @Resource(name="authenticationManager")
    private AuthenticationManager authManager;

    @GetMapping(value = {"/","/login"})
    public ModelAndView getLoginPage(HttpServletRequest request)
    {
        ModelAndView modelAndView=new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // If NOT anonymous user, get user info
        if (!(authentication instanceof AnonymousAuthenticationToken))
        {
            String username=request.getUserPrincipal().getName();
            Cookie[] cookies=request.getCookies();
            for(Cookie cookie: cookies)
            {
                if(cookie.getName().equals("JSESSIONID"))
                {
                    String sessionValue=cookie.getValue();
                }
            }
            modelAndView.setViewName("redirect:home");
            return modelAndView;
        }
        else
        {
            modelAndView.addObject("message", "Login Page");
            modelAndView.setViewName("login");
        }
        modelAndView.addObject("message", "Login Page");
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @PostMapping(value = "/login")
    public ModelAndView validateLoginDetails(@RequestParam("username") String username, @RequestParam("password") String password, final HttpServletRequest request)
    {
        //This is not being executed as Authentication Success Handler redirects page
        //Store Session
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
        Authentication auth = authManager.authenticate(authReq);
        //PreAuthenticatedAuthenticationToken preAuthenticatedAuthenticationToken=new PreAuthenticatedAuthenticationToken();
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(value = {"/home","/home.html"})
    public ModelAndView loadHomePage(HttpServletRequest request)
    {
        ModelAndView modelAndView=new ModelAndView();
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AnonymousAuthenticationToken)
        {
            modelAndView.setViewName("redirect:login");
            return modelAndView;
        }

        Cookie[] cookies=request.getCookies();
        for(Cookie cookie: cookies)
        {
            if(cookie.getName().equals("JSESSIONID"))
            {
                String sessionValue=cookie.getValue();
            }
        }

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
