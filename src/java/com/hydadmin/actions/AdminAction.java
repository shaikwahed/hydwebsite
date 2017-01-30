/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hydadmin.actions;

import com.hydadmin.dao.MastersDAO;
import com.hydadmin.pojos.ActiveStatus;
import com.hydadmin.pojos.Admin;
import com.hydadmin.pojos.Candidate;
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
public class AdminAction extends ActionSupport implements SessionAware {

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
    private List<Admin> adminlist = new ArrayList<Admin>();
    private List<Qualification> qualificationlist = new ArrayList<Qualification>();
    private List<ActiveStatus> activestatuslist = new ArrayList<ActiveStatus>();

    private Map sessionmap;
    private Boolean displaymsg;
    private Boolean addstatus;
    private List<Candidate> unpaidcandidatelist = new ArrayList<Candidate>();

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

    public String getDateofbirthstring() {
        return dateofbirthstring;
    }

    public void setDateofbirthstring(String dateofbirthstring) {
        this.dateofbirthstring = dateofbirthstring;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Admin> getAdminlist() {
        return adminlist;
    }

    public void setAdminlist(List<Admin> adminlist) {
        this.adminlist = adminlist;
    }

    public List<Qualification> getQualificationlist() {
        return qualificationlist;
    }

    public void setQualificationlist(List<Qualification> qualificationlist) {
        this.qualificationlist = qualificationlist;
    }

    public List<ActiveStatus> getActivestatuslist() {
        return activestatuslist;
    }

    public void setActivestatuslist(List<ActiveStatus> activestatuslist) {
        this.activestatuslist = activestatuslist;
    }

    MastersDAO mdao = new MastersDAO();

    @Override
    public String execute() throws Exception {
        String returnvalue = "";
        try {
            List<Admin> adminstatus = mdao.getValidateAdmins(emailid, password);
            Admin admin = mdao.getAdminbyId(adminstatus.get(0).getId());
            if (adminstatus != null) {
                sessionmap.put("adminid", admin.getId());
                sessionmap.put("emailid", admin.getEmailid());
                sessionmap.put("adminfn", admin.getFirstname());
                sessionmap.put("adminln", admin.getLastname());
                sessionmap.put("mobileno", admin.getMobileno());
                getAllUnPaidCandidates();
                displaymsg = true;
                returnvalue = "success";
            }

        } catch (Exception e) {
            displaymsg = false;
            returnvalue = "error";
        }

        return returnvalue;
    }

    public String toAddAdmin() {
        qualificationlist = mdao.getAllQualifications();
        activestatuslist = mdao.getAllActiveStatus();
        return SUCCESS;
    }

    public String addAdmin() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateofbirths = sdf.parse(dateofbirthstring);
        Admin admin = new Admin();
        admin.setFirstname(firstname);
        admin.setLastname(lastname);
        admin.setMobileno(mobileno);
        admin.setGender(gender);
        admin.setEmailid(emailid);
        admin.setDateofbirth(dateofbirths);
        admin.setPassword(password);
        admin.setReligion(religion);
        admin.setQualificationid(mdao.getQualificationbyId(qualificationstring));
        admin.setCountry(country);
        admin.setState(state);
        admin.setAddress(address);
        admin.setCity(city);
        admin.setStatusid(mdao.getActiveStatusbyId(statusstring));
        mdao.addAdmin(admin);
        addstatus = true;
        getAllAdmins();
        return SUCCESS;
    }

    public String getAllAdmins() {
        adminlist = mdao.getAllAdmins();
        return SUCCESS;
    }
    
      public String getAllUnPaidCandidates() {
        unpaidcandidatelist = mdao.getAllCandidatesByStatusname("Un-Paid");
        return SUCCESS;
    }
}
