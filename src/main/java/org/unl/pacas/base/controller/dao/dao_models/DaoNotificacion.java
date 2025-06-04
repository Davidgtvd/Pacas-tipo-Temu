package org.unl.pacas.base.controller.dao.dao_models;

import org.unl.pacas.base.controller.dao.AdapterDao;
import org.unl.pacas.base.models.Notificacion;

public class DaoNotificacion extends AdapterDao<Notificacion> {
    private Notificacion obj;

    public DaoNotificacion() {
        super(Notificacion.class);
    }

    public Notificacion getObj() {
        if (obj == null)
            this.obj = new Notificacion();
        return this.obj;
    }

    public void setObj(Notificacion obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            obj.setId(listAll().getLength()+1);
            this.persist(obj);
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }

    public Boolean update(Integer pos) {
        try {
            this.update(obj, pos);
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }
}
