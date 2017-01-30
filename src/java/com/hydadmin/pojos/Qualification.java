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
public class Qualification {
    private String _id;
    private String qualificationname;

    public Qualification() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
    
    public String getQualificationname() {
        return qualificationname;
    }

    public void setQualificationname(String qualificationname) {
        this.qualificationname = qualificationname;
    }
    
  
}
