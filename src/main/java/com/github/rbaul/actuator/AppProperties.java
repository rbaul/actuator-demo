package com.github.rbaul.actuator;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@RefreshScope
@Data
@ConfigurationProperties("rbaul.actuator")
public class AppProperties {
    private boolean activeState = true;
}
