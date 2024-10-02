package jmgomez.policyapi.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jmgomez.policyapi.exception.BadRequestException;
import jmgomez.policyapi.service.PolicyService;
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

        if (handler instanceof HandlerMethod) {
            if (policyId != null && !isPolicyOfUser(policyId, userId)) {
                throw new BadRequestException("Policy with ID " + policyId + " was not found by this user");
            }
            if (accidentId != null && policyId != null) {
                if (!isAccidentOfPolicy(accidentId, policyId) || !isPolicyOfUser(policyId, userId)) {
                    throw new BadRequestException("Accident with ID " + accidentId + " was not found by this policy");
                }
            }
        }
        return true;
    }

    public boolean isPolicyOfUser(String policyId, String userId) {
        return policyService.getPolicies(userId).stream().anyMatch(policyDto -> policyDto.getPolicyId().equals(policyId));
    }

    public boolean isAccidentOfPolicy(String accidentId, String policyId) {
        return policyService.getAccidents(policyId).stream().anyMatch(accidentDto -> accidentDto.getSinisterId().equals(accidentId));
    }
}
