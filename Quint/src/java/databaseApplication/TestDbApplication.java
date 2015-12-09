/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseApplication;

/**
 *
 * @author omar
 */
public class TestDbApplication {

    public static void main(String[] args) {
        //testGetNumberOfConnectionBetween();
        //testGetAllNumberOfUserByCoupleCommuneAndWorkplace();
        //testGetNumberOfUserForCoupleCommuneAndWorkplace();
//        testGetPercentOfDrivers();
//        testGetNumberOfDrivers();
//        testGetNumberOfNonDrivers();
//        testGetNumberOfUsers();
        DB dbHelper = new DB();

        dbHelper.listData();
        System.out.println(dbHelper.getPassword("ghader"));
        if (dbHelper.userExists("ghader@etud", "123")) {
            System.out.println("ALREADY CREATEEEEEEEEEEEEED");
        } else {
            dbHelper.addNewUser(true, "O", "G", "123", "07********", "ghader@etud", "135", "Toulouse", "31400", true, true);

        }
        dbHelper.listData();

        // dbHelper.
        // String password = dbHelper.getPassword("simpleuser@test.com");
        // System.out.println("Password is " + password);
        //dbHelper.setPassword("adminuser@test.com","adminuser");
        //dbHelper.editLocation("ghader@etud.insa-toulouse.fr", "Balma");
        //System.out.println(dbHelper.userExists("adminuser@test.com", "adminuser"));
        //dbHelper.addNewUser(false, "omar", "ghader", "pass", "07", "omar@insa.fr", "135 avenue de Rangueil", "Labege", "31400", "Sopra_Group_Ent1", "08:00", "17:00", "L,M,M,J,V", true, true);
//        dbHelper.deleteUser("omar@insa.fr");
//        dbHelper.deleteUser("oma@insa.fr");
        //dbHelper.addNewUser(true, DB_URL, USER, DB_URL, USER, USER, DB_URL, DB_URL, PASS, TABLE_VISITES, JDBC_DRIVER, DB_URL, JDBC_DRIVER, true, true)
        //System.out.println(dbHelper.searchRoute("Toulouse", "Sopra_Group_Ent2").toString());
        //dbHelper.editWorkLocation(1, "Sopra_Group_Ent1", "37 Chemin des Ramassier", "Colomiers", "31770");
        //dbHelper.deleteWorkLocation(1, "Sopra_Group_Ent1");
        //System.out.println(dbHelper.getAllCommunes().toString());
//        dbHelper.listData();
//        dbHelper.closeConnection();
    }//end main

}
