package slo.slo_spring_server.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    ACT("ACTIVE"),
    DOR("DORMANT"),
    DEL("DELETE");

    private final String value;

}
