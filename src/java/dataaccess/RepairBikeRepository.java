/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import domainmodel.RepairBike;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author 693663
 */
public class RepairBikeRepository {
    /**
     * 
     * @param repairBike
     * @return
     * @throws HavenCyclesDBException 
     */
    public int insert(RepairBike repairBike) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(repairBike);
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
     * @param repairBike
     * @return
     * @throws HavenCyclesDBException 
     */
    public int update(RepairBike repairBike) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(repairBike);
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
     * @param repairBike
     * @return
     * @throws HavenCyclesDBException 
     */
    public int delete(RepairBike repairBike) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(repairBike));
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
     * @param repairBikeId
     * @return
     * @throws HavenCyclesDBException 
     */
    public RepairBike getRepairBike(int repairBikeId) throws HavenCyclesDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            RepairBike repairBike;
            repairBike = em.find(RepairBike.class, repairBikeId);
            return repairBike;
        } catch (Exception ex) {
            throw new HavenCyclesDBException();
        } finally {
            em.close();
        }
    }
}
