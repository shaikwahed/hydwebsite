/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hydadmin.actions;

import com.hydadmin.dao.MastersDAO;
import com.hydadmin.pojos.Opening;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shaik Wahed
 */
public class OpeningAction {

    private String jobcode;
    private String jobtitle;
    private String companyname;
    private String interviewtype;
    private String experience;
    private String location;
    private String statusstring;
    private List<Opening> openinglist = new ArrayList<Opening>();

    public List<Opening> getOpeninglist() {
        return openinglist;
    }

    public void setOpeninglist(List<Opening> openinglist) {
        this.openinglist = openinglist;
    }

    public String getJobcode() {
        return jobcode;
    }

    public void setJobcode(String jobcode) {
        this.jobcode = jobcode;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getInterviewtype() {
        return interviewtype;
    }

    public void setInterviewtype(String interviewtype) {
        this.interviewtype = interviewtype;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatusstring() {
        return statusstring;
    }

    public void setStatusstring(String statusstring) {
        this.statusstring = statusstring;
    }

    public String toaddOpening() {
        return SUCCESS;
    }

    MastersDAO mdao = new MastersDAO();

    public String addOpening() {
        Opening opening = new Opening();
        opening.setJobcode(jobcode);
        opening.setJobtitle(jobtitle);
        opening.setCompanyname(companyname);
        opening.setInterviewtype(interviewtype);
        opening.setExperience(experience);
        opening.setLocation(location);
        opening.setStatusname("Approved");
        mdao.addOpening(opening);
        getAllOpenings();
        return SUCCESS;
    }

    public String getAllOpenings() {
        openinglist= mdao.getAllOpenings();
        return SUCCESS;
    }
}
