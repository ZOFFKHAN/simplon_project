package fr.mauritius.Backpacker.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OverlappingException extends RuntimeException {
    // pbs de user ou pwd
//RuntimeException java lang dans toutes les classes

    public OverlappingException(String message) {
	super(message);
    }
}
