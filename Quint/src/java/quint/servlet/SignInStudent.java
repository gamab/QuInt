/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quint.servlet;

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
@WebServlet(name = "SignInStudent", urlPatterns = {"/SignInStudent.do"})
public class SignInStudent extends HttpServlet {

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
        String destination = "pagesStudent/login.jsp";
        //String destination = "userPage.jsp";


        //retreive the email and the pswd
        HttpSession s = request.getSession();
        String email = request.getParameter("email");
        String pswd = request.getParameter("password");
        s.setAttribute("password", pswd);
        
        if (!email.isEmpty() && !pswd.isEmpty()) {
            s.setAttribute("email", email);

//            DBInterface dbi = new DB();
            
//            DbWebService_Service dbserv = new DbWebService_Service();
//            DbWebService debe = dbserv.getDbWebServicePort();
            //System.out.println("In SignInServlet : Le mot de passe reçu de la base de données est : " + pswd);
            //if (debe.isUserInDB(email)) {
            if(email.equals("Ayoub")){
                //if(debe.userPasswordMatch(email, pswd)){
                if(pswd.equals("aaaaaaaa")){
                    System.out.println("In SignInServlet : Login correct.");
                    //dbi.rememberUserLogIn(email);
                    //boolean admin = dbi.isUSerAdmin(email);
                    //s.setAttribute("admin", admin);
                    destination = "pagesStudent/ShowMainPage.do";
                }else{
                    System.out.println("In SignInServlet : Mot de passe incorrect.");
                    s.setAttribute("msgErreur", "Mot de passe incorrect.");
                    System.out.println((String)s.getAttribute("msgErreur"));
                }
            } else {
                System.out.println("In SignInServlet : Login incorrect.");
                s.setAttribute("msgErreur", "Login incorrect.");
                System.out.println((String)s.getAttribute("msgErreur"));
            }
        } else {
            if (email.isEmpty()) {
                s.setAttribute("msgErreur", "Remplissez le champ email.");
            } else if (pswd.isEmpty() || pswd.length() < 8) {
                String erreurComplement = "";
                s.setAttribute("msgErreur", "Remplissez le champ mot de passe avec plus de 8 caractères." + erreurComplement);
            }
        }

        System.out.println("InSignInServlet : Destination : "+"/"+destination);
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
