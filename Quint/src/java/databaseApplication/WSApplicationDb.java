/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseApplication;

import java.util.List;
import javax.jws.WebMethod;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author omar
 */
@WebServlet(name = "WSApplicationDb")
public class WSApplicationDb {

    /**
     * Function that list what is inside the database
     */
    @WebMethod(operationName = "listData")
    public void listDB() {
        DB db = new DB();
        db.listData();
        db.closeConnection();
    }

    @WebMethod(operationName = "queryInfo")
    public Student queryInfo(String email) {
        DB db = new DB();
        Student student = db.queryInfo(email);
        db.closeConnection();
        return student;
    }

    @WebMethod(operationName = "addNewUser")
    public int addNewUser(boolean admin, String prenom, String nom, String password, String tel, String email, String adresse, String commune, String codePostal, boolean conducteur, boolean notif) {
        DB db = new DB();
        int res = db.addNewUser(admin, prenom, nom, password, tel, email, adresse, commune, codePostal, conducteur, notif);
        db.closeConnection();
        return res;
    }

    @WebMethod(operationName = "deleteUser")
    public void deleteUser(String email) {
        DB db = new DB();
        db.deleteUser(email);
        db.closeConnection();
    }

    @WebMethod(operationName = "getPassword")
    public String getPassword(String email) {
        DB db = new DB();
        String s = db.getPassword(email);
        db.closeConnection();
        return s;
    }

    @WebMethod(operationName = "setAdminRight")
    public void setAdminRight(String email, String admin) {
        DB db = new DB();
        db.setAdminRight(email, admin);

    }

    @WebMethod(operationName = "setPassword")
    public void setPassword(String email, String password) {
        DB db = new DB();
        db.setPassword(email, password);
        db.closeConnection();
    }

    @WebMethod(operationName = "editUserProfile")
    public void editUserProfile(String email, String nom, String prenom, String adresse,
            String tel, String commune, String code_postal, String conducteur, String notif) {
        DB db = new DB();
        db.editUserProfile(email, nom, prenom, adresse, tel, commune, code_postal, conducteur, notif);
        db.closeConnection();
    }

    @WebMethod(operationName = "emailAlreadyUsed")
    public boolean emailAlreadyUsed(String email) {
        DB db = new DB();
        boolean res = db.emailAlreadyUsed(email);
        db.closeConnection();
        return res;
    }

    @WebMethod(operationName = "userPasswordMatch")
    public boolean userPasswordMatch(String email, String password) {
        DB db = new DB();
        boolean res = db.userPasswordMatch(email,password);
        db.closeConnection();
        return res;
    }

    @WebMethod(operationName = "isUserInDB")
    public boolean isUserInDB(String email) {
        DB db = new DB();
        boolean res = db.isUserInDB(email);
        db.closeConnection();
        return res;
    }

    @WebMethod(operationName = "isUSerAdmin")
    public boolean isUSerAdmin(String email) {
        DB db = new DB();
        boolean res = db.isUSerAdmin(email);
        db.closeConnection();
        return res;
    }

    @WebMethod(operationName = "getAllStudents")
    public List<Student> getAllStudents() {
        DB db = new DB();
        List<Student> students = db.getAllStudents();
        db.closeConnection();
        return students;
    }

    @WebMethod(operationName = "searchStudent")
    public List<Student> searchStudent(String prenom, String nom) {
        DB db = new DB();
        List<Student> students = db.searchStudent(prenom,nom);
        db.closeConnection();
        return students;
    }

    @WebMethod(operationName = "getNumberOfUsers")
    public int getNumberOfUsers() {
        DB db = new DB();
        int i = db.getNumberOfUsers();
        db.closeConnection();
        return i;
    }

}