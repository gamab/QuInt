/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package databaseApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sopcov.mail.MailSender;

/**
 *
 * @author root
 */
public class DB implements DBInterface {

    // JDBC conducteur prenom and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/quint";
    // Database credentials
    static final String USER = "prog";
    static final String PASS = "prog";

    static final String TABLE_UTILISATEURS = "user";
    static final String TABLE_STUDENT = "student";
    static final String TABLE_VISITES = "visites";
    static final String TABLE_MESSAGES = "usermessage";

    Connection conn = null;
    Statement stmt = null;

    Connection connTravail = null;
    Statement stmtTravail = null;

    public DB() {
        connect();
    }

    @Override
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

    @Override
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
    public void listData() {

        String sql;

        //sql = "SELECT email,admin, prenom, nom,password FROM utilisateurs";
        sql = "SELECT email,admin, prenom, nom,password FROM " + TABLE_STUDENT;

        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            System.out.println("+++++++++++++++++++++++++++User DB+++++++++++++++++++++++++++++++\n");
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column prenom
                String email = rs.getString("email");
                int age = rs.getInt("admin");
                String first = rs.getString("prenom");
                String last = rs.getString("nom");
                String password = rs.getString("password");
                //Display values
                System.out.print("email: " + email);
                System.out.print("\t| admin: " + age);
                System.out.print("\t| prenom: " + first);
                System.out.print("\t| nom: " + last);
                System.out.println("\t| Password: " + password);
            }
            System.out.println("\n+++++++++++++++++++++++++++END+++++++++++++++++++++++++++++++");
            //Display values
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Student getStudent(String email) {
        Student info = null;

        ResultSet rs;
        try {

            String sql = "SELECT * FROM " + TABLE_STUDENT + " Where email='" + email + "'";

            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                //Retrieve by column prenom

                String password = "";
                int admin = rs.getInt("admin");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String tel = rs.getString("tel");
                String adresse = rs.getString("adresse");
                String commune = rs.getString("commune");
                String cv = rs.getString("cv");
                String lm = rs.getString("lm");
                int code_postal = rs.getInt("code_postal");
                int conducteur = rs.getInt("conducteur");
                String classe = rs.getString("classe");
                String departement = rs.getString("departement");
                String dispoDebut = rs.getString("dispoDebut");
                String dispoFin = rs.getString("dispoFin");

                //Display values
                info = new Student(email, password, admin, prenom, nom, tel, adresse, commune, cv, lm, code_postal, conducteur, classe, departement, dispoDebut, dispoFin);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;

    }

    @Override
    public int addNewUser(String email, String password, int admin, String prenom, String nom, String tel, String adresse, String commune, String cv, String lm, int code_postal, int conducteur, String classe, String departement, String dispoDebut, String dispoFin) {

        if (!isUserInDB(email)) {
            try {

//                String queryCreeUtilisateur = " INSERT INTO `" + TABLE_STUDENT + "` (`password`,`email`,`admin`)VALUES (";
//
//                queryCreeUtilisateur += "'" + password + "','" + email + "',";
//                queryCreeUtilisateur += "" + admin + ");";
//
//                System.out.println("In DB - addNewUser : query : " + queryCreeUtilisateur);
//                int rs = stmt.executeUpdate(queryCreeUtilisateur);
                String queryCreeStudent = " INSERT INTO " + TABLE_STUDENT
                        + " (`cv`,`lm`,`tel`, `admin` ,`prenom` ,`nom` ,`password`"
                        + ",`email` ,`adresse` ,`commune` ,`code_postal` ,`conducteur` ,`classe`,"
                        + "`departement`,`dispoDebut`,`dispoFin`)VALUES (";

                queryCreeStudent += "'" + cv + "','" + lm + "',";
                queryCreeStudent += "'" + tel + "','" + admin + "',";
                queryCreeStudent += "'" + prenom + "','" + nom + "',";
                queryCreeStudent += "'" + password + "','" + email + "',";
                queryCreeStudent += "'" + adresse + "','" + commune + "',";
                queryCreeStudent += "'" + code_postal + "','" + conducteur + "',";
                queryCreeStudent += "'" + classe + "','" + departement + "',";
                queryCreeStudent += "'" + dispoDebut + "','" + dispoFin + "');";

                System.out.println("In DB - addNewUser : query : " + queryCreeStudent);

                //System.out.println(query);
                int rs1 = stmt.executeUpdate(queryCreeStudent);

                // envoie des mails en fonction des modification apporté par le nouveau user :
//            notifyUsers(email, true);
            } catch (Exception ex) {
                System.err.println("In DB - addNewUser : n'a pas pu créer l'utilisateur : " + ex.getLocalizedMessage());
                return -3;
            }
        } else {
            System.out.println("ALREADY EXISTS");
            return -1;

        }
        return 0;
    }

    @Override
    public void deleteUser(String email) {

        String deleteVisiteQuery = "DELETE FROM " + TABLE_VISITES + " WHERE email_visiteur='" + email + "'";
        String deleteUserQuery = "DELETE FROM " + TABLE_UTILISATEURS + " WHERE email='" + email + "'";

        // on notifie avant la deletion car sinon on ne trouve plus les info nécessaire
        int rs = 0;

        try {
            //suppression des visites de l'user
            rs = stmt.executeUpdate(deleteVisiteQuery);
        } catch (Exception ex) {
            System.err.println("could not delete visites :" + ex);

        }

        try {
            //suppression de l'user
            rs = stmt.executeUpdate(deleteUserQuery);
        } catch (Exception ex) {
            System.err.println("could not delete user :" + ex);

        }

    }

    @Override
    public String getPassword(String email) {
        String pass = "";

        String sql;

        sql = "SELECT password FROM " + TABLE_UTILISATEURS + " WHERE email='" + email + "'";

        //System.out.println(sql);
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            rs.next();
            pass = rs.getString("password");
            rs.close();

        } catch (Exception e) {
            // Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, e);
        }

        return pass;
    }

    @Override
    public void setAdminRight(String email, String admin) {
        int adminRight;

        if (admin != null) {
            adminRight = 1;
        } else {
            adminRight = 0;
        }

        String sql = "UPDATE " + TABLE_UTILISATEURS + " SET admin='" + adminRight + "' WHERE email='" + email + "'";
        try {
            int rs = stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.err.println("IN dDB - setAdminRight - could not do the query error :" + e);
        }
    }

    @Override
    public void setPassword(String email, String password) {

        String sql;

        sql = "UPDATE " + TABLE_UTILISATEURS + " SET password='" + password + "' WHERE email='" + email + "'";

        //  System.out.println(sql);
        int rs;
        try {
            rs = stmt.executeUpdate(sql);

        } catch (Exception e) {
            // Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void editUserProfile(String email, String nom, String prenom, String adresse,
            String tel, String commune, String code_postal, String conducteur,
            String classe, String departement, String dispoDebut, String dispoFin) {

        // récupération des bonnes valeurs par rapport à la DB : string -> int ...
        // cas des boolean
        int valConducteur;
        int valNotif;

        if (conducteur != null) {
            valConducteur = 1;
        } else {
            valConducteur = 0;
        }

        // on fait nos changement
        String sqlUpdate;

        sqlUpdate = "UPDATE " + TABLE_UTILISATEURS + " SET "
                + "nom='" + nom + "' , "
                + "prenom='" + prenom + "' , "
                + "adresse='" + adresse + "' , "
                + "tel='" + tel + "' , "
                + "commune='" + commune + "' , "
                + "code_postal='" + code_postal + "' , "
                + "conducteur='" + valConducteur + "' , "
                + "WHERE email='" + email + "'";

        int rs;
        try {
            rs = stmt.executeUpdate(sqlUpdate);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean emailAlreadyUsed(String email) {
        boolean emailAlreadyUsed = false;

        String sql;
        sql = "SELECT email FROM " + TABLE_UTILISATEURS + " WHERE email='" + email + "'";
        ResultSet rs;

        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                emailAlreadyUsed = true;
            }
            rs.close();

        } catch (SQLException e) {
            System.err.println("In DB - emailAlreadyUsed : N'a pas pu voir si l'utilisateur existait ou non : " + e.getLocalizedMessage());
        }
        return emailAlreadyUsed;
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    public boolean isUSerAdmin(String email) {
        boolean isAdmin = false;

        String sql;
        sql = "SELECT admin FROM " + TABLE_UTILISATEURS + " WHERE email='" + email + "'";
        ResultSet rs;

        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (rs.getInt("admin") == 1) {
                    isAdmin = true;
                }

            }
            rs.close();

        } catch (SQLException e) {
            return false;
            //System.err.println("In DB - emailAlreadyUsed : N'a pas pu voir si l'utilisateur existait ou non : " + e.getLocalizedMessage());
        }
        return isAdmin;
    }

    @Override
    public void rememberUserLogIn(String email) {
        String sql;
        sql = "INSERT INTO " + TABLE_VISITES + " (`email_visiteur`,`date`) VALUES ";
        sql += "(\"" + email + "\",NOW())";

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("In DB - rememberUserLogIn : N'a pas pu enregistrer que l'utilisateur s'est loggé."
                    + " Erreur : " + ex.getLocalizedMessage());
        }
    }

    @Override
    public boolean userPasswordMatch(String email, String password) {
        boolean userExists = false;

        String sql;
        sql = "SELECT email,password FROM " + TABLE_UTILISATEURS + " WHERE email='" + email + "' AND password='" + password + "'";
        // System.out.println(sql);
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                userExists = true;
            }
            rs.close();

        } catch (Exception e) {
            // Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return userExists;
    }

    @Override
    public boolean isUserInDB(String email) {
        boolean isUserInDB = false;

        String sql;
        sql = "SELECT email FROM " + TABLE_STUDENT + " WHERE email='" + email + "'";
        System.out.println(sql);
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                isUserInDB = true;
            }
            rs.close();

        } catch (Exception e) {
            System.err.println("In DB - isUserExist - could not query error : " + e);
        }
        return isUserInDB;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql_lieu = "SELECT * FROM " + TABLE_STUDENT;
        System.out.println(sql_lieu);

        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql_lieu);
            while (rs.next()) {
                System.out.println("ok");
                //Retrieve by column prenom
                int admin = rs.getInt("admin");
                int conducteur = rs.getInt("conducteur");
                //int notif = rs.getInt("notif");
                String tel = rs.getString("tel");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String commune = rs.getString("commune");
                int code_postal = rs.getInt("code_postal");

                //Display values
                students.add(new Student(email, "", admin, prenom, nom, tel, adresse,
                        commune, "", "", code_postal, conducteur,
                        "", "", "", ""));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (students.isEmpty()) {
            System.out.println("empty list");
        } else {

            System.out.println("Not empty");
        }
        return students;
    }

    @Override
    public List<Student> searchStudent(String prenom, String nom) {
        List<Student> students = new ArrayList<>();

        ResultSet rs;
        try {

            String sql = "SELECT * FROM " + TABLE_STUDENT + " Where prenom='" + prenom + "' and nom='" + nom + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column prenom

                int admin = rs.getInt("admin");
                int conducteur = rs.getInt("conducteur");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String commune = rs.getString("commune");
                int code_postal = rs.getInt("code_postal");

                //Display values
                students.add(new Student(email, "", admin, prenom, nom, tel, adresse,
                        commune, "", "", code_postal, conducteur,
                        "", "", "", ""));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int getNumberOfUsers() {
        int utilisateurs = 0;

        String sql = "SELECT COUNT(email) AS nombre_utilisateurs FROM " + TABLE_UTILISATEURS;
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                utilisateurs = rs.getInt("nombre_utilisateurs");
            }
        } catch (SQLException ex) {
            System.err.println("In DB - getNumbersOfUsers : pas pu lire les résultats de la requete " + sql + "\nerreur : " + ex.getLocalizedMessage());
            utilisateurs = -1;
        }

        return utilisateurs;
    }

    @Override
    public ArrayList<Msg> getAllMessagesForUser(String email) {
        ArrayList<Msg> messages = new ArrayList<>();
        // on récupère les info du lieu de travail
        String sqlLieuTravail = "SELECT * From " + TABLE_MESSAGES + " Where email='" + email + "';";
        ResultSet rs;

        try {
            rs = stmt.executeQuery(sqlLieuTravail);

            // on place nos resultats dans notre list final
            while (rs.next()) {
                messages.add(new Msg(rs.getString("email"), rs.getString("from"), rs.getString("to"), rs.getString("msg")));
            }

        } catch (Exception ex) {
            System.err.println("In DB - getAllMessages : could not process query, error :" + ex);
        }
        return messages;
    }

    @Override
    public int insertMessage(String email, String from, String to, String msg) {

        if (isUserInDB(email)) {
            try {

                String queryCreeUtilisateur = " INSERT INTO `" + TABLE_MESSAGES + "` (`email`,`from`,`to`,`msg`)VALUES (";

                queryCreeUtilisateur += "'" + email + "','" + from + "',";
                queryCreeUtilisateur += "'" + to + "','" + msg + "')";

                System.out.println("In DB - addNewUser : query : " + queryCreeUtilisateur);
                int rs = stmt.executeUpdate(queryCreeUtilisateur);

                // envoie des mails en fonction des modification apporté par le nouveau user :
//            notifyUsers(email, true);
            } catch (Exception ex) {
                System.err.println("In DB - addNewUser : n'a pas pu créer l'utilisateur : " + ex.getLocalizedMessage());
                return -3;
            }
        } else {
            System.out.println("ALREADY EXISTS");
            return -1;

        }
        return 0;
    }

}
