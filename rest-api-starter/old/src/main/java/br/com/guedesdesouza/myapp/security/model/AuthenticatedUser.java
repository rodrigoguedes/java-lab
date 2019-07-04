package br.com.guedesdesouza.myapp.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Holds the info for a authenticated user (Principal)
 * Created by rodrigo on 24/08/16.
 */
@Entity
@Table(name = "sec_user")
public class AuthenticatedUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "usr_id")
    private final Long id;

    @Column(name = "usr_username")
    private final String username;

    @Version
    @Column(name = "use_version")
    Integer version;

    @Column(name = "usr_token")
    private final String token;

    @ManyToMany
    @JoinTable(name = "sec_user_role", joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private List<Role> roles = Lists.newLinkedList();

    public AuthenticatedUser(Long id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ImmutableSet.Builder<Permission> builder = ImmutableSet.builder();
        for (Role role : roles) {
            builder.addAll(role.getPermissions());
        }
        return builder.build();
    }

    @Override
    public String getPassword() {
        return null;
    }

}
