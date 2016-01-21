/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quint.servlet;

import controller.CorporationWS;
import controller.CorporationWS_Service;
import databaseApplication.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ayyoub
 */
@WebServlet(name = "ShowMainPage", urlPatterns = {"/ShowMainPage.do"})
public class ShowMainPage extends HttpServlet {

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
        String destination = "pagesStudent/index.jsp";


        //retreive the email and the pswd
        HttpSession s = request.getSession();
        String email = request.getParameter("email");
        String pswd = request.getParameter("password");
        s.setAttribute("password", pswd);
        
        if (!email.isEmpty() && !pswd.isEmpty() && !(pswd.length() < 8)) {
            s.setAttribute("email", email);

//            DBInterface dbi = new DB();
            CorporationWS_Service corpserv = new CorporationWS_Service();
            CorporationWS corp = corpserv.getCorporationWSPort();
            
//            DbWebService_Service dbserv = new DbWebService_Service();
//            DbWebService debe = dbserv.getDbWebServicePort();
            

            
            //if (debe.isUserInDB(email)) {
            if(email.equals("Ayoub")){
                //if(debe.userPasswordMatch(email, pswd)){
                if(pswd.equals("aaaaaaaa")){
                    System.out.println("In ShowMainPageServlet: Login correct.");
                    //dbi.rememberUserLogIn(email);
                    //boolean admin = dbi.isUSerAdmin(email);
                    //s.setAttribute("admin", admin);
                    
                    /*--- CECI EST DU HARD CODE POUR TESTER ---*/
                    String messages = "5";
                    s.setAttribute("messages", messages);
                    
                    String attente = "7";
                    s.setAttribute("attente", attente);
                    
                    String refuse = "2";
                    s.setAttribute("refuse", refuse);
                    
                    String validee = "1";
                    s.setAttribute("validee", validee);
                    
                    List<String> mess = new ArrayList<String>();
                    List<String> attentes = new ArrayList<String>();
                    List<String> validees = new ArrayList<String>();
                    List<String> refusees = new ArrayList<String>();
                    List<String> offres = new ArrayList<String>();
                    
                    mess.add("Thales Alinea spc : Bonjour Mr Ayyoub, Je me permet de vous contacter suite à notre entretien téléphonique. Je vous confirme notre intérêt et nous\n" +
"                                                souhaitons vous faire une proposition de stage. J'aimerai avoir votre réponse dans un délai inférieur à une semaine...");
                    mess.add("Capgemini : Bonjour Mr Ayyoub, Je me permet de vous contacter suite à notre entretien téléphonique. Je vous confirme notre intérêt et nous\n" +
"                                                souhaitons vous faire une proposition de stage. J'aimerai avoir votre réponse dans un délai inférieur à une semaine...");
                    
                    attentes.add("IBM : Votre demande de validation de stage est mise en attente. Elle sera soit validée soit refusée par les responsables d'études dans \n" +
"                                                    les plus brefs délais.");
                    validees.add("Capgemini : Votre demande de stage a été validée par les responsables d'études.");
                    refusees.add("Nuclear Bungladish / Votre demande de stage a été refusée par le responsable de sécurité. / Motif: Localisation du stage dangereuse pour l'étudiant.");
                    
                    for(int i=0; i<corp.listProposedInternships().size(); i++){
                        System.out.println("Main : j'ajoute l'offre : "+corp.listProposedInternships().get(i));
                        offres.add(corp.listProposedInternships().get(i).getTitle());
                    }
                    
                    s.setAttribute("Msgs", mess);
                    s.setAttribute("Attente", attentes);
                    s.setAttribute("Validees", validees);
                    s.setAttribute("Refusees", refusees);
                    s.setAttribute("Offres", offres);
                    
                    
                    destination = "pagesStudent/index.jsp";
                }
            }
        }
        

        System.out.println("In ShowMainPageServlet : Destination : "+"/"+destination);
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
