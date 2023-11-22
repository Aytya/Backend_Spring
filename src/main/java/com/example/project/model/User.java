package com.example.project.model;

import com.example.project.token.Token;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.project.model.Role;

import java.util.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    @Lob
    @Column(name = "imagedata",length = 1000)
    @Nullable
    private byte[] imageData;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Nullable
    public String department;
    @Nullable
    public String program;
    @Nullable
    public String yearOfSubmission;
    @Nullable
    public String dateOfBirth;
    @Column(unique = true)
    public String idNo;
    @Column(length = 1000)
    @Nullable
    public String permanentAddress;
    @Column(length = 1000)
    @Nullable
    public String maillingAddress;
    @Nullable
    public String phone;
    @Nullable
    public String nationality;
    @Nullable
    public Date date;


    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
////        return List.of(new SimpleGrantedAuthority(role.name()));
////    }
    @OneToMany(mappedBy = "user")
    private List<Token> token;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Professor professor;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
