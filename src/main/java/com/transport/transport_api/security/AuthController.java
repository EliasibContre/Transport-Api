package com.transport.transport_api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "basicAuth")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenService jwtTokenService;

    @PostMapping("/token")
    public TokenResponse token(Authentication authentication) {
        return new TokenResponse(jwtTokenService.issue(authentication));
    }

    public record TokenResponse(String accessToken) {}


}
