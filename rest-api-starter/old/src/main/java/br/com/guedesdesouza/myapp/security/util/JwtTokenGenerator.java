package br.com.guedesdesouza.myapp.security.util;

import br.com.guedesdesouza.myapp.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * convenience class to generate a token for testing your requests.
 * Make sure the used secret here matches the on in your application.yml_cop
 *
 * Created by rodrigo on 24/08/16.
 */
public class JwtTokenGenerator {

    private static final Long EXPIRES = 24 * 60 * 60 * 1000L; // 1 DIA

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public static String generateToken(JwtUserDto u, String secret) {

        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.put("userId", u.getId() + "");
        claims.put("role", u.getRole());

        final Date expiration = buildExpirationDate();

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(expiration)
                .compact();
    }

    public static Date buildExpirationDate() {
        Long expirationDate = System.currentTimeMillis() + EXPIRES;

        return new Date(expirationDate);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        JwtUserDto user = new JwtUserDto();
        user.setId(123L);
        user.setUsername("Pascal");
        user.setRole("admin");

        System.out.println("**************************************\n\n" + generateToken(user, "my-very-secret-key") + "\n\n**************************************");
    }

}
