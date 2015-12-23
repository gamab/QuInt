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
    public boolean proposeInternship(@WebParam(name = "postDate") String postDate, @WebParam(name = "salary") int salary, @WebParam(name = "title") String title, @WebParam(name = "description") String description, @WebParam(name = "personInCharge") String personInCharge, @WebParam(name = "phoneNumber") String phoneNumber, @WebParam(name = "department") String department) {
        DB db = new DB();

        boolean res = db.proposeInternship(postDate, salary, title, description, personInCharge, phoneNumber, department);

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
     * for a given department
     *
     * @param department - The department concerned (GEI, GP, GC, GMM, GM, GB,
     * GPE)
     * @return result - An arraylist containing every internship
     */
    @WebMethod(operationName = "listProposedInternshipsForDepartment")
    public ArrayList<InternshipProposal> listProposedInternshipsForDepartment(String department) {
        DB db = new DB();

        ArrayList<InternshipProposal> res = db.listProposedInternshipsForDepartment(department);

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
    public InternshipProposal getProposedInternship(int id) {
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
    public ArrayList<String> listCandidates(int id){
        DB db = new DB();

        ArrayList<String> res = db.listCandidates(id);

        db.closeConnection();

        return res;
    }
}
