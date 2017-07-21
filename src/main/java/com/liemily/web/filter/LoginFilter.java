package com.liemily.web.filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by Emily Li on 21/07/2017.
 */
public class LoginFilter extends FormAuthenticationFilter {
    private static final Logger logger = LogManager.getLogger(LoginFilter.class);

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        boolean loginFailure = super.onLoginFailure(token, e, request, response);
        try {
            WebUtils.issueRedirect(request, response, "/login?error");
        } catch (IOException ioe) {
            logger.error("Failed to issue login failure redirect to /login?error", ioe);
        }
        return loginFailure;
    }
}
