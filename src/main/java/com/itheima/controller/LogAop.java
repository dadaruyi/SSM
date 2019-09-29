package com.itheima.controller;

import com.itheima.domain.Log;
import com.itheima.domain.User;
import com.itheima.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    @Autowired
    LogService logService;
    @Autowired
    private HttpServletRequest request;
    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        Date start = new Date();
        Object proceed = pjp.proceed();
        long cost=new Date().getTime()-start.getTime();
        String className = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();

        User user = (User) request.getSession().getAttribute("user");
        String username="";
        if (user!=null){
            username = user.getName();
        }else {
            username = request.getParameter("name") + "[登录失败]";
        }
        Log log = new Log();
        log.setCost(cost);
        log.setName(username);
        log.setTime(new Date());
        log.setUrl("[类名]"+className+"[方法名]"+methodName);
        logService.insert(log);
        return proceed;
    }
    }

