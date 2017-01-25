/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import dataaccess.HavenCyclesDBException;
import dataaccess.UserRepository;
import domainmodel.Role;
import domainmodel.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 545410
 */
public class UserService {
    
    UserRepository ur = new UserRepository();
    /**
     * 
     * @param email
     * @param request
     * @return 
     */
    public boolean forgotPassword(String email, HttpServletRequest request) {
        try {
            User user = ur.getUser(email);
            if(user == null){
                return false;
            }
            String uuid = UUID.randomUUID().toString();
            String template = request.getServletContext().getRealPath("/WEB-INF/emailtemplates/reset.html");
            String link = request.getRequestURL().toString() + "?uuid=" + uuid; ;
            HashMap<String, String> contents = new HashMap<>();      
            contents.put("firstname", user.getFirstName());
            contents.put("lastname", user.getLastName());
            contents.put("email", user.getEmail());
            contents.put("link", link);                              
                user.setPasswordUUID(uuid);
                ur.update(user);
                WebMailService.sendMail(user.getEmail(),"NotesKeepr Password Reset", template, contents);
                return true; 
        } catch (Exception ex) {
        }
        return false;
    }
    /**
     * 
     * @param UUID
     * @param password
     * @return 
     */
    public boolean resetPassword(String UUID,String password) {
        boolean result = false;
        if (UUID != null && !UUID.isEmpty() && !UUID.trim().equals("")){
            User user = ur.getByPasswordUUID(UUID);
            if(user != null){
                user.setPasswordUUID(null);
                user.setPassword(password);
                try {
                    ur.update(user);
                    result = true;
                } catch (Exception ex){
                }
            }
        }
        return result;
    }
    /**
     * Method to activate account through the RegisterUUID.
     * @param UUID
     * @return 
     */
    public boolean activateAccount(String UUID) {
        boolean result = false;
        if (UUID != null && !UUID.isEmpty() && !UUID.trim().equals("")){
            User user = ur.getByRegisterUUID(UUID);
            if(user != null){
                user.setRegisterUUID(null);
                try {
                    ur.update(user);
                    result = true;
                } catch (Exception ex){
                }
            }
        }
        return result;
    }
    /**
     * 
     * @param user
     * @param request
     * @return 
     */
    public boolean register(User user, HttpServletRequest request) {
        try {
            addNewUser(user);
            User userNew = ur.getUser(user.getEmail());
            if(userNew == null){
                return false;
            }
            String uuid = UUID.randomUUID().toString();
            String template = request.getServletContext().getRealPath("/WEB-INF/emailtemplates/register.html");
            String link = request.getRequestURL().toString() + "?uuid=" + uuid; ;
            HashMap<String, String> contents = new HashMap<>();      
            contents.put("firstname", userNew.getFirstName());
            contents.put("lastname", userNew.getLastName());
            contents.put("email", userNew.getEmail());
            contents.put("link", link);                              
            user.setRegisterUUID(uuid);
            ur.update(user);
            WebMailService.sendMail(user.getEmail(),"HavenCycles Activations", template, contents);
            return true; 
        } catch (Exception ex) {
        }
        return false;
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public boolean login(String email, String password) {
        boolean result = false;
        try {
            User user = null;
            user = ur.getUser(email);
            if(user != null){
                if(email.equals(user.getEmail()) && password.equals(user.getPassword()))
                {
                    result = true;
                }
            }
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return result;
    }
    /**
     * 
     * @return 
     */
    public ArrayList<User> getAllUsers() {
        try {
            return (ArrayList<User>) ur.getAll();
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return null;
    }
    /**
     * 
     * @param userid
     * @return 
     */
    public User getUser(int userid) {
        User user = null;
        try {
            user = ur.getUser(userid);
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return user;
    }
    /**
     * 
     * @param email
     * @return 
     */
    public User getUser(String email) {
        User user = null;
        try {
            user = ur.getUser(email);
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return user;
    }
    /**
     * 
     * @param userId
     * @return 
     */
    public boolean isAdmin(int userId) {
        boolean result = false;
        try {
            User user = ur.getUser(userId);
            return user.getRoleId().getRoleName().equals(Roles.admin.name());
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return result;
    }
    /**
     * 
     * @param userId
     * @return 
     */
    public boolean isEmployee(int userId) {
        boolean result = false;
        try {
            User user = ur.getUser(userId);
            return user.getRoleId().getRoleName().equals(Roles.employee.name());
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return result;
    }
    /**
     * 
     * @param user
     * @return 
     */
    public boolean addNewUser(User user) {
        boolean result = false;
        try {
            ur.insert(user);
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return result;
    }
    /**
     * 
     * @param user
     * @return 
     */
    public boolean updateUser(User user) {
        boolean result = false;
        try {
            ur.update(user);
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return result;
    }
    /**
     * 
     * @param user
     * @return 
     */
    public boolean deleteUser(User user) {
        boolean result = false;
        try {
            ur.delete(user);
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return result;
    }
    /**
     * 
     * @param userId
     * @return 
     */
    public Role getRole(int userId) {
        Role result = null;
        try {
            User user = ur.getUser(userId);
            return user.getRoleId();
        } catch (HavenCyclesDBException ex) {
            //TODO add error handling or log 
        }
        return result;
    }
}
