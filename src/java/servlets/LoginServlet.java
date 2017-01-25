/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import businesslogic.UserService;
import dataaccess.HavenCyclesDBException;
import domainmodel.Address;
import domainmodel.Role;
import domainmodel.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        request.setAttribute("role", "anonymous");
        
        if (session.getAttribute("user") == null && action == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            return;
        }
        
        if(action != null && action.equals("login")) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        if (action != null && action.equals("logout")) {
            session.invalidate();
            request.setAttribute("role", "anonymous");
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            return;
        }
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
        
        String action = request.getParameter("action");        
        UserService userService = new UserService();
        int userId;

        switch(action) {
            case "login":
                String email = request.getParameter("email-input");
                String password = request.getParameter("password-input");
                if(userService.login(email, password)) {
                    HttpSession session = request.getSession(true);
                    User user = userService.getUser("email-input");
                    userId = user.getUserId();
                    request.setAttribute("role", userService.getRole(userId).getRoleName());
                    response.sendRedirect("profile");
                    
                    return;
                } else {
                    request.setAttribute("helpText", "Either the username or password you have entered in incorrect.");
                    request.setAttribute("correct", "false");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);  
                }
                break;
            case "register":
                User user = new User();
                
                String firstNameInput = request.getParameter("first-name-input");
                String lastNameInput = request.getParameter("last-name-input");
                String emailInput = request.getParameter("email-input");
                String passwordInput = request.getParameter("password-input");
                String phoneNumberInput = request.getParameter("phone-number-input");
                String zipCodeInput = request.getParameter("zip-code-input");
                String streetAddressInput = request.getParameter("street-address-input");
                String cityInput = request.getParameter("city-input");
                String stateInput = request.getParameter("state-input");
                String countryInput = request.getParameter("country-input");
                
                ArrayList<Address> addressList = new ArrayList<Address>();
                Address address = new Address();
                address.setCity(cityInput);
                address.setCountry(countryInput);
                address.setState(stateInput);
                address.setStreetAddress(streetAddressInput);
                address.setZipCode(zipCodeInput);
                addressList.add(address);
                
                // user.setPhoneNumber(phoneNumberInput);
                user.setEmail(emailInput);
                user.setPassword(passwordInput);
                user.setFirstName(firstNameInput);
                user.setLastName(lastNameInput);
                user.setAddressList(addressList);
                
                request.setAttribute("helpText", "You have now been registered, and can now login with your new account.");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                break;
        }
        
    }

}
