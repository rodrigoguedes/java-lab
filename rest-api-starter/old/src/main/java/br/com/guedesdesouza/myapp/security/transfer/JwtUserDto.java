package br.com.guedesdesouza.myapp.security.transfer;

/**
 * Simple placeholder for info extracted from the JWT
 *
 * Created by rodrigo on 24/08/16.
 */
public class JwtUserDto {

    private Long id;

    private String username;

    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
