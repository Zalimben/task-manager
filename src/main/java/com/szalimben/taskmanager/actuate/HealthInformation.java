package com.szalimben.taskmanager.actuate;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthInformation implements org.springframework.boot.actuate.health.HealthIndicator
{
    @Override
    public Health getHealth(boolean includeDetails)
    {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health()
    {
        if (isDbUp()) {
            return Health.up()
                .build();
        } else {
            return Health.down()
                .withDetail("Error Code", 503)
                .build();
        }
    }

    private boolean isDbUp() {
        return false;
    }
}
