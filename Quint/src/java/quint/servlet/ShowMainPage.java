/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quint.servlet;

import databaseApplication.DB;
import databaseApplication.DBInterface;
import java.io.IOException;
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

            DBInterface dbi = new DB();
            
            //if (dbi.isUserInDB(email)) {
            System.out.println("In ShowMainPageServlet: user and pass : "+email+"///"+pswd);
            if(email.equals("Ayoub")){
                //if(dbi.userPasswordMatch(email, pswd)){
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
