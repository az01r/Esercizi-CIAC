/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary;

import it.tss.pwblog.blog.boundary.dto.CommentCreate;
import it.tss.pwblog.blog.control.BlogUserStore;
import it.tss.pwblog.blog.control.CommentStore;
import it.tss.pwblog.blog.entity.BlogUser;
import it.tss.pwblog.blog.entity.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;


/**
 *
 * @author Paolo
 */

public class CommentResource {
    
    @Inject
    private CommentStore store;
    
    @Inject
    private BlogUserStore userStore;
    
    Long commentId;
    
    @Inject
    @Claim(standard = Claims.sub)
    Long userId;
    
    @Context
    SecurityContext securityCtx;
    
    @Inject
    JsonWebToken jwt;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> searchComment() {
        Comment comment = store.findCommentById(commentId).orElseThrow(() -> new NotFoundException());
        List<Comment> responses = new ArrayList<>();
        responses.add(comment);
        store.findResponsesToComment(commentId).get().stream().forEach(v -> responses.add(v));
        return responses;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAnswerComment(@Valid CommentCreate c) {
        Comment comment = store.findCommentById(commentId).orElseThrow(() -> new NotFoundException());  
        Comment created = new Comment(c, userId, comment.getArticleId());
        created.setAnswersTo(commentId);
        created = store.createComm(created);
        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteComment() {
        Comment comment = store.findCommentById(commentId).orElseThrow(() -> new NotFoundException());  
        BlogUser user = userStore.findUserById(userId).orElseThrow(() -> new NotFoundException());
        boolean isUserRole = securityCtx.isUserInRole(BlogUser.Role.USER.name()); // ritorna vero se il ruolo contenuto nel token è USER
        if (isUserRole && (jwt == null || jwt.getSubject() == null || Long.parseLong(jwt.getSubject()) != comment.getCreatedById())) {
            throw new ForbiddenException(Response.status(Response.Status.FORBIDDEN).entity("Access forbidden: role not allowed").build());
        }  
        store.deleteComm(commentId);
        return Response.status(Response.Status.ACCEPTED).build();
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

