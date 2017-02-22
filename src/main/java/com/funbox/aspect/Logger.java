package com.funbox.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Анна on 22.02.2017.
 */
@Aspect
public class Logger {

    @Pointcut("execution(** com.funbox.chassis.Chassis.ride(..))")
    public void execute() {
        System.out.println("poincut");
    }

    @Before("execute()")
    public void before() {
        System.out.println("before");
    }

    @After("execute()")
    public void after() {
        System.out.println("after");
    }

    @Around("execute()")
    public void around(ProceedingJoinPoint jp) {
        System.out.println("around begin");
        try {
            Object result = jp.proceed();
            System.out.println("result = " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around end");
    }
}
