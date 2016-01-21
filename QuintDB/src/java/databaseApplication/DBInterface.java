/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseApplication;

import static databaseApplication.DB.TABLE_MESSAGES;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author root
 */
public interface DBInterface {

    /**
     *
     * @author root
     */
    
    public void connect();
    
    public void closeConnection();
    
    public void listData();
    
    public Student getStudent(String email);
    
    public int addNewUser(String email, String password, int admin, String prenom, String nom, String tel, String adresse, String commune, String cv, String lm, int code_postal, int conducteur, String classe, String departement, String dispoDebut, String dispoFin);
    
    public void deleteUser(String email);
    
    public String getPassword(String email);
    
    public void setAdminRight(String email, String admin);
    
    public void setPassword(String email, String password);
    
    public void editUserProfile(String email, String nom, String prenom, String adresse,
            String tel, String commune, String code_postal, String conducteur, 
            String classe,String departement, String dispoDebut, String dispoFin);

    
    public boolean emailAlreadyUsed(String email);
    
    public void rememberUserLogIn(String email);
    
    public boolean userPasswordMatch(String email, String password);
    
    public boolean isUserInDB(String email);
    
    public boolean isUSerAdmin(String email);

    public List<Student> getAllStudents();
    
    public List<Student> searchStudent(String prenom, String nom);
    
    public int getNumberOfUsers();
    
    public ArrayList<Msg> getAllMessagesForUser(String email);

    public int insertMessage(String email,String from, String to,String msg);

}
