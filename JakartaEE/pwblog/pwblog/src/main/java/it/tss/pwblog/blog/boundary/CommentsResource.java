/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary;

import it.tss.pwblog.blog.control.CommentStore;
import it.tss.pwblog.blog.entity.BlogUser;
import it.tss.pwblog.blog.entity.Comment;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author tss
 */
@DenyAll
@Path("/comments")
public class CommentsResource {

    @Context
    private ResourceContext resource; // usato per passare al singolo commento

    @Context
    private UriInfo uriInfo;

    @PostConstruct
    public void init() {
        System.out.println(uriInfo.getPath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getAbsolutePath());
    }

    @RolesAllowed({"ADMIN", "USER"})
    @Path("{commentId}")
    public CommentResource search(@PathParam("commentId") Long id) {
        CommentResource sub = resource.getResource(CommentResource.class);
        sub.setCommentId(id);
        return sub;
    }
}
