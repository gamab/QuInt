/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import logger.G_Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    static final String[] T_INTERNSHIPS_FIELDS = {"id", "post_date", "salary", "title", "description", "person_in_charge", "phone_number", "department", "location", "selected_candidate", "provided"};

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
    public boolean proposeInternship(String postDate, int salary, String title, String description, String personInCharge, String phoneNumber, String department, String location) {
        //Prepare the sql request to add an internship to the internships table
        StringBuilder addInternship = new StringBuilder();
        addInternship.append("INSERT INTO " + T_INTERNSHIPS + " (");
        addInternship.append(T_INTERNSHIPS_FIELDS[1]);
        for (int i = 2; i < T_INTERNSHIPS_FIELDS.length; i++) {
            addInternship.append(",");
            addInternship.append(T_INTERNSHIPS_FIELDS[i]);
        }
        addInternship.append(") VALUES ");
        addInternship.append("( ? , ? , ? , ? , ? , ? , ?, ?, NULL , false)");

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
            ps.setString(7, department);
            ps.setString(8, location);

            //execute it
            res = (ps.executeUpdate() >= 0);

        } catch (Exception ex) {
            G_Log.e(this.getClass().getName(), "proposeInternship", ex.getMessage());
        }
        return res;

    }

    @Override
    public boolean deleteProposedInternship(int id) {
        String deleteProposedInternship = "DELETE FROM " + T_INTERNSHIPS
                + " WHERE " + T_INTERNSHIPS_FIELDS[0] + "= ?";

        boolean res = false;

        try {
            //prepare the request
            PreparedStatement ps = this.conn.prepareStatement(deleteProposedInternship);
            ps.setInt(1, id);

            //execute it
            res = (ps.executeUpdate() >= 0);

        } catch (Exception ex) {
            G_Log.e(this.getClass().getName(), "deleteProposedInternship", ex.getMessage());
        }
        return res;
    }

    @Override
    public ArrayList<InternshipProposal> listProposedInternships() {
        String getEveryInternships = "SELECT * FROM " + T_INTERNSHIPS;

        ArrayList<InternshipProposal> res = new ArrayList<>();

        try {
            ResultSet rs = this.stmt.executeQuery(getEveryInternships);
            while (rs.next()) {
                int id = rs.getInt(T_INTERNSHIPS_FIELDS[0]);
                String postDate = rs.getString(T_INTERNSHIPS_FIELDS[1]);
                int salary = rs.getInt(T_INTERNSHIPS_FIELDS[2]);
                String title = rs.getString(T_INTERNSHIPS_FIELDS[3]);
                String description = rs.getString(T_INTERNSHIPS_FIELDS[4]);
                String personInCharge = rs.getString(T_INTERNSHIPS_FIELDS[5]);
                String phoneNumber = rs.getString(T_INTERNSHIPS_FIELDS[6]);
                String department = rs.getString(T_INTERNSHIPS_FIELDS[7]);
                String location = rs.getString(T_INTERNSHIPS_FIELDS[8]);
                String selectedCandidate = rs.getString(T_INTERNSHIPS_FIELDS[9]);
                boolean provided = rs.getBoolean(T_INTERNSHIPS_FIELDS[10]);

                res.add(new InternshipProposal(id, postDate, salary, title, description, personInCharge, phoneNumber, department, location, selectedCandidate, provided));
            }

        } catch (SQLException ex) {
            G_Log.e(this.getClass().getName(), "listProposedInternships", ex.getMessage());
        }

        return res;
    }

    @Override
    public ArrayList<InternshipProposal> listProposedInternshipsFiltered(String date, String department, String location) {
        boolean departProvided = (department != null) && !(department.isEmpty());
        boolean locationProvided = (location != null) && !(location.isEmpty());
        boolean dateProvided = (date != null) && !(date.isEmpty());

        ArrayList<InternshipProposal> res = new ArrayList<>();
        String getEveryInternships = "SELECT * FROM " + T_INTERNSHIPS;
        PreparedStatement ps;

        try {
            if (departProvided && locationProvided && dateProvided) {
                getEveryInternships += " WHERE " + T_INTERNSHIPS_FIELDS[7] + " = ?"
                        + " AND " + T_INTERNSHIPS_FIELDS[8] + " = ?"
                        + " AND " + T_INTERNSHIPS_FIELDS[1] + " >= ?";
                ps = this.conn.prepareStatement(getEveryInternships);
                ps.setString(1, department);
                ps.setString(2, location);
                ps.setString(3, date);
            } else if (departProvided && dateProvided) {
                getEveryInternships += " WHERE " + T_INTERNSHIPS_FIELDS[7] + " = ?"
                        + " AND " + T_INTERNSHIPS_FIELDS[1] + " >= ?";
                ps = this.conn.prepareStatement(getEveryInternships);
                ps.setString(1, department);
                ps.setString(2, date);
            } else if (locationProvided && dateProvided) {
                getEveryInternships += " WHERE " + T_INTERNSHIPS_FIELDS[8] + " = ?"
                        + " AND " + T_INTERNSHIPS_FIELDS[1] + " >= ?";
                ps = this.conn.prepareStatement(getEveryInternships);
                ps.setString(1, location);
                ps.setString(2, date);
            } else if (departProvided && locationProvided) {
                getEveryInternships += " WHERE " + T_INTERNSHIPS_FIELDS[7] + " = ?"
                        + " AND " + T_INTERNSHIPS_FIELDS[8] + " = ?";
                ps = this.conn.prepareStatement(getEveryInternships);
                ps.setString(1, department);
                ps.setString(2, location);
            } else if (departProvided) {
                getEveryInternships += " WHERE " + T_INTERNSHIPS_FIELDS[7] + " = ?";
                ps = this.conn.prepareStatement(getEveryInternships);
                ps.setString(1, department);
            } else if (locationProvided) {
                getEveryInternships += " WHERE " + T_INTERNSHIPS_FIELDS[8] + " = ?";
                ps = this.conn.prepareStatement(getEveryInternships);
                ps.setString(1, location);
            } else if (dateProvided) {
                getEveryInternships += " WHERE " + T_INTERNSHIPS_FIELDS[1] + " >= ?";
                ps = this.conn.prepareStatement(getEveryInternships);
                ps.setString(1, date);
            } else {
                ps = this.conn.prepareStatement(getEveryInternships);
            }

            res = this.listProposedInternshipsExecute(ps);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    private ArrayList<InternshipProposal> listProposedInternshipsExecute(PreparedStatement ps) {
        ArrayList<InternshipProposal> res = new ArrayList<>();

        try {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(T_INTERNSHIPS_FIELDS[0]);
                String postDate = rs.getString(T_INTERNSHIPS_FIELDS[1]);
                int salary = rs.getInt(T_INTERNSHIPS_FIELDS[2]);
                String title = rs.getString(T_INTERNSHIPS_FIELDS[3]);
                String description = rs.getString(T_INTERNSHIPS_FIELDS[4]);
                String personInCharge = rs.getString(T_INTERNSHIPS_FIELDS[5]);
                String phoneNumber = rs.getString(T_INTERNSHIPS_FIELDS[6]);
                String department2 = rs.getString(T_INTERNSHIPS_FIELDS[7]);
                String location2 = rs.getString(T_INTERNSHIPS_FIELDS[8]);
                String selectedCandidate = rs.getString(T_INTERNSHIPS_FIELDS[9]);
                boolean provided = rs.getBoolean(T_INTERNSHIPS_FIELDS[10]);

                res.add(new InternshipProposal(id, postDate, salary, title, description, personInCharge, phoneNumber, department2, location2, selectedCandidate, provided));
            }

        } catch (SQLException ex) {
            G_Log.e(this.getClass().getName(), "listProposedInternships", ex.getMessage());
        }

        return res;
    }

    @Override
    public InternshipProposal getProposedInternship(int id) {
        String getInternship = "SELECT * FROM " + T_INTERNSHIPS;

        InternshipProposal res = null;

        try {
            ResultSet rs = this.stmt.executeQuery(getInternship);
            if (rs.next()) {
                String postDate = rs.getString(T_INTERNSHIPS_FIELDS[1]);
                int salary = rs.getInt(T_INTERNSHIPS_FIELDS[2]);
                String title = rs.getString(T_INTERNSHIPS_FIELDS[3]);
                String description = rs.getString(T_INTERNSHIPS_FIELDS[4]);
                String personInCharge = rs.getString(T_INTERNSHIPS_FIELDS[5]);
                String phoneNumber = rs.getString(T_INTERNSHIPS_FIELDS[6]);
                String department = rs.getString(T_INTERNSHIPS_FIELDS[7]);
                String location = rs.getString(T_INTERNSHIPS_FIELDS[8]);
                String selectedCandidate = rs.getString(T_INTERNSHIPS_FIELDS[9]);
                boolean provided = rs.getBoolean(T_INTERNSHIPS_FIELDS[10]);

                res = new InternshipProposal(id, postDate, salary, title, description, personInCharge, phoneNumber, department, location, selectedCandidate, provided);
            }

        } catch (SQLException ex) {
            G_Log.e(this.getClass().getName(), "getProposedInternship", ex.getMessage());
        }

        return res;
    }

    @Override
    public ArrayList<String> listCandidates(int id) {
        String listCand = "SELECT " + T_CANDIDATES_FIELDS[0] + " FROM " + T_CANDIDATES + " WHERE " + T_CANDIDATES_FIELDS[1] + " = " + id;

        ArrayList<String> res = new ArrayList<>();

        try {
            ResultSet rs = this.stmt.executeQuery(listCand);
            while (rs.next()) {
                res.add(rs.getString(T_CANDIDATES_FIELDS[0]));
            }

        } catch (SQLException ex) {
            G_Log.e(this.getClass().getName(), "getProposedInternship", ex.getMessage());
        }
        return res;
    }

    public static void main(String[] args) {
        DB db = new DB();
        ArrayList<InternshipProposal> intProps;

        //db.listDB();
        //System.out.print("delete Candidate Application :");
        //System.out.println(db.deleteCandidateApplication("mabille@etud.insa-toulouse.fr", 2));
        //System.out.print("add Candidate Application :");
        //System.out.println(db.addCandidateApplication("mabille@etud.insa-toulouse.fr", 2));
        /*System.out.print("add an Internship :");
         System.out.println(db.proposeInternship("2015-12-23", 1250,
         "Etude de procédures MAC adaptées aux communications M2M dans un système satellite.",
         "Compréhension du sujet et Etat de l’art (environ 1mois)\n"
         + "Implantation de la procédure dans un simulateur/émulateur qui a été précédemment développé à l’intérieur du département, en y apportant les modifications nécessaires  (environ 2-3 mois).\n"
         + "Mise en place de scénario et test de la procédure (environ 1 mois). Une fois l’implantation effectuée, des scénarios représentatifs seront joués afin de vérifier le bon fonctionnement  de la procédure. (1 à 2 mois).\n",
         "Fred M", "0612558709", "GEI", "31100"));*/
        //System.out.print("delete an Internship :");
        //System.out.println(db.deleteProposedInternship(3));
        /*
         System.out.println("List proposed internships :");
         ArrayList<InternshipProposal> intProps = db.listProposedInternships();
         for (InternshipProposal intProp : intProps) {
         System.out.println(intProp.toString());
         }
         */
        //System.out.println("get a given internships :");
        //System.out.println(db.getProposedInternship(1));
        /*System.out.println("list candidates for a given internship :");
         for (String id : db.listCandidates(1)) {
         System.out.println(id);
         }*/
        /*System.out.println("List proposed internships in 31400 :");
         intProps = db.listProposedInternshipsFiltered("","","31400");
         for (InternshipProposal intProp : intProps) {
         System.out.println(intProp.toString());
         }*/
        /*System.out.println("List proposed internships for GEI :");
         intProps = db.listProposedInternshipsFiltered("","GEI","");
         for (InternshipProposal intProp : intProps) {
         System.out.println(intProp.toString());
         }*/
        /*System.out.println("List proposed internships after the 1rst of december :");
         intProps = db.listProposedInternshipsFiltered("2015-12-01","","");
         for (InternshipProposal intProp : intProps) {
         System.out.println(intProp.toString());
         }*/
        /*System.out.println("List proposed internships for GEI in 31400 :");
         intProps = db.listProposedInternshipsFiltered("","GEI", "31400");
         for (InternshipProposal intProp : intProps) {
         System.out.println(intProp.toString());
         }*/
        /*System.out.println("List proposed internships for GEI after the 1rst of december :");
         intProps = db.listProposedInternshipsFiltered("2015-12-01","GEI", "");
         for (InternshipProposal intProp : intProps) {
         System.out.println(intProp.toString());
         }*/
        /*System.out.println("List proposed internships in 31700 after the 1rst of december :");
         intProps = db.listProposedInternshipsFiltered("2015-12-01","", "31700");
         for (InternshipProposal intProp : intProps) {
         System.out.println(intProp.toString());
         }*/
        /*System.out.println("List proposed internships for GEI after the 1rst of december in 31100 :");
        intProps = db.listProposedInternshipsFiltered("2015-12-01", "GEI", "31100");
        for (InternshipProposal intProp : intProps) {
            System.out.println(intProp.toString());
        }*/
        /*System.out.println("List proposed internships without specifying any filter :");
        intProps = db.listProposedInternshipsFiltered("", "", "");
        for (InternshipProposal intProp : intProps) {
            System.out.println(intProp.toString());
        }*/
        db.closeConnection();
    }
}
