package br.com.guedesdesouza.myapp.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Thrown when token cannot be found in the request header
 *
 * Created by rodrigo on 24/08/16.
 */
public class JwtTokenMissingException extends AuthenticationException {

    public JwtTokenMissingException(String msg) {
        super(msg);
    }

}
