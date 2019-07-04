package br.com.guedesdesouza.myapp.core.security.jwt.web;

/**
 * Created by rodrigo.souza on 31/08/2016.
 */
public class JwtAuthenticationRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
