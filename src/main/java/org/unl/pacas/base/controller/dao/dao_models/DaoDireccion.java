package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.controller.dao.AdapterDao;
import org.unl.pacas.base.models.Direccion;

public class DaoDireccion extends AdapterDao<Direccion> {
    private Direccion obj;

    public DaoDireccion() {
        super(Direccion.class);
        // TODO Auto-generated constructor stub
    }

    public Direccion getObj() {
        if (obj == null)
            this.obj = new Direccion();
        return this.obj;
    }

    public void setObj(Direccion obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            obj.setId(listAll().getLength()+1);
            this.persist(obj);
            return true;
        } catch (Exception e) {
            //TODO
            return false;
            // TODO: handle exception
        }
    }

    public Boolean update(Integer pos) {
        try {
            this.update(obj, pos);
            return true;
        } catch (Exception e) {
            //TODO
            return false;
            // TODO: handle exception
        }
    }
}
