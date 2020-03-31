package com.revature.quizzard.util;

import com.revature.quizzard.exceptions.AuthenticationException;
import com.revature.quizzard.exceptions.AuthorizationException;
import com.revature.quizzard.web.dtos.Principal;
import com.revature.quizzard.web.security.Secured;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {

    @Pointcut("@annotation(com.revature.quizzard.web.security.Secured)")
    public void securedEndpoints(){};

    @Around(value="securedEndpoints()")
    public Object securedEndpoint(ProceedingJoinPoint pjp) throws Throwable{

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured controllerAnnotation = method.getAnnotation(Secured.class);

        List<String> allowedRoles = Arrays.asList(controllerAnnotation.allowedRoles());
        HttpServletRequest req = (HttpServletRequest) pjp.getArgs()[0];
        Principal principal = (Principal) req.getAttribute("principal");

        if(principal == null){
            throw new AuthenticationException("An unauthorized request was made by an unauthenticated user.");
        }

        if(!allowedRoles.contains(principal.getRole().toString())){
            throw new AuthorizationException("A forbidden request was made by " + principal.getUsername());
        }
        return pjp.proceed();
    }
}
