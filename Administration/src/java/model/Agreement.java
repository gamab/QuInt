/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author claire
 */
public class Agreement {

    private int id;
    private String idStudent;
    private String idCompany;
    private String idPendingInternship;
    private boolean signAdmin;
    private boolean signStudent;
    private boolean signCorp;

    public Agreement(int id, String idStudent, String idCompany, String idPendingInternship, boolean signAdmin, boolean signStudent, boolean signCorp) {
        this.id = id;
        this.idStudent = idStudent;
        this.idCompany = idCompany;
        this.idPendingInternship = idPendingInternship;
        this.signAdmin = signAdmin;
        this.signStudent = signStudent;
        this.signCorp = signCorp;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public boolean isSignAdmin() {
        return signAdmin;
    }

    public void setSignAdmin(boolean signAdmin) {
        this.signAdmin = signAdmin;
    }

    public boolean isSignStudent() {
        return signStudent;
    }

    public void setSignStudent(boolean signStudent) {
        this.signStudent = signStudent;
    }

    public boolean isSignCorp() {
        return signCorp;
    }

    public void setSignCorp(boolean signCorp) {
        this.signCorp = signCorp;
    }

    public int getId() {
        return id;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public String getIdPendingInternship() {
        return idPendingInternship;
    }

    public boolean getSignAdmin() {
        return signAdmin;
    }

    public boolean getSignStudent() {
        return signStudent;
    }

    public boolean getSignCorp() {
        return signCorp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void getIdPendingInternship(String idPendingInternship) {
        this.idPendingInternship = idPendingInternship;
    }

    public void getSignAdmin(boolean signAdmin) {
        this.signAdmin = signAdmin;
    }

    public void getSignStudent(boolean signStudent) {
        this.signStudent = signStudent;
    }

    public void getSignCorp(boolean signCorp) {
        this.signCorp = signCorp;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{'id':");
        res.append(id);
        res.append(",'idStudent':");
        res.append(idStudent);

        res.append(",'idCompany':");
        res.append(idCompany);

        res.append(",'idPendingInternship':");
        res.append(idPendingInternship);
        res.append(",'signAdmin':");
        res.append(signAdmin);
        res.append(",'signStudent':");
        res.append(signStudent);
        res.append(",'signCorp':");
        res.append(signCorp);
        return res.toString();
    }
}
