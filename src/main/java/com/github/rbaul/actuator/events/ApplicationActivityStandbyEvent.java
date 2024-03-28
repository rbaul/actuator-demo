package com.github.rbaul.actuator.events;

import lombok.ToString;

@ToString
public class ApplicationActivityStandbyEvent extends ApplicationActivityEvent {

    public ApplicationActivityStandbyEvent() {
        super(false);
    }
}
