/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import domainmodel.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 545410
 */
public class UserService {
    
    public boolean forgotPassword(String email) {
        return true;
    }
    
    public boolean resetPassword(String UUID,String password) {
        return true;
    }
    
    public boolean activateAccount(String UUID) {
        return true;
    }
    
    public boolean register(User user) {
        return true;
    }
    
    public boolean login(String email, String password) {
        return true;
    }
    
    public ArrayList<User> getAllUsers() {
        return new ArrayList<User>();
    }
    
    public User getUser(int userid) {
        return new User();
    }
    
    public User getUser(String email) {
        return new User();
    }
    
    public boolean isAdmin(int userid) {
        return true;
    }
    
    public boolean addNewUser(User obj) {
        return true;
    }
    
    public boolean updateUser(User obj) {
        return true;
    }
    
    public boolean deleteUser(User obj) {
        return true;
    }
    
    public boolean getRole(int userId) {
        return true;
    }
}
