package com.github.rbaul.actuator;

import com.github.rbaul.actuator.events.ApplicationActivityActiveEvent;
import com.github.rbaul.actuator.events.ApplicationActivityEvent;
import com.github.rbaul.actuator.events.ApplicationActivityStandbyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class ActivityEventsListener {

    private final Environment environment;

    private final ApplicationContext applicationContext;

    @EventListener
    public void onApplicationActivityActiveEvent(ApplicationActivityActiveEvent event) {
        log.info("Application state: {}", event.isActive());
    }

    @EventListener
    public void onApplicationActivityStandbyEvent(ApplicationActivityStandbyEvent event) {
        log.info("Application state: {}", event.isActive());
    }

    @EventListener({
            ApplicationActivityActiveEvent.class,
            ApplicationActivityStandbyEvent.class
    })
    public void onApplicationActivityEvent(ApplicationActivityEvent event) {
        log.info("Application Change event: {}", event.isActive());
    }

    @EventListener(ApplicationActivityActiveEvent.class)
    public void onApplicationActivityActiveEvent() {
        log.info("ApplicationActivityActiveEvent");
    }

    @EventListener(ApplicationActivityStandbyEvent.class)
    public void onApplicationActivityStandbyEvent() {
        log.info("ApplicationActivityStandbyEvent");
    }


    @EventListener(RefreshScopeRefreshedEvent.class)
    public void onRefreshEvent() {
        log.info("onRefreshEvent");
    }
}
