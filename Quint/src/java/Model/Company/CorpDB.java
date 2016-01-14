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

    private static boolean addCandidateApplication(java.lang.String email, int idInternship) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.addCandidateApplication(email, idInternship);
    }

    private static boolean deleteCandidateApplication(java.lang.String email, int idInternship) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.deleteCandidateApplication(email, idInternship);
    }

    private static boolean deleteProposedInternship(int id) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.deleteProposedInternship(id);
    }

    private static InternshipProposal getProposedInternship(int id) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.getProposedInternship(id);
    }

    private static java.util.List<java.lang.String> listCandidates(int id) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.listCandidates(id);
    }

    private static java.util.List<controller.InternshipProposal> listProposedInternships() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.listProposedInternships();
    }

    private static java.util.List<controller.InternshipProposal> listProposedInternshipsFiltered(java.lang.String date, java.lang.String departement, java.lang.String location) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.listProposedInternshipsFiltered(date, departement, location);
    }

    private static boolean proposeInternship(java.lang.String postDate, int salary, java.lang.String title, java.lang.String description, java.lang.String personInCharge, java.lang.String phoneNumber, java.lang.String department, java.lang.String location) {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        controller.CorporationWS port = service.getCorporationWSPort();
        return port.proposeInternship(postDate, salary, title, description, personInCharge, phoneNumber, department, location);
    }
    
}
