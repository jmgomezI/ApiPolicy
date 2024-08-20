package jmgomez.apipolicy.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class UserValidatorInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loggedUser = request.getUserPrincipal().getName();
        String requestedUserId = request.getParameter("userId");

        if (requestedUserId != null && !loggedUser.equalsIgnoreCase(requestedUserId)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authorized");
            return false;
        } else {
            return true;
        }
    }
}
