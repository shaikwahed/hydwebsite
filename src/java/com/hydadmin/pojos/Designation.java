/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hydadmin.pojos;

/**
 *
 * @author Mirza
 */
public class Designation {
    private String _id;
    private String designationame;

    public Designation() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
    
    public String getDesignationame() {
        return designationame;
    }

    public void setDesignationame(String designationame) {
        this.designationame = designationame;
    }
    
}
