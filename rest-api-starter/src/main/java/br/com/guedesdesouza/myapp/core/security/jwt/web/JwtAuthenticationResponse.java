package br.com.guedesdesouza.myapp.core.security.jwt.web;

import br.com.guedesdesouza.myapp.core.security.jwt.JwtTokenUtil;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by rodrigo.souza on 31/08/2016.
 */
public class JwtAuthenticationResponse {

    private String token;
    private LocalDateTime issued;
    private LocalDateTime expires;

    public JwtAuthenticationResponse(String token, LocalDateTime issued, LocalDateTime expires){
        this.token = token;
        this.issued = issued;
        this.expires = expires;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getIssued() {
        return issued;
    }

    public void setIssued(LocalDateTime issued) {
        this.issued = issued;
    }

    public LocalDateTime getExpires() {
        return expires;
    }

    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }

}
