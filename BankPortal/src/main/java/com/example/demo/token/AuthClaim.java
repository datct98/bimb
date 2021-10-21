package com.example.demo.token;

import com.example.demo.security.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import javax.servlet.http.HttpServletRequest;


public class AuthClaim {
    public static boolean isLogin(HttpServletRequest request) {
        if (request == null) {
            return false;
        }
        final String authHeader = request.getHeader("authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return false;
        }

        final String token = authHeader.substring(7);
        try {
            Jwts.parser().setSigningKey(TokenConfig.getSecureKey()).parseClaimsJws(token);
            return true;
        } catch (final SignatureException e) {
        } catch (Exception ex) {
        }
        return false;
    }

    public static int getUserId(HttpServletRequest request) {
        if (request == null) {
            return 0;
        }
        Claims claims = null;
        if (JwtUtils.isExistClaims(request)) {
            claims = JwtUtils.getClaims(request);
        } else {
            final String authHeader = request.getHeader("authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return 0;
            }

            final String token = authHeader.substring(7);
            try {
                claims = Jwts.parser().setSigningKey(TokenConfig.getSecureKey()).parseClaimsJws(token).getBody();

            } catch (final SignatureException e) {
            } catch (Exception ex) {
            }
        }
        if (claims != null) {
            return ClaimsUtils.getUserId(claims);
        }
        return 0;
    }
}
