package com.example.bookstore.config;

import com.example.bookstore.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user == null && !request.getRequestURI().equals("/login")){
            response.sendRedirect("/login");
            return false;
        }
        else if(user == null){
            return true;
        }
        else if(user.getRole().equals("user") && request.getContextPath().contains("/admin")){
            response.sendRedirect("/user");
            return false;
        }
        return true;
    }
}
