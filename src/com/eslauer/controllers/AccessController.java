package com.eslauer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@Component
@Scope("session")
public class AccessController {

	@Autowired
	private UserAuthBean authUser;

	// filter by: authentication, roles, and user (if all fail try user)
	// associate, manager, administrator. differenet pages available to
	// different permissions levels.
	
	
	
}
