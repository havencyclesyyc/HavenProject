/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import domainmodel.PurchaseOrder;
import java.util.ArrayList;

/**
 *
 * @author Andrew Crayden
 */
public class PurchaseOrderService {
    
    public boolean cancelOrder() {
        return true;
    }
    
    public boolean completePurchase() {
        return true;
    }
    
    public ArrayList<PurchaseOrder> getAll() {
        return new ArrayList<PurchaseOrder>();
    } 
    
    public PurchaseOrder getPurchaseOrder(int purchaseOrderId) {
        return new PurchaseOrder();
    }
    
    public boolean insertPurchaseOrder(PurchaseOrder obj) {
        return true;
    }
    
    public boolean deletePurchaseOrder(PurchaseOrder obj) {
        return true;
    }
    
    public boolean updatePurchaseOrder(PurchaseOrder obj) {
        return true;
    }
    
}
