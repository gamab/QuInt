/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

/**
 *
 * @author gb
 */
public class G_Log {
    public static void e (String callingClass, String callingFunction, String message) {
        System.err.println("ERROR in " + callingClass + "(" + callingFunction + ") : " + message);
    }
    public static void w (String callingClass, String callingFunction, String message) {
        System.out.println("WARNING in " + callingClass + "(" + callingFunction + ") : " + message);
    }
    public static void d (String callingClass, String callingFunction, String message) {
        System.out.println("DEBUG in " + callingClass + "(" + callingFunction + ") : " + message);
    }
}
