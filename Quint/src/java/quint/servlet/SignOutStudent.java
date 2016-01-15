/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quint.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ayyoub
 */
public class SignOutStudent extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Invaldating Session
        HttpSession s = request.getSession();
        if (s!=null) {
            s.removeAttribute("email");
            s.removeAttribute("password");
            s.removeAttribute("admin");
            s.invalidate();
        }
        //Redirection to the Login page
        String destination = "pagesStudent/login.jsp";
        System.out.println("InSignOut : destination = "+destination);
        RequestDispatcher rd = request.getRequestDispatcher("/"+destination);
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
