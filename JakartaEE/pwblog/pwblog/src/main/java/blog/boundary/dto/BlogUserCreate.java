/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.boundary.dto;

import blog.entity.BlogUser.Role;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty
    public String pwd;
    @NotEmpty
    public Role role;
    @NotEmpty
    public boolean banned;
}
