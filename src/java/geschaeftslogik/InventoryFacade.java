/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschaeftslogik;

import datenlogik.Inventory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kadim
 */
@Stateless
public class InventoryFacade extends AbstractFacade<Inventory> {

    @PersistenceContext(unitName = "INTWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventoryFacade() {
        super(Inventory.class);
    }
    
    // ### Veränderter Code ###
    
    public List<Inventory> inventoryByStation(Integer stationID){
        return em.createNamedQuery("Inventory.findByStationID")
                .setParameter("stationID", stationID)
                .getResultList();
    }
    
     public List<Inventory> inventoryByProduct(Integer productID){
        return em.createNamedQuery("Inventory.findByProductID")
                .setParameter("productID", productID)
                .getResultList();
    }
    
    // ########################

    
}
