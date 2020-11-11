package icici.starter.bean;

import com.github.adminfaces.persistence.service.CrudService;
import com.github.adminfaces.persistence.service.Service;
import icici.starter.model.Car;
import icici.starter.model.Car_;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class Lists implements Serializable {

    @Inject
    @Service
    private CrudService<Car,Integer> crudService;



    @Produces
    @Named("models")
    public List<String> models() {
        return crudService.criteria()
                .select(String.class, crudService.attribute(Car_.model))
                .getResultList();
    }

}
