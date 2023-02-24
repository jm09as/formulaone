package com.bredex.formulaone.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class SecurityUser implements UserDetails, Serializable {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private String password;

    private final String username;

    private final Set<GrantedAuthority> authorities;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;


    private final Client client;

    public SecurityUser(Client client) {
        this.client = client;
        this.username = client.getUsername();
        this.password = client.getPassword();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.authorities = Set.of(new SimpleGrantedAuthority(client.getRoles()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonExpired;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityUser that = (SecurityUser) o;
        return accountNonExpired == that.accountNonExpired && accountNonLocked == that.accountNonLocked && credentialsNonExpired == that.credentialsNonExpired && enabled == that.enabled && Objects.equals(password, that.password) && Objects.equals(username, that.username) && Objects.equals(authorities, that.authorities) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username, authorities, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, client);
    }

    @Override
    public String toString() {
        return "SecurityUser{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", authorities=" + authorities +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                ", client=" + client +
                '}';
    }
}


