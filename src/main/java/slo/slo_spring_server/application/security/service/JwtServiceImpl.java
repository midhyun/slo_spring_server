package slo.slo_spring_server.application.security.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import slo.slo_spring_server.domain.user.User;

import java.util.Optional;

@Service
public class JwtServiceImpl implements JwtService {

    @Override
    public String createAccessToken(User user) {
        return "";
    }

    @Override
    public String createRefreshToken(User user) {
        return "";
    }

    @Override
    public String updateRefreshToken(User user, String refreshToken) {
        return "";
    }

    @Override
    public void sendAccessAndRefreshToken(HttpServletResponse response, String accessToken, String refreshToken) {

    }

    @Override
    public void sendAccessToken(HttpServletResponse response, String accessToken) {

    }

    @Override
    public Optional<String> extractAccessToken(HttpServletRequest request) {
        return Optional.empty();
    }

    @Override
    public Optional<String> extractRefreshToken(HttpServletRequest request) {
        return Optional.empty();
    }

    @Override
    public void setAccessTokenHandler(HttpServletRequest request, String accessToken) {

    }

    @Override
    public void setRefreshTokenHandler(HttpServletRequest request, String refreshToken) {

    }

    @Override
    public boolean isTokenValid(String token) {
        return false;
    }
}
