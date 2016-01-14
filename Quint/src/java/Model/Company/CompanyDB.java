/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Company;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;

/**
 *
 * @author gb
 */
public class CompanyDB {

    private void addCandidateApplication() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<addCandidateApplication  xmlns=\"http://controller/\"><email>ENTER VALUE</email><idInternship>ENTER VALUE</idInternship></addCandidateApplication>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void deleteCandidateApplication() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<deleteCandidateApplication  xmlns=\"http://controller/\"><email>ENTER VALUE</email><idInternship>ENTER VALUE</idInternship></deleteCandidateApplication>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void deleteProposedInternship() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<deleteProposedInternship  xmlns=\"http://controller/\"><id>ENTER VALUE</id></deleteProposedInternship>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void getProposedInternship() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<getProposedInternship  xmlns=\"http://controller/\"><id>ENTER VALUE</id></getProposedInternship>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void listCandidates() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<listCandidates  xmlns=\"http://controller/\"><id>ENTER VALUE</id></listCandidates>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void listProposedInternships() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<listProposedInternships  xmlns=\"http://controller/\"></listProposedInternships>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void listProposedInternshipsFiltered() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<listProposedInternshipsFiltered  xmlns=\"http://controller/\"><date>ENTER VALUE</date><departement>ENTER VALUE</departement><location>ENTER VALUE</location></listProposedInternshipsFiltered>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    private void proposeInternship() {
        controller.CorporationWS_Service service = new controller.CorporationWS_Service();
        QName portQName = new QName("http://controller/", "CorporationWSPort");
        String req = "<proposeInternship  xmlns=\"http://controller/\"><postDate>ENTER VALUE</postDate><salary>ENTER VALUE</salary><title>ENTER VALUE</title><description>ENTER VALUE</description><personInCharge>ENTER VALUE</personInCharge><phoneNumber>ENTER VALUE</phoneNumber><department>ENTER VALUE</department><location>ENTER VALUE</location></proposeInternship>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    
}
