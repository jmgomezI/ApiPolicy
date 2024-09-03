package jmgomez.apipolicy.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jmgomez.apipolicy.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import java.io.IOException;
import java.util.Map;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    private final PolicyService policyService;

    @Autowired
    public RequestInterceptor(@Lazy PolicyService policyService) {
        this.policyService = policyService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        String authUserId = SecurityContextHolder.getContext().getAuthentication().getName();

        Map<String, String> variables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        String userId = authUserId;
        String policyId = variables.get("policyId");
        String accidentId = variables.get("accidentId");

        if(handler instanceof HandlerMethod) {
            if(request.getRequestURI().equals("/policies") && userId != null) {
              return true;
            } else if (request.getRequestURI().equals("/policies/" + policyId) && policyId != null && isPolicyOfUser(policyId, userId)) {
                return true;
            } else if (request.getRequestURI().equals("/policies/" + policyId + "/accidents") && policyId != null && isPolicyOfUser(policyId, userId)) {
                return true;
            } else if (request.getRequestURI().equals("/policies/" + policyId + "/accidents/" + accidentId) && policyId != null && accidentId != null && isPolicyOfUser(policyId, userId) && isAccidentOfPolicy(accidentId, policyId)) {
                return true;
            }

        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("You have no access with this user");
        return false;
    }

    public boolean isPolicyOfUser(String policyId, String userId) {
        return policyService.getPolicies(userId).stream().anyMatch(policy -> policy.getPolicyId().equals(policyId));
    }

    public boolean isAccidentOfPolicy(String accidentId, String policyId) {
        return policyService.getAccidents(policyId).stream().anyMatch(accident -> accident.getSinisterId().equals(accidentId));
    }
}
