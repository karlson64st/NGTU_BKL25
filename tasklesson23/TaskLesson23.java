/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package my.tasklesson23;

/**
 *
 * @author Win10_SSD480
 */

// задание урока 23
public class TaskLesson23 {

    public static void main(String[] args) {
        
        String vn="VNUTRENNIY metod";
        Generator gen = new Generator(220,14,15,1.30, "Inforce GL 3000", 3000);
        Ibp ibp = new Ibp(24,16,12,5.0,"ИБП-24/4,5-2X12",4000);
        //Starter start = new Generator();
        
        gen.networkPower();
        System.out.println();
        gen.consumption();
        System.out.println();
        System.out.println("Mozhnost s 1m AkB " + ibp.poverAkb() + " vT/Ch");
        System.out.println("Mozhnost s 2my AkB " + ibp.poverAkb(2) + " vT/Ch");
        System.out.println();
        gen.turn_on();
        System.out.println();
        ibp.networkPower(); 
        
        Vneshniy vnesh = new Vneshniy();
        vnesh.metod();
    }
}
