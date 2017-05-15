package me.songt.smartpaper.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by tony on 2017/4/10.
 */
public class AuthenticationTokenProcessingFilter extends GenericFilterBean
{
    private final Logger logger = LoggerFactory.getLogger(AuthenticationTokenProcessingFilter.class);
    private AuthenticationManager authenticationManager;
    private TokenUtils tokenUtils;

    public AuthenticationTokenProcessingFilter(AuthenticationManager authenticationManager, TokenUtils tokenUtils)
    {
        this.authenticationManager = authenticationManager;
        this.tokenUtils = tokenUtils;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        Map<String, String[]> requestParams = servletRequest.getParameterMap();
        final String AUTH_FILTER_NAME = "token";
        if (requestParams.containsKey(AUTH_FILTER_NAME))
        {
            String token = requestParams.get(AUTH_FILTER_NAME)[0];
            logger.debug(token);
            if (tokenUtils.validate(token))
            {
                UserDetails user = tokenUtils.getUser(token);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),
                        user.getPassword(), user.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) servletRequest));
                Authentication authentication = authenticationManager.authenticate(authenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
    }
}
