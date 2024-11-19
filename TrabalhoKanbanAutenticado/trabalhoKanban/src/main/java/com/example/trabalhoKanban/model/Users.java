package com.example.trabalhoKanban.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "O nome de usuario é obrigatório")
    private String login;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotBlank(message = "O tipo de usuario é obrigatório")
    private UsersRole role;

    public Users( String login, String senha, UsersRole role) {
        this.login = login;
        this.password = senha;
        this.role = role;
    }

    public Users() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome de usuario é obrigatório") String getLogin() {
        return login;
    }

    public void setLogin(@NotBlank(message = "O nome de usuario é obrigatório") String nomeUsuario) {
        this.login = nomeUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UsersRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public @NotBlank(message = "A senha é obrigatória") String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setPassword(@NotBlank(message = "A senha é obrigatória") String senha) {
        this.password = senha;
    }

    public @NotBlank(message = "O tipo de usuario é obrigatório") UsersRole getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "O tipo de usuario é obrigatório") String role) {
        this.role = UsersRole.valueOf(role);
    }
}
