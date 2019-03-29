package com.thinker4cloud.thinker.auth.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public final class SecurityUtils {


    public static Optional<String> getCurrentUserUsername() {
        String currentUserName = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }

        if (currentUserName == null) {
            return Optional.of(Constants.ANONYMOUS_USER);
        } else {
            return Optional.of(currentUserName);
        }
    }

}
