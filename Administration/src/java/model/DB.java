/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;
//import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claire
 */
public class DB {

    // JDBC conducteur prenom and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/AdminINSA";
    // Database credentials
    static final String USER = "prog";
    static final String PASS = "prog";

    static final String T_AGREEMENTS = "Agreements";
    static final String[] T_AGREEMENTS_FIELDS = {"id", "idStudent",
        "idPendingInternship", "signAdmin", "signStud", "signCorp"};
    
    static final String T_INTERNSHIPS = "Internships";
    static final String[] T_INTERNSHIPS_FIELDS = {"id", "candidate","company" ,
        "postDate", "salary", "title", "description", "tutor", "phoneNumber", 
        "department", "location",  "isPending"};

    /**
     *
     */
    //public enum user {"AdminINSA", "Etudiant", "Corporation"};
    String user = "";

    Connection conn = null;
    Statement stmt = null;

    Connection connTravail = null;
    Statement stmtTravail = null;

    public DB() {
        connect();
    }

//    @Override
    public void connect() {
        try {
            //STEP 2: Register JDBC conducteur
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //System.out.println("conn= " + 1);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.err.println("In DB - connect : " + e.getLocalizedMessage());

        }

    }

//    @Override
    public void closeConnection() {
        try {
            // rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    
//    @Override
    public ArrayList<Agreement> listAgreement() {
        ArrayList<Agreement> res = new ArrayList<>();
        String[] sql = new String[1];
        sql[0] = "SELECT * FROM " + T_AGREEMENTS;

        try {
            ResultSet rs = stmt.executeQuery(sql[0]);
            System.out.println("+++++++++++++++++++++++++++AGREEMENTS TABLE+++++++++++++++++++++++++++++++\n");
            while (rs.next()) {
                int id = rs.getInt(T_AGREEMENTS_FIELDS[0]);
                String idStudent = rs.getString(T_AGREEMENTS_FIELDS[1]);
                String idPendingInternship = rs.getString(T_AGREEMENTS_FIELDS[2]);
                Boolean signAdmin = rs.getBoolean(T_AGREEMENTS_FIELDS[3]);
                Boolean signStud = rs.getBoolean(T_AGREEMENTS_FIELDS[4]);
                Boolean signCorp= rs.getBoolean(T_AGREEMENTS_FIELDS[5]);
                
                res.add(new Agreement(id, idStudent, idPendingInternship, signAdmin, signStud, signCorp));
                        
                /*for (String f : T_AGREEMENTS_FIELDS) {
                    System.out.print(f + ":" + rs.getString(f) + "\t");
                }*/
            }
            System.out.println();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public ArrayList<Agreement> listAgreementByStudent(String idStudent) {
        ArrayList<Agreement> res = new ArrayList<>();
        String[] sql = new String[1];
        sql[0] = "SELECT * FROM " + T_AGREEMENTS + " WHERE " + 
                T_AGREEMENTS_FIELDS[1] + " = " + idStudent;
        
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql[0]);
            System.out.println("+++ Agreement for student " + idStudent + " +++\n");
            while (rs.next()){
                int id = rs.getInt(T_AGREEMENTS_FIELDS[0]);
                //String idStudent = rs.getString(T_AGREEMENTS_FIELDS[1]);
                String idPendingInternship = rs.getString(T_AGREEMENTS_FIELDS[2]);
                Boolean signAdmin = rs.getBoolean(T_AGREEMENTS_FIELDS[3]);
                Boolean signStud = rs.getBoolean(T_AGREEMENTS_FIELDS[4]);
                Boolean signCorp= rs.getBoolean(T_AGREEMENTS_FIELDS[5]);
                
                res.add(new Agreement(id, idStudent, idPendingInternship, signAdmin, signStud, signCorp));
                // Display values
                /*for (String f : T_AGREEMENTS_FIELDS) {
                    System.out.print(f + ":" + rs.getString(f) + "\t");
                }*/
            }
            System.out.println();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    
    public ArrayList<PendingInternship> listPendingInternship(){
        ArrayList<PendingInternship> res = new ArrayList<>();
        String[] sql = new String[1];
        sql[0] = "SELECT * FROM " + T_INTERNSHIPS;

        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql[0]);
            System.out.println("+++++++++++++++++++++++++++INTERNSHIPS TABLE+++++++++++++++++++++++++++++++\n");
            while (rs.next()) {
                int id = rs.getInt(T_AGREEMENTS_FIELDS[0]);
                String candidate = rs.getString(T_AGREEMENTS_FIELDS[1]);
                String company = rs.getString(T_AGREEMENTS_FIELDS[2]);
                String postDate = rs.getString(T_AGREEMENTS_FIELDS[3]);
                int salary = rs.getInt(T_AGREEMENTS_FIELDS[4]);
                String title = rs.getString(T_AGREEMENTS_FIELDS[5]);
                String description = rs.getString(T_AGREEMENTS_FIELDS[6]);
                String tutor = rs.getString(T_AGREEMENTS_FIELDS[7]);
                String phoneNumber = rs.getString(T_AGREEMENTS_FIELDS[8]);
                String department = rs.getString(T_AGREEMENTS_FIELDS[9]);
                String location = rs.getString(T_AGREEMENTS_FIELDS[10]);
                Boolean isPending = rs.getBoolean(T_AGREEMENTS_FIELDS[11]);
                
                res.add(new PendingInternship(id, candidate, company, postDate, 
                        salary, title, description, tutor, phoneNumber, department,
                        location, isPending));
                /*//Display values
                for (String f : T_INTERNSHIPS_FIELDS) {
                    System.out.print(f + ":" + rs.getString(f) + "\t");
                }*/
            }
            System.out.println();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public ArrayList<PendingInternship> listPendingInternshipByStudent(String candidate) {
        ArrayList<PendingInternship> res = new ArrayList<>();
        String[] sql = new String[1];
        sql[0] = "SELECT * FROM " + T_INTERNSHIPS + " WHERE " + 
                T_INTERNSHIPS_FIELDS[1] + " = " + candidate;
        
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql[0]);
            System.out.println("+++++++++++++++++++++++++++INTERNSHIPS TABLE+++++++++++++++++++++++++++++++\n");
            while (rs.next()) {
                int id = rs.getInt(T_AGREEMENTS_FIELDS[0]);
                //String candidate = rs.getString(T_AGREEMENTS_FIELDS[1]);
                String company = rs.getString(T_AGREEMENTS_FIELDS[2]);
                String postDate = rs.getString(T_AGREEMENTS_FIELDS[3]);
                int salary = rs.getInt(T_AGREEMENTS_FIELDS[4]);
                String title = rs.getString(T_AGREEMENTS_FIELDS[5]);
                String description = rs.getString(T_AGREEMENTS_FIELDS[6]);
                String tutor = rs.getString(T_AGREEMENTS_FIELDS[7]);
                String phoneNumber = rs.getString(T_AGREEMENTS_FIELDS[8]);
                String department = rs.getString(T_AGREEMENTS_FIELDS[9]);
                String location = rs.getString(T_AGREEMENTS_FIELDS[10]);
                Boolean isPending = rs.getBoolean(T_AGREEMENTS_FIELDS[11]);
                
                res.add(new PendingInternship(id, candidate, company, postDate, 
                        salary, title, description, tutor, phoneNumber, department,
                        location, isPending));
                /*
                // Display values
                for (String f : T_INTERNSHIPS_FIELDS) {
                    System.out.print(f + ":" + rs.getString(f) + "\t");
                }*/
            }
            System.out.println();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    
    
    public void createPendingInternship(String student, String company, 
        String postDate, float salary, String description, String tutor,
        String phoneNumber, String department, String location){
        String[] sql = new String[1];
        sql[0] = "INSERT INTO " + T_INTERNSHIPS + "(`id`, `candidate`,`company`, `postDate`"
                + ", `salary`, `title`, `description`, `tutor`, `phoneNumber`,"
                + "`department`, `location`, `isPending`) VALUES ( " + student +
                ", " + company + ", " + postDate + ", " + String.valueOf(salary)
                + ", " + description + ", " + tutor + ", " + phoneNumber+ ", " +
                department + ", " + location + ", NULL)";
                
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql[0]);
            rs.close();
        }catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean acceptPendingInternship(String user, String idInternship) {
        String[] sql = new String[1];
        sql[0] = "UPDATE " + T_INTERNSHIPS + " SET " + T_INTERNSHIPS_FIELDS[11] +
                " = TRUE WHERE " + T_INTERNSHIPS_FIELDS[1] + " = " + user + 
                " AND " + T_INTERNSHIPS_FIELDS[2] + " = " + idInternship;
        
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql[0]);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean refusePendingInternship(String user, String idInternship) {
        String[] sql = new String[1];
        sql[0] = "UPDATE " + T_INTERNSHIPS + " SET " + T_INTERNSHIPS_FIELDS[11] +
                " = FALSE WHERE " + T_INTERNSHIPS_FIELDS[1] + " = " + user + 
                " AND " + T_INTERNSHIPS_FIELDS[2] + " = " + idInternship;
        
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql[0]);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
   
    
    public boolean generateAgreement(String student, String pendingInternship) {
        String[] sql = new String[1];
        boolean res = true;
        sql[0] = "INSERT INTO " + T_AGREEMENTS + "(`id`, `idEtudiant`, "
                + "`idPendingInternship`, `signAdmin`, `signEtud`, `signCorp`) "
                + "VALUES ( " + student + ", " + pendingInternship + ", TRUE,"
                + " TRUE, TRUE)";
        
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql[0]);
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
        
    
        
/*  
    public boolean signAgreement(String user, String idAgreement) {
        String sql;
        boolean res = false;
        
        if (user.equals("AdminINSA")) {
            //sql = "UPDATE Agreements SET signAdmin = TRUE;
            sql = "UPDATE " + T_AGREEMENTS + "SET " + T_AGREEMENTS_FIELDS[4]
                    + " = TRUE";
        } else if (user.equals("Etudiant")) {
            //sql = "UPDATE Agreements SET signEtud = TRUE;
            sql = "UPDATE " + T_AGREEMENTS + "SET " + T_AGREEMENTS_FIELDS[5]
                    + " = TRUE";
        } else if (user.equals("Corporation")) {
            //sql = "UPDATE Agreements SET signCorp = TRUE;
            sql = "UPDATE " + T_AGREEMENTS + "SET " + T_AGREEMENTS_FIELDS[6]
                    + " = TRUE";
        } else {
            sql = "";
        }
        ResultSet rs;

        try {
            rs = stmt.executeQuery(sql);
            rs.close();
        } catch (SQLException ex ) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public boolean refuseAgreement(String user, String idAgreement) {
        String sql;
        boolean res = false;
        if (user.equals("AdminINSA")) {
            //sql = "UPDATE Agreements SET signAdmin = FALSE;
            sql = "UPDATE " + T_AGREEMENTS + "SET " + T_AGREEMENTS_FIELDS[4]
                    + " = FALSE";
        } else if (user.equals("Etudiant")) {
            //sql = "UPDATE Agreements SET signEtud = FALSE;
            sql = "UPDATE " + T_AGREEMENTS + "SET " + T_AGREEMENTS_FIELDS[5]
                    + " = FALSE";
        } else if (user.equals("Corporation")) {
            //sql = "UPDATE Agreements SET signCorp = FALSE;
            sql = "UPDATE " + T_AGREEMENTS + "SET " + T_AGREEMENTS_FIELDS[6]
                    + " = FALSE";
        } else {
            sql = "";
        }

        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            rs.close();
        }catch (SQLException ex ) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
*/
}
