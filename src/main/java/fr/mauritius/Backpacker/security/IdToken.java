package fr.mauritius.Backpacker.security;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
// forcer le snake case sur une classe
// encapsuler le token
public class IdToken {// Token Oauth2

    // jwt
    // généré dynamiquement
    // access_token
    private final String accessToken;

    // type de jeton ; bearer == titulaire /porteur
    // celui qui est authentifié

    // token_Type
    private final String tokenType = "Bearer";

    // expires_In (donnée recommandé, pas obligatoire
    private final Long expiresIn;

    // private final Long expiresIn = 3600
    // ici 1 heure pour tester en dure ou dans un fichier property

    // pas de sens d'avoir un id à zéro et
    IdToken(String accessToken, Long expiresIn) {

	this.accessToken = accessToken;
	this.expiresIn = expiresIn;

    }
// une fois généré pas besoin d'être modifiée
// plus besoin de faire évoluer   
    // donc pas de setters

    public String getAccessToken() {
	return accessToken;
    }

    public String getTokenType() {
	return tokenType;
    }

    public Long getExpiresIn() {
	return expiresIn;
    }

    @Override
    public String toString() {
	// PROTECTED = isn't printed for security reason
	return "IdToken [accessToken=PROTECTED, tokenType=" + tokenType + ", expiresIn=" + expiresIn + "]";
    }

}
