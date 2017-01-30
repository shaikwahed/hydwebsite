package com.hydadmin.dao;

import com.hydadmin.pojos.ActiveStatus;
import com.hydadmin.pojos.Admin;
import com.hydadmin.pojos.Qualification;
import com.hydadmin.pojos.Designation;
import com.hydadmin.pojos.Status;
import com.hydadmin.pojos.Country;
import com.hydadmin.pojos.City;
import com.hydadmin.pojos.Candidate;
import com.hydadmin.pojos.Manager;
import com.hydadmin.pojos.Opening;
import com.hydadmin.pojos.PaidStatuses;
import com.hydadmin.pojos.Recruiter;
import com.hydadmin.pojos.State;
import com.hydadmin.utilities.SpringMongoConfig;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class MastersDAO {

    private MongoOperations mongoOperation;
    ApplicationContext ctx;

    public MastersDAO() {
        ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    public List<Manager> getValidateManagers(String emailid, String password) {
        Query q = new Query();
        List<Manager> managerslist = new ArrayList<Manager>();
        q.addCriteria(Criteria.where("emailid").is(emailid).andOperator(Criteria.where("password").is(password)));
        managerslist = mongoOperation.find(q, Manager.class);
        return managerslist;
    }

    public Manager getManagerbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Manager managerobj = mongoOperation.findOne(q, Manager.class);
        return managerobj;
    }

    public List<Admin> getValidateAdmins(String emailid, String password) {
        Query q = new Query();
        List<Admin> adminlist = new ArrayList<Admin>();
        q.addCriteria(Criteria.where("emailid").is(emailid).andOperator(Criteria.where("password").is(password)));
        adminlist = mongoOperation.find(q, Admin.class);
        return adminlist;
    }

    public Admin getAdminbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Admin adminobj = mongoOperation.findOne(q, Admin.class);
        return adminobj;
    }

    public List<Recruiter> getValidateRecruiters(String emailid, String password) {
        Query q = new Query();
        List<Recruiter> recruiterlist = new ArrayList<Recruiter>();
        q.addCriteria(Criteria.where("emailid").is(emailid).andOperator(Criteria.where("password").is(password)));
        recruiterlist = mongoOperation.find(q, Recruiter.class);
        return recruiterlist;
    }

    public Recruiter getRecruiterbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Recruiter recruiterobj = mongoOperation.findOne(q, Recruiter.class);
        return recruiterobj;
    }

    public String addCandidate(Candidate candidateObj) {
        mongoOperation.save(candidateObj);
        return "success";
    }

    public String addManager(Manager managerObj) {
        mongoOperation.save(managerObj);
        return "success";
    }

    public String addAdmin(Admin adminObj) {
        mongoOperation.save(adminObj);
        return "success";
    }

    public String addRecruiter(Recruiter recruiterObj) {
        mongoOperation.save(recruiterObj);
        return "success";
    }

    public String addOpening(Opening openingObj) {
        mongoOperation.save(openingObj);
        return "success";
    }

    public Qualification getQualificationbyName(String qualificationname) {
        Query q = new Query();
        q.addCriteria(Criteria.where("statusname").is(qualificationname));
        Qualification qualificationobj = mongoOperation.findOne(q, Qualification.class);
        return qualificationobj;
    }

    public Qualification getQualificationbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Qualification qualificationobj = mongoOperation.findOne(q, Qualification.class);
        return qualificationobj;
    }

    public Designation getDesignationbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Designation designationobj = mongoOperation.findOne(q, Designation.class);
        return designationobj;
    }

    public PaidStatuses getPaidstatusbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        PaidStatuses paidstatusobj = mongoOperation.findOne(q, PaidStatuses.class);
        return paidstatusobj;
    }

    public Status getStatusbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Status statusobj = mongoOperation.findOne(q, Status.class);
        return statusobj;
    }

    public Status getStatusbyName(String statusname) {
        Query q = new Query();
        q.addCriteria(Criteria.where("statusname").is(statusname));
        Status statusobj = mongoOperation.findOne(q, Status.class);
        return statusobj;
    }

    public ActiveStatus getActiveStatusbyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        ActiveStatus statusobj = mongoOperation.findOne(q, ActiveStatus.class);
        return statusobj;
    }

    public Country getCountrybyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Country countryobj = mongoOperation.findOne(q, Country.class);
        return countryobj;
    }

    public State getStatebyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        State stateobj = mongoOperation.findOne(q, State.class);
        return stateobj;
    }

    public City getCitybyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        City cityobj = mongoOperation.findOne(q, City.class);
        return cityobj;
    }

    public Candidate getCandidatebyId(String editid) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(new ObjectId(editid)));
        Candidate candidateobj = mongoOperation.findOne(q, Candidate.class);
        return candidateobj;
    }
    public Candidate getCandidatebyPassportNo(String passportno) {
        Query q = new Query();
        q.addCriteria(Criteria.where("passportno").is(passportno));
        Candidate candidateobj = mongoOperation.findOne(q, Candidate.class);
        return candidateobj;
    }
    
      public String updateCandidateStatus(Candidate candidateobj) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(candidateobj.getId()));
        Update update = new Update();
        update.set("statusid", candidateobj.getStatusid());
        mongoOperation.updateFirst(q, update, Candidate.class);
        return "success";
    }
    public String updateCandidate(Candidate candidateobj) {
        Query q = new Query();
        q.addCriteria(Criteria.where("_id").is(candidateobj.getId()));
        Update update = new Update();
        update.set("receiptno", candidateobj.getStatusid());
        update.set("receiptissuedate", candidateobj.getReceiptissuedate());
        update.set("receiptexpirydate", candidateobj.getReceiptexpirydate());
        mongoOperation.updateFirst(q, update, Candidate.class);
        return "success";
    }
    public List<Candidate> getAllCandidates() {
        List<Candidate> candidatelist = mongoOperation.findAll(Candidate.class);
        return candidatelist;
    }

    public List<Candidate> getAllCandidatesByDesc() {
        Query q = new Query();
        q.with(new Sort(Sort.Direction.DESC, "createddate"));
        List<Candidate> candidatelist = mongoOperation.find(q,Candidate.class);
        return candidatelist;
    }

    public List<Candidate> getAllCandidatesByStatusname(String statusname) {
        Query q = new Query();
        q.addCriteria(Criteria.where("statusid.statusname").is(statusname));
        List<Candidate> candidatelist = mongoOperation.find(q, Candidate.class);
        return candidatelist;
    }

    public List<Manager> getAllManagers() {
        List<Manager> managerlist = mongoOperation.findAll(Manager.class);
        return managerlist;
    }

    public List<Designation> getAllDesignations() {
        List<Designation> designationlist = mongoOperation.findAll(Designation.class);
        return designationlist;
    }

    public List<Opening> getAllOpenings() {
        List<Opening> openinglist = mongoOperation.findAll(Opening.class);
        return openinglist;
    }

    public String addDesignation(Designation designationObj) {
        mongoOperation.save(designationObj);
        return "success";
    }

    public List<Qualification> getAllQualifications() {
        List<Qualification> qualificationlist = mongoOperation.findAll(Qualification.class);
        return qualificationlist;
    }

    public List<Admin> getAllAdmins() {
        List<Admin> adminlist = mongoOperation.findAll(Admin.class);
        return adminlist;
    }

    public List<Recruiter> getAllRecruiters() {
        List<Recruiter> recruiterlist = mongoOperation.findAll(Recruiter.class);
        return recruiterlist;
    }

    public List<ActiveStatus> getAllActiveStatus() {
        List<ActiveStatus> activestatuslist = mongoOperation.findAll(ActiveStatus.class);
        return activestatuslist;
    }
    public List<Status> getAllStatus() {
        Query q = new Query();
        q.addCriteria(Criteria.where("statusname").nin("Paid").andOperator(Criteria.where("statusname").nin("Un-Paid")));
        List<Status> statuslist = mongoOperation.find(q,Status.class);
        return statuslist;
    }

    public String addQualification(Qualification qualificationObj) {
        mongoOperation.save(qualificationObj);
        return "success";
    }
}
