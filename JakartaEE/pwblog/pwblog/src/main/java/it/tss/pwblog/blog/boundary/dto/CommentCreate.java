/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pwblog.blog.boundary.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * contiene solo i dati che voglio avere da json
 * @author Paolo
 */
public class CommentCreate {
    
    @NotEmpty
    public String text;
    @NotNull
    public int rating;

}
