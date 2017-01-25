/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.Product;
import domainmodel.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 693663
 */
public class ProductRepository {
    /**
     * 
     * @param product
     * @return
     * @throws HavenCyclesDBException 
     */
     public int insert(Product product) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
     /**
      * 
      * @param product
      * @return
      * @throws HavenCyclesDBException 
      */
    public int update(Product product) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(product);
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
    /**
     * 
     * @param product
     * @return
     * @throws HavenCyclesDBException 
     */
    public int delete(Product product) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(product));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }    
    }
    /**
     * 
     * @param productId
     * @return
     * @throws HavenCyclesDBException 
     */
    public Product getProduct(int productId) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Product product;
            product = em.find(Product.class, productId);
            return product;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
}
