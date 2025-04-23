package de.bmarwell.snailspace.demo4.app.services.health;

import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.spi.HealthCheckResponseProvider;

public class CustomHealthCheckResponseProvider implements HealthCheckResponseProvider {

    @Override
    public HealthCheckResponseBuilder createResponseBuilder() {
        return new CustomHealthCheckResponseBuilder();
    }
}
