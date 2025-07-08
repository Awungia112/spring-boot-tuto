package com.adorsys_gis.demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingComponent {
    private static final Logger logger = LoggerFactory.getLogger(LoggingComponent.class);
    @Before("execution(* com.adorsys_gis.demo..*(..))")
    public void logBeforeMethod() {
        logger.info("A method in com.adorsys_gis.demo package is about to be executed.");
    }

}

