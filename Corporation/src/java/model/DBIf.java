/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author gb
 */
public interface DBIf {

    /**
     * Function that list what is inside the database
     */
    public void listDB();

    //--------------------FOR STUDENTS--------------------
    /**
     * Function that adds an application for a given internship to the list of
     * applications (candidates table).
     *
     * @param email - The email identifying the candidate
     * @param idInternship - The id identifying the internship
     * @return result - Wether it has been added or not
     */
    public boolean addCandidateApplication(String email, int idInternship);

    /**
     * Function that removes an application for a given internship from the list
     * of applications (candidates table).
     *
     * @param email - The email identifying the candidate
     * @param idInternship - The id identifying the internship
     * @return result - Wether it has been deleted or not
     */
    public boolean deleteCandidateApplication(String email, int idInternship);

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
     * @param location - The postal code where the internship will take place
     * @return result - Wether it has been added or not
     */
    public boolean proposeInternship(String postDate, int salary, String title, String description,
            String personInCharge, String phoneNumber, String department, String location);

    /**
     * Function that deletes a proposed internship (internships table).
     *
     * @param id - The id of the proposal to remove from the internships table
     * @return result - Wether it has been deleted or not
     */
    public boolean deleteProposedInternship(int id);

    /**
     * Function that retrieves from the internships table all the internships
     *
     * @return result - An arraylist containing every internship
     */
    public ArrayList<InternshipProposal> listProposedInternships();
    
    /**
     * Function that retrieves from the internships table all the internships
     * for a given set of filters
     *
     * @param date - The maximum age, older entries will be ignored
     * @param department - The department concerned (GEI, GP, GC, GMM, GM, GB,
     * GPE) can be null or empty
     * @param location - The location concerned (31100, 31400, ...) can be null or empty
     * @return result - An arraylist containing every internship
     */
    public ArrayList<InternshipProposal> listProposedInternshipsFiltered(String date, String department, String location);

    /**
     * Function that retrieves from the internships table a given the internship
     *
     * @param id - The id of the proposal to retrieve
     * @return result - The internship proposal or null
     */
    public InternshipProposal getProposedInternship(int id);

    /**
     * Function that retrieves all the candidates for a given internship
     *
     * @param id - The id of the internship
     * @return result - An arraylist containing all the students uuid (email)
     */
    public ArrayList<String> listCandidates(int id);
    
    /**
     * Set the internship to be provided
     * 
     * @param internship_id - The id of the internship
     * @return result - if it worked or not
     */
    public boolean setInternshipProvided(int internship_id);
    
    /**
     * Set the uuid of the selected student for the internship
     * 
     * @param uuid
     * @param internship_id - The id of the internship
     * @return result - if it worked or not
     */
    public boolean setInternshipSelectedStudent(String uuid, int internship_id);
    
    /**
     * List the internship that have not been provided yet
     * 
     * @return result - the internships that have not been provided
     */
    public ArrayList<InternshipProposal> listUnprovidedInternships();
    
    /**
     * List the internship where uuid applied
     * 
     * @return result - the internships where uuid applied
     */
    public ArrayList<InternshipProposal> listAppliedInternships(String uuid);
}
