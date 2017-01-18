/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import domainmodel.RepairOrder;
import java.util.ArrayList;

/**
 *
 * @author Andrew Crayden
 */
public class RentalOrderService {
    
    public boolean completeRequest() {
        return true;
    }
    
    public boolean cancelRepairOrder(int repairOrderId) {
        return true;
    }
    
    public ArrayList<RepairOrder> getAll() {
        return new ArrayList<RepairOrder>();
    }
    
    public RepairOrder get(int repairOrderId) {
        return new RepairOrder();
    }
    
    public boolean insertRepairOrder(RepairOrder obj) {
        return true;
    }
    
    public boolean deleteRepairOrder(RepairOrder obj) {
        return true;
    }
    
    public boolean updateRepairOrder(RepairOrder obj) {
        return true;
    }
    
}
