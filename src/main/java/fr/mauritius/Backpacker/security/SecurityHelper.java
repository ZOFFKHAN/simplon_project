package fr.mauritius.Backpacker.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class SecurityHelper {
    // classe utilitaire
    public static String username() {

	JwtAuthenticationToken token = token();
	return token.getName();
    }

    public static Long accountid() {

	JwtAuthenticationToken token = token();
	return (Long) token.getTokenAttributes().get("accountId");
    }

    public static Long accountidbis() {
//si on utilise l'ID de type long en tant que suject
	JwtAuthenticationToken token = token();
	return Long.valueOf(token.getName());
    }

    private static JwtAuthenticationToken token() {

	JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
	return token;

    }

}
