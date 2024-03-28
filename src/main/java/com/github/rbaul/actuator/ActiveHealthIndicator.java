package com.github.rbaul.actuator;

import com.github.rbaul.actuator.events.ApplicationActivityActiveEvent;
import com.github.rbaul.actuator.events.ApplicationActivityEvent;
import com.github.rbaul.actuator.events.ApplicationActivityStandbyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component("active")
@RequiredArgsConstructor
public class ActiveHealthIndicator extends AbstractHealthIndicator {

    private final AppProperties appProperties;

    private final ApplicationEventPublisher applicationEventPublisher;

    private volatile boolean currentActiveState;
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean activeState = appProperties.isActiveState();

        if (currentActiveState != activeState) {
            log.info("Active state changed from {} -> {}", activeState, currentActiveState);
            ApplicationActivityEvent applicationActivityEvent = activeState ? new ApplicationActivityActiveEvent() : new ApplicationActivityStandbyEvent();
            this.applicationEventPublisher.publishEvent(applicationActivityEvent);
        }

        currentActiveState = activeState;
        builder.withDetail("active", activeState);
        if (activeState) {
            builder.up();
        } else {
            builder.down();
        }
    }
}
