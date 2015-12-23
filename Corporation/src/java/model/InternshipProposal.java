/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gb
 */
public class InternshipProposal {
    private String post_date;
    private int salary;
    private String title;
    private String description;
    private String personInCharge;
    private String phoneNumber;
    private String selectedCandidate;
    private boolean provided;

    public InternshipProposal(String post_date, int salary, String title, String description, String personInCharge, String phoneNumber, String selectedCandidate, boolean provided) {
        this.post_date = post_date;
        this.salary = salary;
        this.title = title;
        this.description = description;
        this.personInCharge = personInCharge;
        this.phoneNumber = phoneNumber;
        this.selectedCandidate = selectedCandidate;
        this.provided = provided;
    }

    public String getPost_date() {
        return post_date;
    }

    public int getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSelectedCandidate() {
        return selectedCandidate;
    }

    public boolean isProvided() {
        return provided;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSelectedCandidate(String selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }

    public void setProvided(boolean provided) {
        this.provided = provided;
    }
}
