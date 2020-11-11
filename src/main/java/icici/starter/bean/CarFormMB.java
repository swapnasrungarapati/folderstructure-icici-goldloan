/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package icici.starter.bean;

import com.github.adminfaces.persistence.bean.BeanService;
import com.github.adminfaces.persistence.bean.CrudMB;
import icici.starter.model.Car;
import icici.starter.service.CarService;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;

/**
 * @author rmpestano
 */
@Named
@ViewScoped
@BeanService(CarService.class)//use annotation instead of setter
public class CarFormMB extends CrudMB<Car> implements Serializable {


    public void afterRemove() {
        try {
            addDetailMsg("Car " + entity.getModel()
                    + " removed successfully");
            Faces.redirect("car-list.xhtml");
            clear(); 
            sessionFilter.clear(CarListMB.class.getName());//removes filter saved in session for CarListMB.
        } catch (Exception e) {
            log.log(Level.WARNING, "", e);
        }
    }

    @Override
    public void afterInsert() {
         addDetailMsg("Car " + entity.getModel() + " created successfully");
    }

    @Override
    public void afterUpdate() {
        addDetailMsg("Car " + entity.getModel() + " updated successfully");
    }
    

}
