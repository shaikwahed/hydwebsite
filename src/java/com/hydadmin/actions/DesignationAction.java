/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hydadmin.actions;

import com.hydadmin.dao.MastersDAO;
import com.hydadmin.pojos.Designation;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shaik Wahed
 */
public class DesignationAction {

    private String designationame;
    private List<Designation> designationlist = new ArrayList<Designation>();
    
    public String getDesignationame() {
        return designationame;
    }

    public void setDesignationame(String designationame) {
        this.designationame = designationame;
    }

    public List<Designation> getDesignationlist() {
        return designationlist;
    }

    public void setDesignationlist(List<Designation> designationlist) {
        this.designationlist = designationlist;
    }
    
    MastersDAO mdao = new MastersDAO();

    public String getAllDesignations() {
        designationlist=mdao.getAllDesignations();
        return SUCCESS;
    }
    public String toDesignation() {
        return SUCCESS;
    }

    public String addDesignation() {
        Designation designation = new Designation();
        designation.setDesignationame(designationame);
        mdao.addDesignation(designation);
        getAllDesignations();
        return SUCCESS;
    }

}
