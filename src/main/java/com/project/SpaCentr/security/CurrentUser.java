package com.project.SpaCentr.security;

import org.springframework.security.core.context.SecurityContextHolder;

public final class CurrentUser {
    private CurrentUser(){}
    public  static EmployeePrincipal principal (){
        return (EmployeePrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    }
    public static Long id(){
        return  principal().getId();
    }
}
