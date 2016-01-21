/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseApplication;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author omar
 */
@WebService(serviceName = "DbWebService")
public class DbWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "listData")
    public void listDB() {
        DB db = new DB();
        System.out.println("OKK");
        db.listData();
        db.closeConnection();
    }

    @WebMethod(operationName = "getStudent")
    public Student getStudent(String email) {
        DB db = new DB();
        Student student = db.getStudent(email);
        db.closeConnection();
        return student;
    }

    @WebMethod(operationName = "addNewUser")
    public int addNewUser(String email, String password, int admin, String prenom, String nom, String tel, String adresse, String commune, String cv, String lm, int code_postal, int conducteur, String classe, String departement, String dispoDebut, String dispoFin) {
        DB db = new DB();
        int res = db.addNewUser(email, password, admin,
                prenom, nom, tel, adresse,
                commune,"","", code_postal, conducteur,
                classe, departement, dispoDebut, dispoFin);
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
            String tel, String commune, String code_postal, String conducteur, 
            String classe,String departement, String dispoDebut, String dispoFin) {
        DB db = new DB();
        db.editUserProfile(email, nom, prenom, adresse, tel, commune, code_postal, conducteur, classe,departement,dispoDebut,dispoFin);
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
        boolean res = db.userPasswordMatch(email, password);
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
        List<Student> students = db.searchStudent(prenom, nom);
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
