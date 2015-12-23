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
    private int id;
    private String postDate;
    private int salary;
    private String title;
    private String description;
    private String personInCharge;
    private String phoneNumber;
    private String department;
    private String selectedCandidate;
    private boolean provided;

    public InternshipProposal(int id, String postDate, int salary, String title, String description, String personInCharge, String phoneNumber, String department, String selectedCandidate, boolean provided) {
        this.id = id;
        this.postDate = postDate;
        this.salary = salary;
        this.title = title;
        this.description = description;
        this.personInCharge = personInCharge;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.selectedCandidate = selectedCandidate;
        this.provided = provided;
    }

    public int getId() {
        return id;
    }
            
    public String getPostDate() {
        return postDate;
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

    public String getDepartment() {
        return department;
    }
    
    public String getSelectedCandidate() {
        return selectedCandidate;
    }

    public boolean isProvided() {
        return provided;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setPostDate(String postDate) {
        this.postDate = postDate;
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

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setSelectedCandidate(String selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }

    public void setProvided(boolean provided) {
        this.provided = provided;
    }
    
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{'id':");
        res.append(id);
        res.append(",'postDate':'");
        res.append(postDate);
        res.append("','salary':");
        res.append(salary);
        res.append(",'title':'");
        res.append(title);
        res.append("','description':'");
        res.append(description);
        res.append("','personInCharge':'");
        res.append(personInCharge);
        res.append("','phoneNumber':'");
        res.append(phoneNumber);
        res.append("','department':'");
        res.append(department);
        res.append("','selectedCandidate':'");
        res.append(selectedCandidate);
        res.append("','provided':");
        res.append(provided);
        res.append("}");
        return res.toString();
    }
}
