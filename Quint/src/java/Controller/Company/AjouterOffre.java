/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Company;

import Model.Company.CorpDB;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gueldir
 */
public class AjouterOffre extends HttpServlet {

    CorpDB db;
    
    @Override
    public void init() {
        db = new CorpDB();
    }

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
        
        response.setContentType("text/html;charset=UTF-8");
        
        if (request.getParameter("publish") != null) {
            // Récupère les valeurs du formulaire de la requete
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String department = request.getParameter("department");
            String personInCharge = request.getParameter("personInCharge");
            String phoneNumber = request.getParameter("phoneNumber");
            String location = request.getParameter("location");
            int salary = Integer.parseInt(request.getParameter("salary"));

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            String postDate = dateFormat.format(date);
            // Ajoute du stage à la DB
            db.proposeInternship(postDate, salary, title, description, personInCharge, phoneNumber, department, location);
        } else if (request.getParameter("delete") != null) {
            // Suppression du stage dans la DB
            // db.deleteProposedInternship();
        }

        // Redirection vers la page de retour après traitement
        RequestDispatcher rd = request.getRequestDispatcher("/pagesCompany/afficheroffres.do");
        rd.forward(request, response);
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
