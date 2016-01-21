/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools ; Templates
 * and open the template in the editor.
 */
package databaseApplication;

/**
 *
 * @author root
 */
public class Student {

    private String email;
    private String password;
    private int admin;
    private String prenom;
    private String nom;
    private String tel;
    private String adresse;
    private String commune;
    private String cv;
    private String lm; //lettre de motivation
    private int code_postal;
    private int conducteur;
    private int notif;

    public Student(String email, String password, int admin, String prenom, String nom, String tel, String adresse, String commune, int code_postal, String cv,String lm, int conducteur, int notif) {
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.prenom = prenom;
        this.nom = nom;
        this.tel = tel;
        this.adresse = adresse;
        this.commune = commune;
        this.cv = cv;
        this.lm=lm;
        this.code_postal = code_postal;
        this.conducteur = conducteur;
        this.notif = notif;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public int getConducteur() {
        return conducteur;
    }

    public void setConducteur(int conducteur) {
        this.conducteur = conducteur;
    }

    public int getNotif() {
        return notif;
    }

    public void setNotif(int notif) {
        this.notif = notif;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", password=" + password + ", admin=" + admin + ", prenom=" + prenom + ", nom=" + nom + ", tel=" + tel + ", adresse=" + adresse + ", commune=" + commune + ", code_postal=" + code_postal + ", conducteur=" + conducteur + ", notif=" + notif + ", cv= " + cv + '}';
    }

}