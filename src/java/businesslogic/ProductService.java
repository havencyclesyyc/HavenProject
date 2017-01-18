/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import domainmodel.Product;
import java.util.ArrayList;

/**
 *
 * @author Andrew Crayden
 */
public class ProductService {
    
    public ArrayList<Product> getAll() {
        return new ArrayList<Product>();
    }
    
    public Product get(int productid) {
        return new Product();
    }
    
    public boolean delete(Product obj) {
        return true;
    }
    
    public boolean update(Product obj)  {
        return true;
    }
    
    public boolean insert(Product obj) {
        return true;
    }
    
}
