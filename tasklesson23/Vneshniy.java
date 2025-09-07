/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.tasklesson23;

/**
 *
 * @author Win10_SSD480
 */
public class Vneshniy {
    String vn="VNUTRENNIY metod";
    
     void metod() {
      Vnutr vnut = new Vnutr();
      vnut.display();
   }
   
   // это внутренний класс
   class Vnutr {
      void display() {
         System.out.println("Vypolnyaetcy - " + vn);
      }
   }
}
