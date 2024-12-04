package dev.norby.amatur.authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Set the response status code to 403 Forbidden
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        // Optionally, you can send a custom error message as the response body
        response.getWriter().write("Access Denied: You do not have permission to access this resource.");

        // Flush the response
        response.getWriter().flush();
    }
}
