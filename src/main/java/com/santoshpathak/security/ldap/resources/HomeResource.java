/**
 * 
 */
package com.santoshpathak.security.ldap.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author santoshpathak
 *
 */
@RestController
public class HomeResource {
	
	/**
	 * username ben
	 * password benpassword
	 * @return
	 */
	@GetMapping(value = "/")
	public String homepage() {
		return "Home Page of Spring secuity LDAP Demo!!!";
	}


}
