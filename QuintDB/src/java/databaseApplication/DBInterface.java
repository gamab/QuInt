/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseApplication;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author root
 */
@WebService
public interface DBInterface {

    /**
     *
     * @author root
     */
    @WebMethod
    public void connect();

    @WebMethod
    public void closeConnection();

    @WebMethod
    public void listData();

    @WebMethod
    public Student queryInfo(String email);

    //@WebMethod public int addNewUser(int admin, String prenom, String nom, String password, String tel, String email, String adresse, String commune, int code_postal, int lieu_travail_id, String heure_depart, String heure_retour, String jours_travail, int conducteur, int notif);
    /**
     * Ajoute un utilisateur à la base de donnée. Attention aucune vérification
     * des paramètres n'est faite.
     *
     * @param admin Si l'utilisateur doit être administrateur ou non
     * @param prenom Le prenom de l'utilisateur
     * @param nom Le nom de l'utilisateur
     * @param password Le nom de l'utilisateur
     * @param tel Le numéro de téléphone de l'utilisateur
     * @param email L'email de l'utilisateur
     * @param adresse L'adresse de l'utilisateur
     * @param commune La commune de l'utilisateur ("Toulouse")
     * @param codePostal Le code postal de l'utilisateur ("31100")
     * @param nomLieuTravail Le nom du lieu de travail de l'utilisateur ("Sopra
     * Group 1")
     * @param heureDepart L'heure de départ de l'utilisateur ("08:00:00")
     * @param heureRetour L'heure de retour de l'utilisateur ("17:45:00")
     * @param joursTravail Les jours de travail de l'utilisateur
     * ("Lun,Mar,Mer,Jeu,Ven,Sam,Dim") ("Mar,Jeu")
     * @param conducteur Si l'utilisateur est un conducteur qui donc propose le
     * covoiturage ou non
     * @param notif Si l'utilisateur veut recevoir des mail ou non
     * @return 0 = tout va bien <br/>
     * -1 = n'a pas pu récupérer l'ID associé au lieu de travail<br/>
     * -2 = n'a pas pu accéder à l'id du lieu de travail<br/>
     * -3 = n'a pas pu créer l'utilisateur
     */
    @WebMethod
    public int addNewUser(boolean admin, String prenom, String nom, String password, String tel, String email, String adresse, String commune, String codePostal, boolean conducteur, boolean notif);

    @WebMethod
    public void deleteUser(String email);

    @WebMethod
    public String getPassword(String email);

    @WebMethod
    public void setAdminRight(String email, String admin);

    @WebMethod
    public void setPassword(String email, String password);

    @WebMethod
    public void editUserProfile(String email, String nom, String prenom, String adresse,
            String tel, String commune, String code_postal, String conducteur, String notif);

    @WebMethod
    public boolean emailAlreadyUsed(String email);

    /**
     * Retient la date à laquelle l'utilisateur s'est connecté.
     *
     * @param email l'email de l'utilisateur qui vient de se connecter
     */
    @WebMethod
    public void rememberUserLogIn(String email);

    @WebMethod
    public boolean userPasswordMatch(String email, String password);

    @WebMethod
    public boolean isUserInDB(String email);

    @WebMethod
    public boolean isUSerAdmin(String email);

    @WebMethod
    public List<Student> getAllStudents();

    @WebMethod
    public List<Student> searchStudent(String prenom, String nom);

    @WebMethod
    public int getNumberOfUsers();
}
