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
import model.DB;
import model.InternshipProposal;

/**
 *
 * @author gb
 */
@WebService(serviceName = "CorporationWS")
public class CorporationWS {

    /**
     * Function that list what is inside the database
     *
     * @WebMethod(operationName = "listDB") public void listDB() { DB db = new
     * DB(); db.listDB(); db.closeConnection(); }
     */
    //--------------------FOR STUDENTS--------------------
    /**
     * Function that adds an application for a given internship to the list of
     * applications (candidates table).
     *
     * @param email - The email identifying the candidate
     * @param idInternship - The id identifying the internship
     * @return result - Wether it has been added or not
     */
    @WebMethod(operationName = "addCandidateApplication")
    public boolean addCandidateApplication(@WebParam(name = "email") String email, @WebParam(name = "idInternship") int idInternship) {
        DB db = new DB();
        boolean res = db.addCandidateApplication(email, idInternship);
        db.closeConnection();
        return res;
    }

    /**
     * Function that removes an application for a given internship from the list
     * of applications (candidates table).
     *
     * @param email - The email identifying the candidate
     * @param idInternship - The id identifying the internship
     * @return result - Wether it has been deleted or not
     */
    @WebMethod(operationName = "deleteCandidateApplication")
    public boolean deleteCandidateApplication(@WebParam(name = "email") String email, @WebParam(name = "idInternship") int idInternship) {
        DB db = new DB();
        boolean res = db.deleteCandidateApplication(email, idInternship);
        db.closeConnection();
        return res;
    }

    //--------------------FOR CORPO USERS--------------------
    /**
     * Function that adds an internship to the proposed internships (internships
     * table).
     *
     * @param postDate - The date of the proposal : YYYY-MM-DD
     * @param salary - The salary proposed for this internship
     * @param title - The title of the internship
     * @param description - The description of the internship
     * @param personInCharge - The person that will be in charge on the company
     * side
     * @param phoneNumber - The phone number of this person
     * @param department - The department can be GEI, GP, GM, GMM, GPE, GB
     * @return result - Wether it has been added or not
     */
    @WebMethod(operationName = "proposeInternship")
    public boolean proposeInternship(@WebParam(name = "postDate") String postDate, @WebParam(name = "salary") int salary, @WebParam(name = "title") String title, @WebParam(name = "description") String description, @WebParam(name = "personInCharge") String personInCharge, @WebParam(name = "phoneNumber") String phoneNumber, @WebParam(name = "department") String department, @WebParam(name = "location") String location) {
        DB db = new DB();

        boolean res = db.proposeInternship(postDate, salary, title, description, personInCharge, phoneNumber, department, location);

        db.closeConnection();

        return res;
    }

    /**
     * Function that deletes a proposed internship (internships table).
     *
     * @param id - The id of the proposal to remove from the internships table
     * @return result - Wether it has been deleted or not
     */
    @WebMethod(operationName = "deleteProposedInternship")
    public boolean deleteProposedInternship(@WebParam(name = "id") int id) {
        DB db = new DB();

        boolean res = db.deleteProposedInternship(id);

        db.closeConnection();

        return res;
    }

    /**
     * Function that retrieves from the internships table all the internships
     *
     * @return result - An arraylist containing every internship
     */
    @WebMethod(operationName = "listProposedInternships")
    public ArrayList<InternshipProposal> listProposedInternships() {
        DB db = new DB();

        ArrayList<InternshipProposal> res = db.listProposedInternships();

        db.closeConnection();

        return res;
    }

    /**
     * Function that retrieves from the internships table all the internships
     * for a given set of filters
     *
     * @param date - The maximum age, older entries will be ignored
     * @param department - The department concerned (GEI, GP, GC, GMM, GM, GB,
     * GPE) can be null or empty
     * @param location - The location concerned (31100, 31400, ...) can be null
     * or empty
     * @return result - An arraylist containing every internship
     */
    @WebMethod(operationName = "listProposedInternshipsFiltered")
    public ArrayList<InternshipProposal> listProposedInternshipsFiltered(@WebParam(name = "date") String date, @WebParam(name = "departement") String department, @WebParam(name = "location") String location) {
        DB db = new DB();

        ArrayList<InternshipProposal> res = db.listProposedInternshipsFiltered(date, department, location);

        db.closeConnection();

        return res;
    }

    /**
     * Function that retrieves from the internships table a given the internship
     *
     * @param id - The id of the proposal to retrieve
     * @return result - The internship proposal or null
     */
    @WebMethod(operationName = "getProposedInternship")
    public InternshipProposal getProposedInternship(@WebParam(name = "id") int id) {
        DB db = new DB();

        InternshipProposal res = db.getProposedInternship(id);

        db.closeConnection();

        return res;
    }

    /**
     * Function that retrieves all the candidates for a given internship
     *
     * @param id - The id of the internship
     * @return result - An arraylist containing all the students uuid (email)
     */
    @WebMethod(operationName = "listCandidates")
    public ArrayList<String> listCandidates(@WebParam(name = "internship_id") int internship_id) {
        DB db = new DB();

        ArrayList<String> res = db.listCandidates(internship_id);

        db.closeConnection();

        return res;
    }

    /**
     * Set the internship to be provided
     *
     * @param internship_id - The id of the internship
     * @return result - if it worked or not
     */
    @WebMethod(operationName = "setInternshipProvided")
    public boolean setInternshipProvided(@WebParam(name = "internship_id") int internship_id) {
        DB db = new DB();

        boolean res = db.setInternshipProvided(internship_id);

        return res;
    }

    /**
     * Set the uuid of the selected student for the internship
     *
     * @param uuid
     * @param internship_id - The id of the internship
     * @return result - if it worked or not
     */
    @WebMethod(operationName = "setInternshipSelectedStudent")
    public boolean setInternshipSelectedStudent(@WebParam(name = "uuid") String uuid, @WebParam(name = "internship_id") int internship_id) {
        DB db = new DB();

        boolean res = db.setInternshipSelectedStudent(uuid, internship_id);

        return res;
    }

    /**
     * List the internship that have not been provided yet
     *
     * @return result - the internships that have not been provided
     */
    @WebMethod(operationName = "listUnprovidedInternships")
    public ArrayList<InternshipProposal> listUnprovidedInternships() {
        DB db = new DB();

        ArrayList<InternshipProposal> res = db.listUnprovidedInternships();

        return res;
    }

    /**
     * List the internship where uuid applied
     *
     * @return result - the internships where uuid applied
     */
    @WebMethod(operationName = "listAppliedInternships")
    public ArrayList<InternshipProposal> listAppliedInternships(@WebParam(name = "uuid") String uuid) {
        DB db = new DB();

        ArrayList<InternshipProposal> res = db.listAppliedInternships(uuid);

        return res;
    }

}
