package com.ttn.attrsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.Set;

/**
 * @author Chandra Shekhar Paatni on 29/5/19
 */
@Entity
public class User extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String userName, String password, String confirmPassword, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
