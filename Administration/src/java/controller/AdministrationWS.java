/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Agreement;
import model.DB;
import model.PendingInternship;
//import model.InternshipProposal;

/**
 *
 * @author claire
 */
@WebService(serviceName = "AdministrationWS")
public class AdministrationWS {

    /**
     * List database
     *
     * @return result - List of Agreement
     */
    @WebMethod(operationName = "listAgreement")
    public ArrayList<Agreement> listAgreement() {
        DB db = new DB();
        ArrayList<Agreement> result = db.listAgreement();
        db.closeConnection();
        return result;
    }

    /**
     * List database by student
     *
     * @param idStudent - The email identifying the candidate
     * @return result - List of Agreement
     */
    @WebMethod(operationName = "listAgreementByStudent")
    public ArrayList<Agreement> listAgreementByStudent(@WebParam(name = "idStudent") String idStudent) {
        DB db = new DB();
        ArrayList<Agreement> result = db.listAgreementByStudent(idStudent);
        db.closeConnection();
        return result;
    }

    /**
     * Function that lists all the pending internships
     *
     * @return result - List of PendingInternship
     */
    @WebMethod(operationName = "listPendingInternship")
    public ArrayList<PendingInternship> listPendingInternship() {
        DB db = new DB();
        ArrayList<PendingInternship> result = db.listPendingInternship();
        db.closeConnection();
        return result;
    }

    /**
     * Function that select an internship by the id of the student.
     *
     * @param idStudent - The email identifying the candidate
     * @return result - List of PendingInternship
     */
    @WebMethod(operationName = "listPendingInternshipByStudent")
    public ArrayList<PendingInternship> listPendingInternshipByStudent(@WebParam(name = "idStudent") String idStudent) {
        DB db = new DB();
        ArrayList<PendingInternship> result = db.listPendingInternshipByStudent(idStudent);
        db.closeConnection();
        return result;
    }

    /**
     * Function that create a pending internship.
     *
     * @param student - The id identifying the candidate
     * @param company - The id identifying the internship
     * @param postDate - The date of creation
     * @param salary - The global salary for internship
     * @param description - The description of the internship
     * @param tutor - The name of the tutor
     * @param phoneNumber - The phone number of the tutor
     * @param department - The department of the tutor
     * @param location - The location of the tutor
     */
    @WebMethod(operationName = "createPendingInternship")
    public void createPendingInternship(@WebParam(name = "student") String student,
            @WebParam(name = "company") String company,
            @WebParam(name = "postDate") String postDate,
            @WebParam(name = "salary") float salary,
            @WebParam(name = "title") String title,
            @WebParam(name = "description") String description,
            @WebParam(name = "tutor") String tutor,
            @WebParam(name = "phoneNumber") String phoneNumber,
            @WebParam(name = "department") String department,
            @WebParam(name = "location") String location) {
        DB db = new DB();
        db.createPendingInternship(company, company, postDate,
                salary, title, description, tutor, phoneNumber, department, location);
        db.closeConnection();
    }

    /**
     * Function that accept an internship.
     *
     * @param idCoord - The email identifying the candidate
     * @param idInternship - The id identifying an agreement
     * @return res - Wether it has been added or not
     */
    @WebMethod(operationName = "acceptPendingInternship")
    public boolean acceptPendingInternship(@WebParam(name = "idCoord") String idCoord,
            @WebParam(name = "idInternship") String idInternship) {
        DB db = new DB();
        boolean res = db.acceptPendingInternship(idCoord, idInternship);
        db.closeConnection();
        return res;
    }

    /**
     * Function that refuse an internship.
     *
     * @param idRefuse - The email identifying the candidate
     * @param idInternship - The id identifying an agreement
     * @return res - Wether it has been added or not
     */
    @WebMethod(operationName = "refusePendingInternship")
    public boolean refusePendingInternship(@WebParam(name = "idRefuse") String idRefuse,
            @WebParam(name = "idInternship") String idInternship) {
        DB db = new DB();
        boolean res = db.refusePendingInternship(idRefuse, idInternship);
        db.closeConnection();
        return res;
    }

    /**
     * Function that adds an application for a given internship to the list of
     * applications (candidates table).
     *
     * @param idEtud - The id identifying the candidate
     * @param idInternship - The id identifying the internship
     * @return res - Wether it has been generated or not
     */
    @WebMethod(operationName = "generateAgreement")
    public boolean generateAgreement(@WebParam(name = "idEtud") String idEtud,
            @WebParam(name = "idInternship") String idInternship,
            @WebParam(name = "idCompany") String idCompany) {
        DB db = new DB();
        boolean res = db.generateAgreement(idCompany, idEtud, idInternship);
        db.closeConnection();
        return res;
    }

    /*
     * Function that signs an agreement for a given internship.
     *
     * @param idSign - The email identifying the candidate
     * @param idAgreement - The id identifying an agreement
     * @return res - Wether it has been added or not
     */
 /*
    @WebMethod(operationName = "signAgreement")
    public boolean signAgreement(@WebParam(name = "idSign") String idSign, 
        @WebParam(name = "idAgreement") String idAgreement) {
        DB db = new DB();
        boolean res = db.signAgreement(idSign, idAgreement);
        db.closeConnection();
        return res;
    }
     */
 /*
     * Function that refuse an agreement for a given internship.
     *
     * @param idRefuse - The email identifying the candidate
     * @param idAgreement - The id identifying an agreement
     * @return res - Wether it has been added or not
     */
 /*
    @WebMethod(operationName = "refuseAgreement")
    public boolean refuseAgreement(@WebParam(name = "idSign") String idRefuse,
        @WebParam(name = "idAgreement") String idAgreement) {
        DB db = new DB();
        boolean res =db.refuseAgreement(idRefuse, idAgreement);
        db.closeConnection();
        return res;
    }
    
     */
}
