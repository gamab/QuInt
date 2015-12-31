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

        DB dbHelper = new DB();

        dbHelper.listData();
        System.out.println("Password is : "+ dbHelper.getPassword("ghader"));

        dbHelper.addNewUser(false, "Omar", "GHADER", "123", "07********", "ghader@etud.insa-toulouse.fr", "135", "Toulouse", "31400", true, true);
        dbHelper.listData();
        String password = dbHelper.getPassword("ghader@etud.insa-toulouse.fr");
        System.out.println("Password is " + password);
        System.out.println(dbHelper.getAllStudents());

        System.out.println(dbHelper.searchStudent("Omar", "GHADER"));


        dbHelper.closeConnection();
    }//end main

}
