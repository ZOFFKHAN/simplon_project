package fr.mauritius.Backpacker.security;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration
//annotation de sécurity, pour les endpoints
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${my-app.jwt.provider.time-zone-id}")
    private String timeZoneId;

    @Value("${my-app.jwt.provider.issuer}")
    private String issuer;

    @Value("${my-app.jwt.provider.access-token.expiration}")
    private long expiration;

    @Value("${my-app.jwt.keystore.filename}")
    private String keyStore;

    @Value("${my-app.jwt.keystore.password}")
    private String password;

    @Value("${my-app.jwt.keystore.alias}")
    private String alias;

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	// Disable unused default configuration:

	http.csrf().disable().httpBasic().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

		// je ne veux pas de session
		// Apply business requirements:
		.and().authorizeRequests()
		// Authorize any user to access these endpoints:
		.antMatchers(HttpMethod.POST, "/accounts", "/accounts/login").permitAll()
		// Authorize anonymous only to access this endpoint:
		// .antMatchers(HttpMethod.GET, "/tests/**").anonymous()
		.antMatchers(HttpMethod.GET, "/tests/anonymous-only").anonymous() // Not authenticated
		// Unauthorize any other endpoint (request):
//ROLE_ADMIN ,ROLE_BASIC
		// ci dessous configure serveur de ressourses
		// .antMatchers(HttpMethod.GET, "/tests/Auth_user").hasAnyRole("BASIC", "ADMIN",
		// "MANAGER")
		.antMatchers(HttpMethod.GET, "/tests/manager-admin").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/tests/basic-admin").hasAnyRole("BASIC", "ADMIN")
		.antMatchers(HttpMethod.GET, "/tests/manager-only").hasRole("MANAGER")
		.antMatchers(HttpMethod.GET, "/tests/basic-only").hasRole("BASIC")// Not authenticated
		// .antMatchers(HttpMethod.GET, "/tests/admin-only").hasRole("ADMIN")// Not
		// authenticated
		// .antMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")// Not
		// authenticated

		.antMatchers(HttpMethod.GET, "/tests/Auth_user").fullyAuthenticated().anyRequest().fullyAuthenticated()
		// Resource server ci dessous
		.and().oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtConverter());
    }

    @Bean
    protected TokenProvider tokenProvider() {
	KeyPair pair = constructKeyPair();
	RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
	RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic();
	Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
	return new TokenProvider(algorithm, timeZoneId, issuer, expiration);
    }

    // paire cles public/private
    private KeyPair constructKeyPair() {
	Resource resource = new ClassPathResource(keyStore);
	char[] password = this.password.toCharArray();
	try (InputStream in = resource.getInputStream()) {
	    KeyStore store = KeyStore.getInstance("jks");
	    store.load(in, password);
	    RSAPrivateCrtKey key = (RSAPrivateCrtKey) store.getKey(alias, password);
	    RSAPublicKeySpec spec = new RSAPublicKeySpec(key.getModulus(), key.getPublicExponent());
	    PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(spec);
	    return new KeyPair(publicKey, key);
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}
    }

    private Converter<Jwt, JwtAuthenticationToken> jwtConverter() {
	// classe anonyme ici Converter
	// pas besoin d'implémenter l'interface
	// visible que dans la classe elle même
	// permet de récuperer les roles,...
	return new Converter<>() {

	    @Override
	    public JwtAuthenticationToken convert(Jwt jwt) {
		Collection<GrantedAuthority> authorities = extractAuthorities(jwt);
		String name = jwt.getClaim("sub");
		// name ici correspond nom du token
		return new JwtAuthenticationToken(jwt, authorities, name);
	    }

	    // ressource server
	    private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
		// pas d'arraylist ici contre hashset (éléments uniques)
		Collection<GrantedAuthority> authorities = new HashSet<>();
		List<String> codes = jwt.getClaimAsStringList("authorities");

		// permet de générer plusieurs roles ;-)
		if (null != codes && !codes.isEmpty()) {
		    for (String code : codes) {
			authorities.add(new SimpleGrantedAuthority(code));
		    }
		}
		return authorities;
	    }
	};
    }
}