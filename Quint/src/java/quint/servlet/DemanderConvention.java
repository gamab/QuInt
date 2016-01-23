/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quint.servlet;

import Model.Company.CorpDB;
import controller.AdministrationWS;
import controller.AdministrationWS_Service;
import controller.InternshipProposal;
import databaseapplication.DbWebService;
import databaseapplication.DbWebService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gb
 */
public class DemanderConvention extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        String email = (String) s.getAttribute("email");
        
        String destination = "pagesStudent/etat.jsp";
        
        if(email!=null && !email.isEmpty()){
            DbWebService_Service dbserv = new DbWebService_Service();
            DbWebService debe = dbserv.getDbWebServicePort();
            
            AdministrationWS_Service adminWS = new AdministrationWS_Service();
            AdministrationWS admin = adminWS.getAdministrationWSPort();

            int offre = Integer.valueOf((String) request.getParameter("demande"));

            System.out.println("In DemanderConventionServlet : Email/Offre : "+email+"/"+offre);
            InternshipProposal internship = CorpDB.getProposedInternship(offre);
            
            admin.createPendingInternship(email, "", internship.getLocation(), internship.getSalary(), internship.getDescription(),
                    internship.getPersonInCharge(), internship.getPhoneNumber(), internship.getDepartment(), 
                    internship.getLocation());

            s.setAttribute("Message", "Votre candidature a bien été transmise.");
        }

        
        System.out.println("In DemanderConventionServlet : Destination : "+"/"+destination);
        RequestDispatcher rd = request.getRequestDispatcher("/" + destination);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
