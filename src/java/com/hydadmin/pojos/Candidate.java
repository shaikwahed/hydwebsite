/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hydadmin.pojos;

import java.util.Date;

/**
 *
 * @author Mirza
 */
public class Candidate {
    private String _id;
    private String firstname;
    private String lastname;
    private String mobileno;
    private String gender;
    private String emailid;
    private Date dateofbirth;
    private String passportno;
    private String religion;
    private Qualification qualificationid;
    private Designation designationid;
    private String totalexp;
    private String gulfexp;
    private String indianexp;
    private String applicantid;
    private String receiptno;
    private Status statusid;
    private Date receiptissuedate;
    private Date receiptexpirydate;
    private String address;
    private String country; 
    private String state;
    private String city;
    private Date createddate;
    
    public Candidate() {
        
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
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

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

   
    
    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Qualification getQualificationid() {
        return qualificationid;
    }

    public void setQualificationid(Qualification qualificationid) {
        this.qualificationid = qualificationid;
    }

    public Designation getDesignationid() {
        return designationid;
    }

    public void setDesignationid(Designation designationid) {
        this.designationid = designationid;
    }

 
    public String getTotalexp() {
        return totalexp;
    }

    public void setTotalexp(String totalexp) {
        this.totalexp = totalexp;
    }

    public String getGulfexp() {
        return gulfexp;
    }

    public void setGulfexp(String gulfexp) {
        this.gulfexp = gulfexp;
    }

    public String getIndianexp() {
        return indianexp;
    }

    public void setIndianexp(String indianexp) {
        this.indianexp = indianexp;
    }

    public String getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(String applicantid) {
        this.applicantid = applicantid;
    }

  
    
    public String getReceiptno() {
        return receiptno;
    }

    public void setReceiptno(String receiptno) {
        this.receiptno = receiptno;
    }


    public Status getStatusid() {
        return statusid;
    }

    public void setStatusid(Status statusid) {
        this.statusid = statusid;
    }

    public Date getReceiptissuedate() {
        return receiptissuedate;
    }

    public void setReceiptissuedate(Date receiptissuedate) {
        this.receiptissuedate = receiptissuedate;
    }

    public Date getReceiptexpirydate() {
        return receiptexpirydate;
    }

    public void setReceiptexpirydate(Date receiptexpirydate) {
        this.receiptexpirydate = receiptexpirydate;
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

    
    
}
