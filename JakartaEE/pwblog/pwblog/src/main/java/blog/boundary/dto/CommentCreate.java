/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.boundary.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;


/**
 *
 * @author Paolo
 */
public class CommentCreate {
    
    @NotEmpty
    public String text;
    @NotEmpty
    public Long articleId;
    @NotEmpty
    public Long userId;
    @NotEmpty
    public int rating;
    @NotEmpty
    public LocalDateTime date;
    @NotEmpty
    public Long answersTo;
}
