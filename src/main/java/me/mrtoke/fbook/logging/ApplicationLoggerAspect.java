package me.mrtoke.fbook.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(ApplicationLoggerAspect.class);
	
	@Pointcut("within(me.mrtoke.fbook.controllers..*)"
			+ "|| within(me.mrtoke.fbook.services..*)")
	public void definePackagePointcuts() {
		// empty method just to name the location specified in the pointcut
		
	}
	
//	@Before("definePackagePointcuts()")
//	public void logBefore(JoinPoint jp) {
//		log.debug("\n---------BEFORE---------\nPackage: {}\nMethod Name: {}\nArguments: {}\n", 
//				jp.getSignature().getDeclaringTypeName(), 
//				jp.getSignature().getName(), 
//				Arrays.toString(jp.getArgs()));
//	}
//	
//	@After("definePackagePointcuts()")
//	public void logAfter() {
//		log.debug("\n---------AFTER---------\n");
//	}
	
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint pjp) {
		log.debug("\n---------BEFORE---------\nPackage: {}\nMethod Name: {}\nArguments: {}\n", 
				pjp.getSignature().getDeclaringTypeName(), 
				pjp.getSignature().getName(), 
				Arrays.toString(pjp.getArgs()));
		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("\n---------AFTER---------\nPackage: {}\nMethod Name: {}\nArguments: {}\n", 
				pjp.getSignature().getDeclaringTypeName(), 
				pjp.getSignature().getName(), 
				Arrays.toString(pjp.getArgs()));
		return o;
	}
}
