/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.DB;

/**
 *
 * @author omar
 */
public class TestAdminDB {

    public static void main(String[] args) {
//        AdministrationWS_Service administrationWS_Service = new AdministrationWS_Service();
//        AdministrationWS administrationWS = administrationWS_Service.getAdministrationWSPort();
//        System.out.println(administrationWS.listAgreement());
//        ArrayList<model.Agreement> agreements = administrationWS.listAgreement();
//        for (int i = 0; i < agreements.size(); i++) {
//            System.out.println(agreements.get(i).toString());
//
//        }

        DB db = new DB();
//        db.createPendingInternship("ghader@etud.insa-toulouse.fr", "Sogeti", "1/10/2015", 850, "DevOps", "DevOps", "Thibault Normand", "0762623226", "Security", "TLSE");
//        db.generateAgreement("Sogeti", "ghader@etud.insa-toulouse.fr", "offre4");
        db.acceptPendingInternship("ghader@etud.insa-toulouse.fr", "");
//        db.refusePendingInternship("ghader@etud.insa-toulouse.fr", "offre4");
//
//        //List Agreements
//        ArrayList<model.Agreement> agreements = db.listAgreement();
//        for (int i = 0; i < agreements.size(); i++) {
//            System.out.println(agreements.get(i).toString());
//
//        }
//
//        ArrayList<model.PendingInternship> internships = db.listPendingInternship();
//        for (int i = 0; i < internships.size(); i++) {
//            System.out.println(internships.get(i).toString());
//
//        }
//
//        System.out.println(db.listAgreementByStudent("mabille@etud.insa-toulouse.fr"));
//        System.out.println(db.listPendingInternshipByStudent("mabille@etud.insa-toulouse.fr"));
    }
}
