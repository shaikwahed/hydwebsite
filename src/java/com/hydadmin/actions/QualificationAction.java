/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hydadmin.actions;

import com.hydadmin.dao.MastersDAO;
import com.hydadmin.pojos.Qualification;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shaik Wahed
 */
public class QualificationAction {

    private String qualificationname;
    private List<Qualification> qualificationlist = new ArrayList<Qualification>();

    public String getQualificationname() {
        return qualificationname;
    }

    public void setQualificationname(String qualificationname) {
        this.qualificationname = qualificationname;
    }

    public List<Qualification> getQualificationlist() {
        return qualificationlist;
    }

    public void setQualificationlist(List<Qualification> qualificationlist) {
        this.qualificationlist = qualificationlist;
    }

    MastersDAO mdao = new MastersDAO();

    public String getAllQualifications() {
        qualificationlist = mdao.getAllQualifications();
        return SUCCESS;
    }

    public String toQualification() {
        return SUCCESS;
    }

    public String addQualification() {
        Qualification qualification = new Qualification();
        qualification.setQualificationname(qualificationname);
        mdao.addQualification(qualification);
        getAllQualifications();
        return SUCCESS;
    }
}
