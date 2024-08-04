package slo.slo_spring_server.domain.diet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DietType {
    BREAKFAST("BREAKFAST"),
    LUNCH("LUNCH"),
    DINNER("DINNER"),
    SNACK("SNACK");

    private final String value;
}
