package br.com.guedesdesouza.myapp.core.security.jwt.service;

import br.com.guedesdesouza.myapp.core.security.jwt.model.JwtUserFactory;
import br.com.guedesdesouza.myapp.core.security.model.User;
import br.com.guedesdesouza.myapp.core.security.repository.UserRepository;
import br.com.guedesdesouza.myapp.core.security.jwt.model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by rodrigo on 02/09/16.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
