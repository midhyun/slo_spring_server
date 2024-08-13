package slo.slo_spring_server.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN,ROLE_USER"),
    SOCIAL("ROLE_SOCIAL");

    private final String value;

    public static String getIncludingRoles(String role) {
        return Role.valueOf(role).getValue();
    }

    public static Role fromValue(String value) {
        for (Role role : Role.values()) {
            if (role.getValue().equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("No role found for value: " + value);
    }
}
