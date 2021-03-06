/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary;

import it.tss.pwblog.blog.boundary.dto.ArticleCreate;
import it.tss.pwblog.blog.control.ArticleStore;
import it.tss.pwblog.blog.entity.Article;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 *
 * @author Paolo
 */
@DenyAll
@Path("/articles")
public class ArticlesResource {

    @Inject
    @Claim(standard = Claims.sub)
    Long userId;
    
    @Context
    private ResourceContext resource; // usato per passare al singolo articolo
    
    @Inject
    ArticleStore store;

    @Context
    private UriInfo uriInfo;

    @PostConstruct
    public void init() {
        System.out.println(uriInfo.getPath());
        System.out.println(uriInfo.getBaseUri());
        System.out.println(uriInfo.getAbsolutePath());
    }

    @RolesAllowed({"ADMIN", "USER"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> searchAllArticles() {
        return store.findAllArticles().orElseThrow(() -> new NotFoundException());
    }
    
    @RolesAllowed({"ADMIN"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createArticle(@Valid ArticleCreate a) {
        Article created = store.createArt(new Article(a,userId));
        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }
    
    @RolesAllowed({"ADMIN", "USER"})
    @Path("{articleId}")
    public ArticleResource search(@PathParam("articleId") Long id) {
        ArticleResource sub = resource.getResource(ArticleResource.class);
        sub.setArticleId(id);
        return sub;
    }
}
