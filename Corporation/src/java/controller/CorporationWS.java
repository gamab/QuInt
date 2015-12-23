/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.DB;

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
        //TODO write your implementation code here:
        DB db = new DB();
        
        boolean res = db.proposeInternship(postDate, salary, title, description, personInCharge, phoneNumber, department);
        
        db.closeConnection();
        
        return res;
    }
}
