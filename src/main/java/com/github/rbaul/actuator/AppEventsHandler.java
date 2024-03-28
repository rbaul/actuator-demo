package com.github.rbaul.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class AppEventsHandler {
    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEventExecute() {
        log.info("Context Event Listener is getting executed");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void eventListenerExecute2() {
        log.info("Application Ready Event is successfully Started - 2");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void eventListenerExecute() {
        log.info("Application Ready Event is successfully Started");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @EventListener(ApplicationFailedEvent.class)
    public void eventListenerExecuteFailed() {
        log.info("Application Event Listener is Failed");
    }

    @EventListener
    public void onEnvChangeEvent(EnvironmentChangeEvent environmentChangeEvent) {
        log.info("Environment Change Event");
    }

    @EventListener
    public void onReadinessStateChangeEvent(AvailabilityChangeEvent<ReadinessState> event) {
        log.info("Readiness State Change Event: {}", event.getState());
    }
}
