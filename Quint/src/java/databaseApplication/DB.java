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

    public void notifyUsers(String email, boolean isAdded) {

        // on récupère les info qui sont utiles : la commune et le lieu de travail pour trouver le trajet
        // mais aussi si le user est conducteur , (si non alors il n'apporte rien de plus)
        String query = "SELECT conducteur,code_postal,lieu_travail_id FROM " + TABLE_UTILISATEURS + " WHERE email='" + email + "'";
        ResultSet rs;
        int conducteur = 0;
        int id_lieu_travail = 0;
        int code_postal = 0;

        try {
            // récupération des valeurs
            rs = stmt.executeQuery(query);
            rs.next();
            conducteur = rs.getInt("conducteur");
            code_postal = rs.getInt("code_postal");
            id_lieu_travail = rs.getInt("lieu_travail_id");

        } catch (Exception e) {
            System.err.println("In DB  - notify users: could not send the query 1 : error " + e);
        }

        //si le user est un conducteur on envoit les messages nécessaires
        if (conducteur == 1) {
            String nomLieuTravail = "";
            // on cherche le nom du lieu de travail (on a que sont id)
            String queryLieuTravail = "SELECT nom_lieu FROM " + TABLE_STUDENT + " WHERE id=" + id_lieu_travail;

            try {
                rs = stmt.executeQuery(queryLieuTravail);
                rs.next();
                nomLieuTravail = rs.getString("nom_lieu");
            } catch (Exception e) {
                System.err.println("In DB  - notify users: could not send the query 2 : error " + e);
            }

//            MailSender mailSender = new MailSender();
            // on choisit la notification en fonction de si le user à été rajouté ou supprimé
//            mailSender.setEmailText(isAdded);
//            mailSender.setList(getEmailToBeNotified(code_postal,nomLieuTravail));
//            mailSender.start();
        }

    }

    @Override
    public Student queryInfo(String email) {
        Student info = null;

        String sql_lieu = "SELECT * FROM " + TABLE_STUDENT;

        ResultSet rs;
        try {

            rs = stmt.executeQuery(sql_lieu);
            rs.next();
            String lieu_travail = rs.getString("nom_lieu");
            String lieu_travail_adresse = rs.getString("adresse");
            String sql = "SELECT * FROM " + TABLE_UTILISATEURS + " Where email='" + email + "'";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column prenom

                int admin = rs.getInt("admin");
                int conducteur = rs.getInt("conducteur");
                int notif = rs.getInt("notif");
                String tel = rs.getString("tel");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                //String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String commune = rs.getString("commune");
                String heure_depart = rs.getString("heure_depart");
                String heure_retour = rs.getString("heure_retour");
                int code_postal = rs.getInt("code_postal");
                int lieu_travail_id = rs.getInt("lieu_travail_id");
                String jours_travail = rs.getString("jours_travail");
                //Display values

//                info = new Student(email, "", admin, prenom, nom, tel, adresse, commune, code_postal, lieu_travail, lieu_travail_id, heure_depart, heure_retour, jours_travail, conducteur, notif, lieu_travail_adresse);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return info;

    }

    @Override
    public int addNewUser(boolean admin, String prenom, String nom, String password, String tel, String email, String adresse, String commune, String codePostal, boolean conducteur, boolean notif) {
        int adminConv = (admin) ? 1 : 0;
        int conducteurConv = (conducteur) ? 1 : 0;
        int notifConv = (notif) ? 1 : 0;
        String cv = "";
        String lm = "";
        if (!isUserInDB(email)) {
            try {

                String queryCreeUtilisateur = " INSERT INTO `" + TABLE_UTILISATEURS + "` (`password`,`email`,`admin`)VALUES (";

                queryCreeUtilisateur += "'" + password + "','" + email + "',";
                queryCreeUtilisateur += "" + admin + ");";

                System.out.println("In DB - addNewUser : query : " + queryCreeUtilisateur);
                int rs = stmt.executeUpdate(queryCreeUtilisateur);

                String queryCreeStudent = " INSERT INTO " + TABLE_STUDENT + " (`cv`,`lm`,`tel`, `admin` ,`prenom` ,`nom` ,`password` ,`email` ,`adresse` ,`commune` ,`code_postal` ,`conducteur` ,`notif`)VALUES (";

                //query += "'"+id + "','" +admin+"',";
                queryCreeStudent += "'" + cv + "','" + lm + "',";
                queryCreeStudent += "'" + tel + "','" + adminConv + "',";
                queryCreeStudent += "'" + prenom + "','" + nom + "',";
                queryCreeStudent += "'" + password + "','" + email + "',";
                queryCreeStudent += "'" + adresse + "','" + commune + "',";
                queryCreeStudent += "'" + codePostal + "','" + conducteurConv + "',";
                queryCreeStudent += "'" + notifConv + "');";

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
        notifyUsers(email, false);
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
            String tel, String commune, String code_postal, String conducteur, String notif) {

        // récupération des bonnes valeurs par rapport à la DB : string -> int ...
        // cas des boolean
        int valConducteur;
        int valNotif;

        if (conducteur != null) {
            valConducteur = 1;
        } else {
            valConducteur = 0;
        }

        if (notif != null) {
            valNotif = 1;
        } else {
            valNotif = 0;
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
                + "notif='" + valNotif + "' "
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

    public boolean isUserInDB(String email) {
        boolean isUserInDB = false;

        String sql;
        sql = "SELECT email FROM " + TABLE_UTILISATEURS + " WHERE email='" + email + "'";
        // System.out.println(sql);
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

        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql_lieu);
            while (rs.next()) {
                //Retrieve by column prenom
                int admin = rs.getInt("admin");
                int conducteur = rs.getInt("conducteur");
                int notif = rs.getInt("notif");
                String tel = rs.getString("tel");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String commune = rs.getString("commune");
                int code_postal = rs.getInt("code_postal");

                //Display values
                students.add(new Student(email, "", admin, prenom,
                        nom, tel, adresse, commune,
                        code_postal, "", "", conducteur,
                        notif));
            }

        } catch (Exception e) {

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
                int notif = rs.getInt("notif");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String commune = rs.getString("commune");
                int code_postal = rs.getInt("code_postal");

                //Display values
                students.add(new Student(email, "", admin, prenom, nom, tel, adresse, commune, code_postal, "", "", conducteur, notif));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<String> getEmailToBeNotified(int code_postal, String dest) {
        List<String> resultEnd = new ArrayList<>();
        // on récupère les info du lieu de travail
        String sqlLieuTravail = "SELECT id FROM " + TABLE_STUDENT + " Where nom_lieu='" + dest + "'";
        ResultSet rs;

        try {
            rs = stmt.executeQuery(sqlLieuTravail);
            rs.next();
            //on récupère l'ID du lieu de travail en entée de fonction (dest)
            int lieu_travail_id = rs.getInt("id");

            //on cherche les emails des personnes qui sont sur le trajet (commune->lieu travail)
            String sqlEmail = "SELECT email FROM " + TABLE_UTILISATEURS + " WHERE code_postal='" + code_postal + "' AND lieu_travail_id='" + lieu_travail_id + "' AND notif='1'";
            ResultSet resEmails;
            resEmails = stmt.executeQuery(sqlEmail);

            // on place nos resultats dans notre list final
            while (resEmails.next()) {
                resultEnd.add(resEmails.getString("email"));
            }

        } catch (Exception ex) {
            System.err.println("In DB - getEmailToBeNotified : could not process query, error :" + ex);
        }
        return resultEnd;
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

}
