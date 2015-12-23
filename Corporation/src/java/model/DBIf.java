/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gb
 */
public interface DBIf {

    /**
     * Function that list what is inside the database
     */
    public void listDB();

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

}
