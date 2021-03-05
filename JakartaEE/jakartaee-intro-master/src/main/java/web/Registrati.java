/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utenti.Utente;
import utenti.UtenteStore;

/**
 *
 * @author alfonso
 */
@WebServlet(urlPatterns = "/registrati")
public class Registrati extends HttpServlet {
    
    @Inject
    UtenteStore store;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        System.out.println(String.format("nome: %s , cognome: %s", nome,cognome));
        
        store.add(new Utente(nome, cognome));
        
        PrintWriter out = resp.getWriter();
        out.println("<h1>Registrazione effettuata. Grazie!!!</h1>");
        out.flush();
        
    }
    
 
}
