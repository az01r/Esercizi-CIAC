/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.entity;

import blog.boundary.dto.BlogUserCreate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Paolo
 */
@Entity
@Table(name = "users")
public class BlogUser extends AbstractEntity{
    
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "user_sequence")
    protected Long id;
    
    @Column(nullable = false)
    private String fname;
    @Column(nullable = false)
    private String lname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pwd;
    public enum Role {
        ADMIN, USER
    }
    @Column(nullable = false)
    private Role role;
    @Column(nullable = false)
    private boolean banned;

    public BlogUser() {
    }

    public BlogUser(BlogUserCreate u) {
        this.fname = u.fname;
        this.lname = u.lname;
        this.email = u.email;
        this.pwd = u.pwd;
        this.role = u.role;
        this.banned = u.banned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BlogUser other = (BlogUser) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
