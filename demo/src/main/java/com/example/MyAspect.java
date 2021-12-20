package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAspect {

	@AfterReturning("""
			@within(com.example.MyAnnotation)
			&& (execution(* *.*(..)) || execution(* .new(..)))
			""")
	public void intercept(JoinPoint JoinPoint) throws Throwable {
		System.out.println("********** InvocationAspect intercepted.");
	}
}
