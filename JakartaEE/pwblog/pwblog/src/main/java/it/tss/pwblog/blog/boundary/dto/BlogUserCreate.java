/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary.dto;

import it.tss.pwblog.blog.boundary.adapters.RoleTypeAdapter;
import it.tss.pwblog.blog.entity.BlogUser;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Paolo
 */
public class BlogUserCreate {

    @NotEmpty
    public String fname;
    @NotEmpty
    public String lname;
    @NotEmpty
    public String email;
    @NotEmpty // solo su stringhe
    public String pwd;
    @NotNull // anche sugli altri
    @JsonbTypeAdapter(RoleTypeAdapter.class)
    public BlogUser.Role role;
}
