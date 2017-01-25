/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.CartProduct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 693663
 */
public class CartProductRepository {
    /**
     * 
     * @param cartProduct
     * @return
     * @throws HavenCyclesDBException 
     */
    public int insert(CartProduct cartProduct) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(cartProduct);
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
     * @param cartProduct
     * @return
     * @throws HavenCyclesDBException 
     */
    public int update(CartProduct cartProduct) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(cartProduct);
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
     * @param cartProduct
     * @return
     * @throws HavenCyclesDBException 
     */
    public int delete(CartProduct cartProduct) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(cartProduct));
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
     * @param cartProductId
     * @return
     * @throws HavenCyclesDBException 
     */
    public CartProduct getCartProduct(int cartProductId) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            CartProduct cartProduct;
            cartProduct = em.find(CartProduct.class, cartProductId);
            return cartProduct;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
}
