package fr.mauritius.Backpacker.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenProvider {

    private final Algorithm algorithm;

    private final ZoneId zoneId;

    private final String issuer;

    private final Long expiration;

    // pas public , visibility package
//    TokenProvider(Algorithm algorithm, ZoneId zoneId, String issuer, Long expiration) {
//
//	this.algorithm = algorithm;
//	this.zoneId = zoneId;
//	this.issuer = issuer;
//	this.expiration = expiration;
//    }
    TokenProvider(Algorithm algorithm, String timeZone, String issuer, long expiration) {
	this.algorithm = algorithm;
	zoneId = ZoneId.of(timeZone);
	this.issuer = issuer;
	this.expiration = expiration;
    }

    public IdToken idToken(Long accountId, String subject, List<String> authorities) {

	LocalDateTime now = LocalDateTime.now(zoneId);
	Date issuedAt = toJavaUtilDate(now);
	LocalDateTime expires = now.plusSeconds(expiration);
	Date expiresAt = toJavaUtilDate(expires);
	// suject pour qui ?
	// username dans le service , lors de l'authentification
	// bon compte , password

	// le role == ici authorities (authorisations de roles)
	// une liste est attendue même si on n'a qu'un rôle
// voir class Idtoken
	// @formatter:off
	// gestion signature
	// creation du token
	String accessToken = JWT.create()
		.withIssuer(issuer) //qui a généré
		.withIssuedAt(issuedAt) // génération
		.withExpiresAt(expiresAt)// expiration
		.withSubject(subject)// pour qui
		//.withClaim("roles", authorities)
		.withClaim("accountId", accountId)
		.withClaim("authorities", authorities) // pas obligatoire
		.sign(algorithm);
	// @formatter:on
	return new IdToken(accessToken, expiration);
    }

    // java 8 en java 1.1 pour convertir la date
    private Date toJavaUtilDate(LocalDateTime now) {
	return Date.from(now.atZone(zoneId).toInstant());
    }

}
