///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//package database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Observer;
//import java.util.logging.Level;
//import java.util.logging.Logger;
////import sopcov.mail.MailSender;
//
///**
// *
// * @author root
// */
//public class DB implements DBInterface {
//    
//    // JDBC conducteur prenom and database URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/sopcov";
//    // Database credentials
//    static final String USER = "prog";
//    static final String PASS = "prog";
//    
//    static final String TABLE_UTILISATEURS = "utilisateurs";
//    static final String TABLE_LIEUX_TRAVAIL = "lieux_travail";
//    static final String TABLE_VISITES = "visites";
//    
//    Connection conn = null;
//    Statement stmt = null;
//    
//    Connection connTravail = null;
//    Statement stmtTravail = null;
//    
//    
//    
//    public DB() {
//        connect();
//    }
//    
//    @Override
//    public void connect() {
//        try {
//            //STEP 2: Register JDBC conducteur
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            //STEP 3: Open a connection
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //System.out.println("conn= " + 1);
//            stmt = conn.createStatement();
//        } catch (Exception e) {
//            System.err.println("In DB - connect : " + e.getLocalizedMessage());
//            
//        }
//        
//    }
//    
//    @Override
//    public void closeConnection() {
//        try {
//            // rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
//        
//    }
//    
//    @Override
//    public void listData() {
//        
//        String sql;
//        
//        //sql = "SELECT email,admin, prenom, nom,password FROM utilisateurs";
//        sql = "SELECT email,admin, prenom, nom,password FROM " + TABLE_UTILISATEURS;
//        
//        ResultSet rs;
//        try {
//            rs = stmt.executeQuery(sql);
//            System.out.println("+++++++++++++++++++++++++++User DB+++++++++++++++++++++++++++++++\n");
//            //STEP 5: Extract data from result set
//            while (rs.next()) {
//                //Retrieve by column prenom
//                String email = rs.getString("email");
//                int age = rs.getInt("admin");
//                String first = rs.getString("prenom");
//                String last = rs.getString("nom");
//                String password = rs.getString("password");
//                //Display values
//                System.out.print("email: " + email);
//                System.out.print("\t| admin: " + age);
//                System.out.print("\t| prenom: " + first);
//                System.out.print("\t| nom: " + last);
//                System.out.println("\t| Password: " + password);
//            }
//            System.out.println("\n+++++++++++++++++++++++++++END+++++++++++++++++++++++++++++++");
//            //Display values
//            rs.close();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    @Override
//    public void deleteUser(String email) {
//        
//        String deleteVisiteQuery = "DELETE FROM " + TABLE_VISITES + " WHERE email_visiteur='" + email +"'";
//        String deleteUserQuery = "DELETE FROM " + TABLE_UTILISATEURS + " WHERE email='" + email +"'";
//        
//        // on notifie avant la deletion car sinon on ne trouve plus les info nécessaire
//        notifyUsers(email,false);
//        int rs = 0;
//        
//        try {
//           //suppression des visites de l'user
//            rs = stmt.executeUpdate(deleteVisiteQuery);
//       } catch (Exception ex) {
//            System.err.println("could not delete visites :"+ ex);
//            
//        }
//        
//        try{
//         //suppression de l'user
//            rs = stmt.executeUpdate(deleteUserQuery);
//        } catch (Exception ex) {
//            System.err.println("could not delete user :" + ex);
//            
//        }
//    }
//    