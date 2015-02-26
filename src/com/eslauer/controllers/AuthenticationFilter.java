package com.eslauer.controllers;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@Component
@Scope("singleton")
public final class AuthenticationFilter extends GenericFilterBean {

	@Autowired
	private AuthenticateUser userAuth;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String context = httpRequest.getContextPath();
		//String url = httpRequest.getServletPath();

		if (!userAuth.isAuthenticated()) {
			httpResponse.sendRedirect(context + "/index.xhtml");
		} else {
			//System.out.println("User is authenticated.");
			filterChain.doFilter(request, response);
		}

	}
}
