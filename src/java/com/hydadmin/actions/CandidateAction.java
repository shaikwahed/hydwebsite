/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hydadmin.actions;

import com.hydadmin.dao.MastersDAO;
import com.hydadmin.pojos.Candidate;
import com.hydadmin.pojos.City;
import com.hydadmin.pojos.Country;
import com.hydadmin.pojos.Designation;
import com.hydadmin.pojos.PaidStatuses;
import com.hydadmin.pojos.Qualification;
import com.hydadmin.pojos.State;
import com.hydadmin.pojos.Status;
import com.hydadmin.utilities.MailSender;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 *
 * @author Mirza
 */
public class CandidateAction {

    private String firstname;
    private String lastname;
    private String mobileno;
    private String gender;
    private String emailid;
    private String dateofbirth;
    private String passportno;
    private String religion;
    private String qualificationstring;
    private String designationstring;
    private String totalexp;
    private String gulfexp;
    private String indianexp;
    private String applicationid;
    private String receiptno;
    private String statusname;
    private String statusstring;
    private String receiptissuestring;
    private String receiptexpirystring;
    private String address;
    private String country;
    private String state;
    private String city;
    private List<Candidate> paidcandidatelist = new ArrayList<Candidate>();
    private List<Candidate> unpaidcandidatelist = new ArrayList<Candidate>();
    private List<Candidate> selectedcandidatelist = new ArrayList<Candidate>();
    private List<Candidate> rejectedcandidatelist = new ArrayList<Candidate>();
    private List<Candidate> blockedcandidatelist = new ArrayList<Candidate>();
    private List<Candidate> notinterestedcandidatelist = new ArrayList<Candidate>();
    private List<Status> statuslist = new ArrayList<Status>();
    private List<Qualification> qualificationlist = new ArrayList<Qualification>();
    private List<Designation> designationlist = new ArrayList<Designation>();

    public List<Qualification> getQualificationlist() {
        return qualificationlist;
    }

    public void setQualificationlist(List<Qualification> qualificationlist) {
        this.qualificationlist = qualificationlist;
    }

    public List<Designation> getDesignationlist() {
        return designationlist;
    }

    public void setDesignationlist(List<Designation> designationlist) {
        this.designationlist = designationlist;
    }

    public List<Status> getStatuslist() {
        return statuslist;
    }

    public void setStatuslist(List<Status> statuslist) {
        this.statuslist = statuslist;
    }

    public List<Candidate> getPaidcandidatelist() {
        return paidcandidatelist;
    }

    public void setPaidcandidatelist(List<Candidate> paidcandidatelist) {
        this.paidcandidatelist = paidcandidatelist;
    }

    public List<Candidate> getUnpaidcandidatelist() {
        return unpaidcandidatelist;
    }

    public void setUnpaidcandidatelist(List<Candidate> unpaidcandidatelist) {
        this.unpaidcandidatelist = unpaidcandidatelist;
    }

    public List<Candidate> getSelectedcandidatelist() {
        return selectedcandidatelist;
    }

    public void setSelectedcandidatelist(List<Candidate> selectedcandidatelist) {
        this.selectedcandidatelist = selectedcandidatelist;
    }

    public List<Candidate> getRejectedcandidatelist() {
        return rejectedcandidatelist;
    }

    public void setRejectedcandidatelist(List<Candidate> rejectedcandidatelist) {
        this.rejectedcandidatelist = rejectedcandidatelist;
    }

    public List<Candidate> getBlockedcandidatelist() {
        return blockedcandidatelist;
    }

    public void setBlockedcandidatelist(List<Candidate> blockedcandidatelist) {
        this.blockedcandidatelist = blockedcandidatelist;
    }

    public List<Candidate> getNotinterestedcandidatelist() {
        return notinterestedcandidatelist;
    }

    public void setNotinterestedcandidatelist(List<Candidate> notinterestedcandidatelist) {
        this.notinterestedcandidatelist = notinterestedcandidatelist;
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

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
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

    public String getQualificationstring() {
        return qualificationstring;
    }

    public void setQualificationstring(String qualificationstring) {
        this.qualificationstring = qualificationstring;
    }

    public String getDesignationstring() {
        return designationstring;
    }

    public void setDesignationstring(String designationstring) {
        this.designationstring = designationstring;
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

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
    }

    public String getReceiptno() {
        return receiptno;
    }

    public void setReceiptno(String receiptno) {
        this.receiptno = receiptno;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getStatusstring() {
        return statusstring;
    }

    public void setStatusstring(String statusstring) {
        this.statusstring = statusstring;
    }

    public String getReceiptissuestring() {
        return receiptissuestring;
    }

    public void setReceiptissuestring(String receiptissuestring) {
        this.receiptissuestring = receiptissuestring;
    }

    public String getReceiptexpirystring() {
        return receiptexpirystring;
    }

    public void setReceiptexpirystring(String receiptexpirystring) {
        this.receiptexpirystring = receiptexpirystring;
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

    public MastersDAO getMdao() {
        return mdao;
    }

    public void setMdao(MastersDAO mdao) {
        this.mdao = mdao;
    }

    MastersDAO mdao = new MastersDAO();

    public String toregister() {
        designationlist=mdao.getAllDesignations();
        qualificationlist=mdao.getAllQualifications();
        return SUCCESS;
    }

    private String getApplicationNo() {
        Date d = new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        //String todaydate = sdf.format(d).replaceAll("-", "");
        List<Candidate> allcandidatelist = mdao.getAllCandidatesByDesc();
        if (allcandidatelist.isEmpty()) {
            String applicantid = "HM4" + "0001";
            return applicantid;

        } else {
            String lastrecord = allcandidatelist.get(0).getApplicantid().substring(0, 3);
            String repstring = allcandidatelist.get(0).getApplicantid().substring(4, 7);

            Integer updatednumber = Integer.parseInt(repstring) + 1;
            DecimalFormat hdg = new DecimalFormat("0000");
            String abc = hdg.format(updatednumber);
            return (lastrecord + abc).toString();
        }
    }
    private Boolean addstatus;

    public Boolean getAddstatus() {
        return addstatus;
    }

    public void setAddstatus(Boolean addstatus) {
        this.addstatus = addstatus;
    }
    private Candidate candidateobj;

    public Candidate getCandidateobj() {
        return candidateobj;
    }

    public void setCandidateobj(Candidate candidateobj) {
        this.candidateobj = candidateobj;
    }

    public String toRegisterCandidate() {
        qualificationlist = mdao.getAllQualifications();
        designationlist = mdao.getAllDesignations();
        return SUCCESS;
    }

    public String registerCandidate() throws ParseException, MessagingException {
        String returnvalue = null;
        candidateobj = mdao.getCandidatebyPassportNo(passportno);
        if (candidateobj == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dateofbirths = sdf.parse(dateofbirth);
//        Date receiptissuestrings = sdf.parse(receiptissuestring);
//        Date receiptexpirystrings = sdf.parse(receiptexpirystring);
            Candidate candidate = new Candidate();
            candidate.setFirstname(firstname);
            candidate.setLastname(lastname);
            candidate.setMobileno(mobileno);
            candidate.setGender(gender);
            candidate.setEmailid(emailid);
            candidate.setDateofbirth(dateofbirths);
            candidate.setPassportno(passportno);
            candidate.setReligion(religion);
            candidate.setQualificationid(mdao.getQualificationbyId(qualificationstring));
            candidate.setDesignationid(mdao.getDesignationbyId(designationstring));
            candidate.setTotalexp(totalexp);
            candidate.setGulfexp(gulfexp);
            candidate.setIndianexp(indianexp);
            candidate.setApplicantid(getApplicationNo());
            candidate.setStatusid(mdao.getStatusbyName("Un-Paid"));
            candidate.setAddress(address);
            candidate.setCountry(country);
            candidate.setState(state);
            candidate.setCity(city);
            candidate.setCreateddate(new Date());
            mdao.addCandidate(candidate);
            String subj = "Hi !" + candidate.getFirstname() + " Welcome To Hyderabad Manpower";
            String content = "You Are Registered Successfully!. Your Applicant ID is " + candidate.getApplicantid();
            MailSender.sendMail1(candidate.getEmailid(), subj, content, "");
            getAllUnPaidCandidates();
            
            returnvalue = "success";
            addstatus = true;
        } else {
            toRegisterCandidate();
            returnvalue = "failure";
            addstatus = false;
            
        }
        return returnvalue;
    }
    private String candidateid;

    public String getCandidateid() {
        return candidateid;
    }

    public void setCandidateid(String candidateid) {
        this.candidateid = candidateid;
    }

    public String toeditStatus() {
        mdao.getCandidatebyId(candidateid);
        statuslist = mdao.getAllStatus();
        return SUCCESS;
    }

    public String toeditCandidate() {
        mdao.getCandidatebyId(candidateid);
        qualificationlist = mdao.getAllQualifications();
        designationlist = mdao.getAllDesignations();
        return SUCCESS;
    }
    private String statusid;

    public String getStatusid() {
        return statusid;
    }

    public void setStatusid(String statusid) {
        this.statusid = statusid;
    }
    private Boolean statusmsg;

    public Boolean getStatusmsg() {
        return statusmsg;
    }

    public void setStatusmsg(Boolean statusmsg) {
        this.statusmsg = statusmsg;
    }
    
    public String updateStatus() {
        candidateobj = mdao.getCandidatebyId(candidateid);
        candidateobj.setStatusid(mdao.getStatusbyId(statusid));
        mdao.updateCandidateStatus(candidateobj);
        getAllUnPaidCandidates();
        statusmsg=true;
        return SUCCESS;
    }
     private Boolean updatestatus;

    public Boolean getUpdatestatus() {
        return updatestatus;
    }

    public void setUpdatestatus(Boolean updatestatus) {
        this.updatestatus = updatestatus;
    }
     
    public String updateCandidate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date receiptissuedate = sdf.parse(receiptissuestring);
        Date receiptexpirydate = sdf.parse(receiptexpirystring);
        candidateobj = mdao.getCandidatebyId(candidateid);
        candidateobj.setReceiptno(receiptno);
        candidateobj.setReceiptissuedate(receiptissuedate);
        candidateobj.setReceiptexpirydate(receiptexpirydate);
        mdao.updateCandidate(candidateobj);
        
        updatestatus=true;
        return SUCCESS;
    }

    public String getAllUnPaidCandidates() {
        unpaidcandidatelist = mdao.getAllCandidatesByStatusname("Un-Paid");
        return SUCCESS;
    }

    public String getAllPaidCandidates() {
        paidcandidatelist = mdao.getAllCandidatesByStatusname("Paid");
        return SUCCESS;
    }

    public String getAllSelectedCandidates() {
        selectedcandidatelist = mdao.getAllCandidatesByStatusname("Selected");
        return SUCCESS;
    }

    public String getAllRejectedCandidates() {
        rejectedcandidatelist = mdao.getAllCandidatesByStatusname("Rejected");
        return SUCCESS;
    }

    public String getAllBlockedCandidates() {
        blockedcandidatelist = mdao.getAllCandidatesByStatusname("Blocked");
        return SUCCESS;
    }

    public String getAllNotInterestedCandidates() {
        notinterestedcandidatelist = mdao.getAllCandidatesByStatusname("Not-Interested");
        return SUCCESS;
    }
}
