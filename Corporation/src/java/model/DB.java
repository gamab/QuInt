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
import java.util.ArrayList;

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
            G_Log.e(this.getClass().getName(), "listDB", ex.getMessage());
        }
    }

    @Override
    public boolean deleteCandidateApplication(String email, int idInternship) {

        String deleteCandidates = "DELETE FROM " + T_CANDIDATES
                + " WHERE " + T_CANDIDATES_FIELDS[0] + "= ?"
                + " AND " + T_CANDIDATES_FIELDS[1] + "= ?";

        boolean res = false;

        try {
            //prepare the request
            PreparedStatement ps = this.conn.prepareStatement(deleteCandidates);
            ps.setString(1, email);
            ps.setInt(2, idInternship);

            //execute it
            res = (ps.executeUpdate() >= 0);

        } catch (Exception ex) {
            G_Log.e(this.getClass().getName(), "deleteCandidateApplication", ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean addCandidateApplication(String email, int idInternship) {

        String addCandidate = "INSERT INTO " + T_CANDIDATES + " ("
                + T_CANDIDATES_FIELDS[0] + "," + T_CANDIDATES_FIELDS[1] + ") "
                + "VALUES ( ? , ?)";

        boolean res = false;

        try {
            //prepare the request
            PreparedStatement ps = this.conn.prepareStatement(addCandidate);
            ps.setString(1, email);
            ps.setInt(2, idInternship);

            //execute it
            res = (ps.executeUpdate() >= 0);

        } catch (Exception ex) {
            G_Log.e(this.getClass().getName(), "addCandidateApplication", ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean proposeInternship(String postDate, int salary, String title, String description, String personInCharge, String phoneNumber) {
        //Prepare the sql request to add an internship to the internships table
        StringBuilder addInternship = new StringBuilder();
        addInternship.append("INSERT INTO " + T_INTERNSHIPS + " (");
        addInternship.append(T_INTERNSHIPS_FIELDS[1]);
        for (int i = 2; i < T_INTERNSHIPS_FIELDS.length; i++) {
            addInternship.append(",");
            addInternship.append(T_INTERNSHIPS_FIELDS[i]);
        }
        addInternship.append(") VALUES ");
        addInternship.append("( ? , ? , ? , ? , ? , ? , NULL , false)");

        boolean res = false;
        try {
            //prepare the request
            PreparedStatement ps = this.conn.prepareStatement(addInternship.toString());
            ps.setString(1, postDate);
            ps.setInt(2, salary);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, personInCharge);
            ps.setString(6, phoneNumber);

            //execute it
            res = (ps.executeUpdate() >= 0);

        } catch (Exception ex) {
            G_Log.e(this.getClass().getName(), "proposeInternship", ex.getMessage());
        }
        return res;

    }

    @Override
    public boolean deleteProposedInternship(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<InternshipProposal> listProposedInternships() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InternshipProposal getProposedInternship(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> listCandidates(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        DB db = new DB();

        //db.listDB();
        System.out.print("delete Candidate Application :");
        System.out.println(db.deleteCandidateApplication("mabille@etud.insa-toulouse.fr", 2));
        System.out.print("add Candidate Application :");
        System.out.println(db.addCandidateApplication("mabille@etud.insa-toulouse.fr", 2));

        System.out.print("add an Internship :");
        System.out.println(db.proposeInternship("2015-12-23", 1250, 
                "Etude de procédures MAC adaptées aux communications M2M dans un système satellite.",
                "Compréhension du sujet et Etat de l’art (environ 1mois)\n"
                        + "Implantation de la procédure dans un simulateur/émulateur qui a été précédemment développé à l’intérieur du département, en y apportant les modifications nécessaires  (environ 2-3 mois).\n"
                        + "Mise en place de scénario et test de la procédure (environ 1 mois). Une fois l’implantation effectuée, des scénarios représentatifs seront joués afin de vérifier le bon fonctionnement  de la procédure. (1 à 2 mois).\n",
                "Fred M", "0612558709"));

        db.closeConnection();
    }
}
