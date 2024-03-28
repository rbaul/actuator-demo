package com.github.rbaul.actuator.events;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class ApplicationActivityEvent extends ApplicationEvent {

    private final boolean active;

    public ApplicationActivityEvent(boolean active) {
        super(active);
        this.active = active;
    }
}
