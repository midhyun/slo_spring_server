package slo.slo_spring_server.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE("MALE"), FEMALE("FEMALE");

    private final String value;
}
