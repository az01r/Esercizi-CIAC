/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary;

import it.tss.pwblog.blog.boundary.dto.CommentCreate;
import it.tss.pwblog.blog.control.CommentStore;
import it.tss.pwblog.blog.entity.Comment;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Paolo
 */
@RolesAllowed({"ADMIN", "USER"})
public class CommentResource {
    
    @Inject
    private CommentStore store;
    
    Long commentId;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Comment find() {
        Comment comment = store.searchSingleComment(commentId).orElseThrow(() -> new NotFoundException());
        return comment;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete() {
        Comment comment = store.searchSingleComment(commentId).orElseThrow(() -> new NotFoundException());
        comment.setDeleted(true);
        return Response.status(Response.Status.ACCEPTED).build();
    }
    
    @POST
    @Path("{accountId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response answerTo(@PathParam("accountId") Long upperCommentId, @Valid CommentCreate c) {
        Comment created = store.create(new Comment(c));
        created.setAnswersTo(upperCommentId);
        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    
    /*
    get/set
    */
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    
    
}
