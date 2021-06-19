package fr.mauritius.Backpacker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CkbookingIntrouvableException extends RuntimeException {

    public CkbookingIntrouvableException(String s) {
	super(s);
    }

}
