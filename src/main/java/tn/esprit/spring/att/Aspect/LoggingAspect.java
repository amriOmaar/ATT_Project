package tn.esprit.spring.att.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Before("execution(public * tn.esprit.spring.att.service.*.*(..))")
    public void logExecution(JoinPoint joinPoint) {
        // Log message
        logger.info("Méthode Exécutée " + joinPoint.getSignature().getName());
    }


}

