/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary;

import it.tss.pwblog.blog.boundary.dto.BlogUserUpdate;
import it.tss.pwblog.blog.control.BlogUserStore;
import it.tss.pwblog.blog.control.CommentStore;
import it.tss.pwblog.blog.entity.BlogUser;
import it.tss.pwblog.blog.entity.Comment;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Paolo
 */
@RolesAllowed({"ADMIN", "USER"})
public class BlogUserResource {

    @Inject
    private CommentStore commentStore;

    @Inject
    private BlogUserStore store;

    private Long userId;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BlogUser find() {
        BlogUser user = store.search(0, userId).orElseThrow(() -> new NotFoundException());
        return user;
    }

    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BlogUser update(BlogUserUpdate u) {
        BlogUser oldUser = store.search(0, userId).orElseThrow(() -> new NotFoundException());
        BlogUser newUser = store.update(oldUser, u);
        return newUser;
    }

    /**
     * NB è uguale al ban dell'admin
     * @return 
     */
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete() {
        BlogUser user = store.search(0,userId).orElseThrow(() -> new NotFoundException());
        store.ban(userId);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> comments() {
        return commentStore.searchByUser(0, 0, userId);
    }

    /*
    get/set
     */
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
