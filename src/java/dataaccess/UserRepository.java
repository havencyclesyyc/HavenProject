/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 693663
 */
public class UserRepository {
    
    public int insert(User user) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }

    public int update(User user) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }

    public int delete(User user) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }    
    }

    public User getUser(String email) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User user;
            user = em.find(User.class, email);
            return user;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
    public User getUser(int userId) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            User user;
            user = em.find(User.class, userId);
            return user;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }

    public List<User> getAll() throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();       
        try {
            List<User> users;
            users = em.createNamedQuery("User.findAll", User.class).getResultList();
            return users;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
    public User getByPasswordUUID(String uuid){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();       
        try {
            List<User> users;
            users = em.createNamedQuery("User.findByPasswordUUID", User.class).setParameter("passwordUUID", uuid).getResultList();
            if(users.size() == 1){
                return users.get(0);
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }

    public User getByRegisterUUID(String uuid) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();       
        try {
            List<User> users;
            users = em.createNamedQuery("User.findByRegisterUUID", User.class).setParameter("registerUUID", uuid).getResultList();
            if(users.size() == 1){
                return users.get(0);
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        } finally {
            em.close();
        }
    }
}
