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
public class PendingInternship {
    private int id;
    private String candidate;
    private String company;
    private String postDate;
    private int salary;
    private String title;
    private String description;
    private String tutor;
    private String phoneNumber;
    private String department;
    private String location;
    private boolean isPending;
    
    public PendingInternship(int id, String candidate, String company, String postDate,
            int salary, String title, String description, String tutor, 
            String phoneNumber, String department, String location, 
            boolean isPending) {
        this.id = id;
        this.candidate = candidate;
        this.company = company;
        this.postDate = postDate;
        this.salary = salary;
        this.title = title;
        this.description = description;
        this.tutor = tutor;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.location = location;
        this.isPending = isPending;   
    }
    
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("{'id':");
        res.append(id);
        res.append(",'candidate':");
        res.append(candidate);
        res.append(",'company':");
        res.append(company);
        res.append(",'postDate':");
        res.append(postDate);
        res.append(",'salary':");
        res.append(salary);
        res.append(",'title':");
        res.append(title);    
        res.append(",'description':");
        res.append(description);
        res.append(",'tutor':");
        res.append(tutor);
        res.append(",'phoneNumber':");
        res.append(phoneNumber);   
        res.append(",'department':");
        res.append(department);
        res.append(",'location':");
        res.append(location);
        res.append(",'isPending':");
        res.append(isPending); 
        return res.toString();
    }
    
    public int getId(){
        return id;
    }
    
    public String getCandidate() {
        return candidate;
    }
    
    public String getCompany() {
        return company;
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
    
    public String getTutor() {
        return tutor;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getLocation() {
        return location;
    }
    
    public boolean getIsPending() {
        return isPending;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
     public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
    
    public void setCompany(String company) {
        this.company = company;
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
    
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }
}
