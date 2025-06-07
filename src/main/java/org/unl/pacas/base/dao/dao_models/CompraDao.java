package org.unl.pacas.base.dao.dao_models;

import org.unl.pacas.base.controller.dao.AdapterDao;
import org.unl.pacas.base.models.Compra;

public class CompraDao extends AdapterDao <Compra> {
    private Compra obj;

    public CompraDao(){
        super(Compra.class);
    }

    public Compra getObj() {
        if (obj == null)
            this.obj = new Compra();
        return this.obj;
    }

    public void setObj(Compra obj) {
        this.obj = obj;
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
