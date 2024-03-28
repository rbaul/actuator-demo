package com.github.rbaul.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class AnnotationDrivenEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Wait for starting...");
//        try {
//            Thread.sleep(200000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        log.info("End waiting...");
    }

    @EventListener
    public void onEnvChangeEvent(EnvironmentChangeEvent environmentChangeEvent) {
        log.info("Hello");
    }
}