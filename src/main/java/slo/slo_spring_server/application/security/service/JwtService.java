package slo.slo_spring_server.application.security.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import slo.slo_spring_server.domain.user.User;

import java.util.Optional;

public interface JwtService {

    String createAccessToken(User user);
    String createRefreshToken(User user);

    String updateRefreshToken(User user, String refreshToken);

    void sendAccessAndRefreshToken(HttpServletResponse response, String accessToken, String refreshToken);
    void sendAccessToken(HttpServletResponse response, String accessToken);

    Optional<String> extractAccessToken(HttpServletRequest request);

    Optional<String> extractRefreshToken(HttpServletRequest request);

    void setAccessTokenHandler(HttpServletRequest request, String accessToken);
    void setRefreshTokenHandler(HttpServletRequest request, String refreshToken);

    boolean isTokenValid(String token);

}
