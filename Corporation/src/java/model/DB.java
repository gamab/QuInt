/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Logger.G_Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class DB implements DBIf {

    // JDBC conducteur prenom and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Corp";
    // Database credentials
    static final String USER = "prog";
    static final String PASS = "prog";

    static final String T_INTERNSHIPS = "internships";
    static final String[] T_INTERNSHIPS_FIELDS = {"id", "post_date", "salary", "title", "description", "person_in_charge", "phone_number", "selected_candidate", "provided"};

    static final String T_CANDIDATES = "candidates";
    static final String[] T_CANDIDATES_FIELDS = {"student_uuid", "internship_id"};

    Connection conn = null;
    Statement stmt = null;

    public DB() {
        connect();
    }

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

    @Override
    public void listDB() {

        String[] sql = new String[2];

        sql[0] = "SELECT * FROM " + T_CANDIDATES;
        sql[1] = "SELECT * FROM " + T_INTERNSHIPS;

        ResultSet rs;
        try {
            System.out.println(sql[0]);
            rs = stmt.executeQuery(sql[0]);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Display values
                for (String f : T_CANDIDATES_FIELDS) {
                    System.out.print(f + ":" + rs.getString(f) + "\t");
                }
                System.out.println();
            }
            //Display values
            rs.close();

            rs = stmt.executeQuery(sql[1]);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column prenom
                for (String f : T_INTERNSHIPS_FIELDS) {
                    System.out.print(f + ":" + rs.getString(f) + "\t");
                }
                System.out.println();
            }
            //Display values
            rs.close();

        } catch (SQLException ex) {
            G_Log.e(this.getClass().getName(), "listDB" , ex.getMessage());
        }
    }

    @Override
    public boolean deleteCandidateApplication(String email, int id_internship) {

        String deleteCandidates = "DELETE FROM " + T_CANDIDATES
                + " WHERE " + T_CANDIDATES_FIELDS[0] + "= ?"
                + " AND " + T_CANDIDATES_FIELDS[1] + "= ?";

        boolean res = false;

        try {
            //prepare the request
            PreparedStatement ps = this.conn.prepareStatement(deleteCandidates);
            ps.setString(1, email);
            ps.setInt(2, id_internship);

            //execute it
            res = (ps.executeUpdate() >= 0);

        } catch (Exception ex) {
            G_Log.e(this.getClass().getName(), "deleteCandidateApplication" , ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean addCandidateApplication(String email, int id_internship) {

        String addCandidate = "INSERT INTO " + T_CANDIDATES + " ("
                + T_CANDIDATES_FIELDS[0] + "," + T_CANDIDATES_FIELDS[1] + ") "
                + "VALUES ( ? , ?)";

        boolean res = false;

        try {
            //prepare the request
            PreparedStatement ps = this.conn.prepareStatement(addCandidate);
            ps.setString(1, email);
            ps.setInt(2, id_internship);

            //execute it
            res = (ps.executeUpdate() >= 0);

        } catch (Exception ex) {
            G_Log.e(this.getClass().getName(), "addCandidateApplication" , ex.getMessage());
        }
        return res;
    }

    public static void main(String[] args) {
        DB db = new DB();

        //db.listDB();

        System.out.print("delete Candidate Application :");
        System.out.println(db.deleteCandidateApplication("mabille@etud.insa-toulouse.fr", 2));
        System.out.print("add Candidate Application :");
        System.out.println(db.addCandidateApplication("mabille@etud.insa-toulouse.fr", 2));
        
        db.closeConnection();
    }
}
