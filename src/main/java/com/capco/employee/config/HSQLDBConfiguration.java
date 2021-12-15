package com.capco.employee.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class HSQLDBConfiguration {
    @EventListener(ApplicationReadyEvent.class)
    public void startHSQLGUIAfterStartup() {
        System.setProperty("java.awt.headless", "false");
    }
}
