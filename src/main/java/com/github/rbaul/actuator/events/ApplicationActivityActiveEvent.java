package com.github.rbaul.actuator.events;

import lombok.ToString;

@ToString
public class ApplicationActivityActiveEvent extends ApplicationActivityEvent {

    public ApplicationActivityActiveEvent() {
        super(true);
    }
}
