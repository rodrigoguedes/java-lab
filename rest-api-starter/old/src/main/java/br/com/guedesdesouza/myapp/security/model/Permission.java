package br.com.guedesdesouza.myapp.security.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by rodrigo.souza on 26/08/2016.
 */
public enum Permission implements GrantedAuthority {

    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

}
