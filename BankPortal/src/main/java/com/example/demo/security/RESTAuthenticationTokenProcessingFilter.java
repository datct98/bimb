package com.example.demo.security;

import com.example.demo.constant.Constants;
import com.example.demo.constant.Message;
import com.example.demo.controller.response.Response;
import com.example.demo.exception.common.ExceptionCreater;
import com.example.demo.token.AuthClaim;
import com.example.demo.token.TokenConfig;
import com.example.demo.untils.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RESTAuthenticationTokenProcessingFilter extends GenericFilterBean {
    //private static final String SNS_CERT = "Zxczjahsduqweozasdkluiqweuhskadsasd";

    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");

        int userId = AuthClaim.getUserId(request);
        if(userId != 0){
            req.setAttribute("userId",userId);
        }

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);
        } else {

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write(getReturnAuthErrorString());
                return;
            }

            final String token = authHeader.substring(7);

            try {
                if(Constants.STATUS_MAINTAIN==1){
                    response.getWriter().write(getMaintainErrorString());
                    response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
                    response.addHeader("Accept", "application/json");
                    response.addHeader("Content-Type", "application/json");
                    return;
                }
                final Claims claims = Jwts.parser().setSigningKey(TokenConfig.getSecureKey()).parseClaimsJws(token).getBody();
                JwtUtils.setClaimsKey(request, claims);
            } catch (final SignatureException e) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write(getReturnAuthErrorString());
                response.addHeader("Accept", "application/json");
                response.addHeader("Content-Type", "application/json");
                return;
            } catch (Exception ex) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write(getReturnAuthErrorString());
                response.addHeader("Accept", "application/json");
                response.addHeader("Content-Type", "application/json");
                return;
            }

            chain.doFilter(req, res);
        }
    }

    private String getReturnAuthErrorString() throws JsonProcessingException {
        Response response = new Response(ExceptionCreater.AUTH_ERROR, Message.ERROR_INVALID_TOKEN);
        Log.error("#getReturnAuthErrorString",""+Message.ERROR_INVALID_TOKEN);
        return convertObjectToJson(response);
    }

    private String getMaintainErrorString() throws JsonProcessingException {
        Response response = new Response(ExceptionCreater.ERROR_MAINTAIN, Message.ERROR_MAINTAIN);
        Log.error("#getMaintainErrorString",""+Message.ERROR_MAINTAIN);
        return convertObjectToJson(response);
    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}