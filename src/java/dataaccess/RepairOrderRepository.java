/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.RepairOrder;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 693663
 */
public class RepairOrderRepository {
    /**
     * 
     * @param repairOrder
     * @return
     * @throws HavenCyclesDBException 
     */
     public int insert(RepairOrder repairOrder) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(repairOrder);
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
      * @param repairOrder
      * @return
      * @throws HavenCyclesDBException 
      */
    public int update(RepairOrder repairOrder) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(repairOrder);
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
     * @param repairOrder
     * @return
     * @throws HavenCyclesDBException 
     */
    public int delete(RepairOrder repairOrder) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(repairOrder));
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
     * @param repairOrderId
     * @return
     * @throws HavenCyclesDBException 
     */
    public RepairOrder getRepairOrder(int repairOrderId) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            RepairOrder repairOrder;
            repairOrder = em.find(RepairOrder.class, repairOrderId);
            return repairOrder;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
}
