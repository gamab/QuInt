/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Company;

import controller.InternshipProposal;

/**
 *
 * @author gb
 */
public class CorpDB {

    public static boolean addCandidateApplication(java.lang.String email, int idInternship) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.addCandidateApplication(email, idInternship);
    }

    public static boolean deleteCandidateApplication(java.lang.String email, int idInternship) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.deleteCandidateApplication(email, idInternship);
    }

    public static boolean deleteProposedInternship(int id) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.deleteProposedInternship(id);
    }

    public static InternshipProposal getProposedInternship(int id) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.getProposedInternship(id);
    }

    public static java.util.List<java.lang.String> listCandidates(int id) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.listCandidates(id);
    }

    public static java.util.List<controller.InternshipProposal> listProposedInternships() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.listProposedInternships();
    }

    public static java.util.List<controller.InternshipProposal> listProposedInternshipsFiltered(java.lang.String date, java.lang.String departement, java.lang.String location) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.listProposedInternshipsFiltered(date, departement, location);
    }

    public static boolean proposeInternship(java.lang.String postDate, int salary, java.lang.String title, java.lang.String description, java.lang.String personInCharge, java.lang.String phoneNumber, java.lang.String department, java.lang.String location) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.proposeInternship(postDate, salary, title, description, personInCharge, phoneNumber, department, location);
    }
    
}
