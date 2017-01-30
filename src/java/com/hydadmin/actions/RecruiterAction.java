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
import com.hydadmin.pojos.Recruiter;
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
public class RecruiterAction extends ActionSupport implements SessionAware {

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
    private List<Recruiter> recruiterlist = new ArrayList<Recruiter>();
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

    public String getStatusstring() {
        return statusstring;
    }

    public void setStatusstring(String statusstring) {
        this.statusstring = statusstring;
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

    public List<Recruiter> getRecruiterlist() {
        return recruiterlist;
    }

    public void setRecruiterlist(List<Recruiter> recruiterlist) {
        this.recruiterlist = recruiterlist;
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
            List<Recruiter> managerstatus = mdao.getValidateRecruiters(emailid, password);
            Recruiter recruiter = mdao.getRecruiterbyId(managerstatus.get(0).getId());
            if (managerstatus != null) {
                sessionmap.put("recruiterid", recruiter.getId());
                sessionmap.put("emailid", recruiter.getEmailid());
                sessionmap.put("recruiterfn", recruiter.getFirstname());
                sessionmap.put("recruiterln", recruiter.getLastname());
                sessionmap.put("mobileno", recruiter.getMobileno());
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

    public String toAddRecruiter() {
        qualificationlist = mdao.getAllQualifications();
        activestatuslist = mdao.getAllActiveStatus();
        return SUCCESS;
    }

    public String addRecruiter() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dateofbirths = sdf.parse(dateofbirthstring);
        Recruiter recruiter = new Recruiter();
        recruiter.setFirstname(firstname);
        recruiter.setLastname(lastname);
        recruiter.setMobileno(mobileno);
        recruiter.setGender(gender);
        recruiter.setEmailid(emailid);
        recruiter.setDateofbirth(dateofbirths);
        recruiter.setPassword(password);
        recruiter.setReligion(religion);
        recruiter.setQualificationid(mdao.getQualificationbyId(qualificationstring));
        recruiter.setCountry(country);
        recruiter.setState(state);
        recruiter.setAddress(address);
        recruiter.setCity(city);
        recruiter.setStatusid(mdao.getActiveStatusbyId(statusstring));
        mdao.addRecruiter(recruiter);
        addstatus=true;
        getAllRecruiters();
        return SUCCESS;
    }

    public String getAllRecruiters() {
        recruiterlist = mdao.getAllRecruiters();
        return SUCCESS;
    }
}
