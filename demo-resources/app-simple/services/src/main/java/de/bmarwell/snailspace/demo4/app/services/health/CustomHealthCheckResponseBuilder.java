package de.bmarwell.snailspace.demo4.app.services.health;

import java.util.Optional;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponse.Status;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

public class CustomHealthCheckResponseBuilder extends HealthCheckResponseBuilder {

    String name = "";
    Status status = Status.UP;

    @Override
    public HealthCheckResponseBuilder name(String s) {
        this.name = s;
        return this;
    }

    @Override
    public HealthCheckResponseBuilder withData(String s, String s1) {
        return this;
    }

    @Override
    public HealthCheckResponseBuilder withData(String s, long l) {
        return this;
    }

    @Override
    public HealthCheckResponseBuilder withData(String s, boolean b) {
        return this;
    }

    @Override
    public HealthCheckResponseBuilder up() {
        this.status = Status.UP;
        return this;
    }

    @Override
    public HealthCheckResponseBuilder down() {
        this.status = Status.DOWN;
        return this;
    }

    @Override
    public HealthCheckResponseBuilder status(boolean b) {
        return this;
    }

    @Override
    public HealthCheckResponse build() {
        return new HealthCheckResponse(this.name, this.status, Optional.empty());
    }
}
