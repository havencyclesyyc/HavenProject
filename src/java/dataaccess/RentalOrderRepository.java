/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.RentalOrder;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 693663
 */
public class RentalOrderRepository {
    /**
     * 
     * @param rentalOrder
     * @return
     * @throws HavenCyclesDBException 
     */
    public int insert(RentalOrder rentalOrder) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(rentalOrder);
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
     * @param rentalOrder
     * @return
     * @throws HavenCyclesDBException 
     */
    public int update(RentalOrder rentalOrder) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(rentalOrder);
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
     * @param rentalOrder
     * @return
     * @throws HavenCyclesDBException 
     */
    public int delete(RentalOrder rentalOrder) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(rentalOrder));
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
     * @param rentalOrderId
     * @return
     * @throws HavenCyclesDBException 
     */
    public RentalOrder getRentalOrder(int rentalOrderId) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            RentalOrder rentalOrder;
            rentalOrder = em.find(RentalOrder.class, rentalOrderId);
            return rentalOrder;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
}
