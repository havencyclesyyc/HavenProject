/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.AccountService;
import businesslogic.UserService;
import dataaccess.HavenCyclesDBException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 545410
 */
public class LoginServlet extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String logout = request.getParameter("logout");
        if (logout != null) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            String newUsernameInput  = request.getParameter("new-username-input");
            String newPasswordInput  = request.getParameter("new-password-input");
            String newEmailInput  = request.getParameter("new-email-input");
            String newFirstNameInput  = request.getParameter("new-first-name-input");
            String newLastNameInput  = request.getParameter("new-last-name-input");
            String newPhoneNumber  = request.getParameter("new-phone-number-input");
            String newGenderInput  = request.getParameter("new-gender-input");
            
            AccountService as = new AccountService();
            String action = request.getParameter("action");
            if (action == null)
                action = "";
            
            switch (action) {
            case "login":
                if (as.login(request, username, password)) {
                    if(as.getRole(request)){
                        response.sendRedirect("users");
                    } else {
                        response.sendRedirect("home");
                    }
                } else {
                    request.setAttribute("message", "invalid login");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                }
                
                break;
            
            case "register":
                try {
                    us.insert(newUsernameInput, newPasswordInput, newEmailInput, newFirstNameInput, newLastNameInput, newPhoneNumber, newGenderInput);
                } catch (HavenCyclesDBException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                break;
            }
    }

}
