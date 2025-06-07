package org.unl.pacas.base.dao.dao_models;

import org.unl.pacas.base.controller.dao.AdapterDao;
import org.unl.pacas.base.models.DetalleFactura;

public class DetalleFacturaDao extends AdapterDao <DetalleFactura>{
    private DetalleFactura obj;

    public DetalleFacturaDao(){
        super(DetalleFactura.class);
    }

    public DetalleFactura getObj() {
        if (obj == null)
            this.obj = new DetalleFactura();
        return this.obj;
    }

    public void setObj(DetalleFactura obj) {
        this.obj = obj;
    }

    public Boolean save(){
        try{
            obj.setId(listAll().getLength()+1);
            this.persist(obj);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Boolean update(Integer pos){
        try {
        this.update(obj, pos);
        return true;
        }catch(Exception e){
            return false;
        }
    }
}
