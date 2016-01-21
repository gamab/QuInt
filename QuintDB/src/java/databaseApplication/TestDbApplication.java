/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseApplication;
//
//import controller.CorporationWS;

import databaseapplication.DbWebService_Service;

//import controller.CorporationWS_Service;
//import databaseapplication.DbWebService_Service;
/**
 *
 * @author omar
 */
public class TestDbApplication {

    public static void main(String[] args) {

        DB dbHelper = new DB();

//        System.out.println(dbHelper.getStudent("ghader@etud.insa-toulouse.fr"));
//        dbHelper.addNewUser("ghader@etud.insa-toulouse.fr", "123", 0,
//                "Omar", "GHADER", "07********  ", "135", 
//                "Toulouse","","", 31400, 0,
//                "4A", "GEI", "1/1/2016", "1/10/2016");
        
//        dbHelper.insertMessage("ghader@etud.insa-toulouse.fr", "Omar", "Gabriel", "Hello");
//        System.out.println(dbHelper.getAllMessagesForUser("ghader@etud.insa-toulouse.fr").get(1).getMsg());

        dbHelper.closeConnection();

//        dbHelper.listData();
//        System.out.println("Password is : "+ dbHelper.getPassword("ghader"));
//
//        dbHelper.addNewUser(false, "Omar", "GHADER", "123", "07********", "ghader@etud.insa-toulouse.fr", "135", "Toulouse", "31400", true, true);
//        dbHelper.listData();
//        String password = dbHelper.getPassword("ghader@etud.insa-toulouse.fr");
//        System.out.println("Password is " + password);
//        System.out.println(dbHelper.getAllStudents());
//
//        System.out.println(dbHelper.searchStudent("Omar", "GHADER"));
//
//
//        dbHelper.closeConnection();
//        
//         DbWebService_Service helloWorldService = new DbWebService_Service();
//         databaseapplication.DbWebService db=helloWorldService.getDbWebServicePort();
//         System.out.println( db.getAllStudents());
//         
//         CorporationWS_Service corporationWS_Service=new CorporationWS_Service();
//         CorporationWS corporationWS=corporationWS_Service.getCorporationWSPort();
//         System.out.println(corporationWS.listCandidates(1));
//
        DbWebService_Service helloWorldService = new DbWebService_Service();
        databaseapplication.DbWebService db = helloWorldService.getDbWebServicePort();
        System.out.println(db.getStudent("ghader@etud.insa-toulouse.fr"));
    }//end main

}
