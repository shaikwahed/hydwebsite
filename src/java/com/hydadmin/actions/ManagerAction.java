/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hydadmin.actions;

import com.hydadmin.dao.MastersDAO;
import com.hydadmin.pojos.ActiveStatus;
import com.hydadmin.pojos.Candidate;
import com.hydadmin.pojos.Manager;
import com.hydadmin.pojos.Qualification;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Shaik Wahed
 */
public class ManagerAction extends ActionSupport implements SessionAware {

    private String firstname;
    private String lastname;
    private String mobileno;
    private String gender;
    private String emailid;
    private String dateofbirthstring;
    private String password;
    private String religion;
    private String qualificationstring;
    private String address;
    private String country;
    private String state;
    private String city;
    private String statusstring;
    private List<Manager> managerlist = new ArrayList<Manager>();
    private List<Qualification> qualificationlist = new ArrayList<Qualification>();
    private List<ActiveStatus> activestatuslist = new ArrayList<ActiveStatus>();
     private List<Candidate> unpaidcandidatelist = new ArrayList<Candidate>();
    private Map sessionmap;
    private Boolean displaymsg;
    private Boolean addstatus;

    public List<Candidate> getUnpaidcandidatelist() {
        return unpaidcandidatelist;
    }

    public void setUnpaidcandidatelist(List<Candidate> unpaidcandidatelist) {
        this.unpaidcandidatelist = unpaidcandidatelist;
    }
    
    public Boolean getAddstatus() {
        return addstatus;
    }
    
    public void setAddstatus(Boolean addstatus) {
        this.addstatus = addstatus;
    }
    
    
    public Boolean getDisplaymsg() {
        return displaymsg;
    }

    public void setDisplaymsg(Boolean displaymsg) {
        this.displaymsg = displaymsg;
    }

    public Map getSessionmap() {
        return sessionmap;
    }

    public void setSessionmap(Map sessionmap) {
        this.sessionmap = sessionmap;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionmap = map;
    }

    public List<ActiveStatus> getActivestatuslist() {
        return activestatuslist;
    }

    public void setActivestatuslist(List<ActiveStatus> activestatuslist) {
        this.activestatuslist = activestatuslist;
    }

    public List<Qualification> getQualificationlist() {
        return qualificationlist;
    }

    public void setQualificationlist(List<Qualification> qualificationlist) {
        this.qualificationlist = qualificationlist;
    }

    public List<Manager> getManagerlist() {
        return managerlist;
    }

    public void setManagerlist(List<Manager> managerlist) {
        this.managerlist = managerlist;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateofbirthstring() {
        return dateofbirthstring;
    }

    public void setDateofbirthstring(String dateofbirthstring) {
        this.dateofbirthstring = dateofbirthstring;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getQualificationstring() {
        return qualificationstring;
    }

    public void setQualificationstring(String qualificationstring) {
        this.qualificationstring = qualificationstring;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatusstring() {
        return statusstring;
    }

    public void setStatusstring(String statusstring) {
        this.statusstring = statusstring;
    }

    MastersDAO mdao = new MastersDAO();

    @Override
    public String execute() throws Exception {
        String returnvalue = "";
        try {
            List<Manager> managerstatus = mdao.getValidateManagers(emailid, password);
            Manager manager = mdao.getManagerbyId(managerstatus.get(0).getId());
            if (managerstatus != null) {
                sessionmap.put("managerid", manager.getId());
                sessionmap.put("emailid", manager.getEmailid());
                sessionmap.put("managerfn", manager.getFirstname());
                sessionmap.put("managerln", manager.getLastname());
                sessionmap.put("mobile", manager.getMobileno());
                displaymsg = true;
                unpaidcandidatelist = mdao.getAllCandidatesByStatusname("Un-Paid");
                returnvalue = "success";
            }

        } catch (Exception e) {
            displaymsg = false;
            returnvalue = "error";
        }

        return returnvalue;
    }
    
     public String logout() {

        sessionmap.remove("managerid");
        sessionmap.remove("adminid");
        sessionmap.remove("recruiterid");
        sessionmap.remove("emailid");
        sessionmap.remove("password");
        sessionmap.remove("managerfn");
        sessionmap.remove("managerln");
        sessionmap.remove("adminfn");
        sessionmap.remove("adminln");
        sessionmap.remove("recruiterfn");
        sessionmap.remove("recruiterln");
        displaymsg = true;
        return "success";
    }
     
    public String toAddManager() {
        qualificationlist = mdao.getAllQualifications();
        activestatuslist = mdao.getAllActiveStatus();
        return SUCCESS;
    }

    public String addManager() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateofbirths = sdf.parse(dateofbirthstring);
        Manager manager = new Manager();
        manager.setFirstname(firstname);
        manager.setLastname(lastname);
        manager.setMobileno(mobileno);
        manager.setGender(gender);
        manager.setEmailid(emailid);
        manager.setDateofbirth(dateofbirths);
        manager.setPassword(password);
        manager.setReligion(religion);
        manager.setQualificationid(mdao.getQualificationbyId(qualificationstring));
        manager.setCountry(country);
        manager.setState(state);
        manager.setAddress(address);
        manager.setCity(city);
        manager.setStatusid(mdao.getActiveStatusbyId(statusstring));
        mdao.addManager(manager);
        addstatus=true;
        getAllManagers();
        return SUCCESS;
    }

    public String getAllManagers() {
        managerlist = mdao.getAllManagers();
        return SUCCESS;
    }

}
