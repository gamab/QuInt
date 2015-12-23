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
     * @param id_internship - The id identifying the internship
     * @return result - Wether it has been added or not
     */
    public boolean addCandidateApplication(String email, int id_internship);

    /**
     * Function that removes an application for a given internship from the list
     * of applications (candidates table).
     *
     * @param email - The email identifying the candidate
     * @param id_internship - The id identifying the internship
     * @return result - Wether it has been deleted or not
     */
    public boolean deleteCandidateApplication(String email, int id_internship);

    //--------------------FOR CORPO USERS--------------------
    /**
     * Function that adds an internship to the proposed internships (internships
     * table).
     *
     * @param post_date - The date of the proposal : YYYY-MM-DD
     * @param salary - The salary proposed for this internship
     * @param title - The title of the internship
     * @param description - The description of the internship
     * @param person_in_charge - The person that will be in charge on the
     * company side
     * @param phone_number - The phone number of this person
     * @return result - Wether it has been added or not
     */
    public boolean proposeInternship(String post_date, int salary, String title, String description,
            String person_in_charge, String phone_number);

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
}
