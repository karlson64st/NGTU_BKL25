/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.tasklesson23;

/**
 *
 * @author Win10_SSD480
 */

//класс генератора
public class Generator extends Avr implements Starter{

    double expense;//расход топлива, в/Ч 
    double volume;//объём бака, Л
    String nameGen;
    int power;//мощность генератора
    double start;//

    Generator(double a, double b,double c,double d, String e, int f){
        super (a,b);
        volume = c;
        expense = d;
        nameGen=e;
        power=f;
    }

    /*Generator(double x) {
        start = x;
    }*/
    
    @Override //переопоеделение метода расчёта мощьности
    void networkPower() {
        System.out.println("Obzhay mozhnost generatora - " + u*i +" vT");
    }
    
    void consumption() {//вычисление времени работы генератора
        double t=this.volume/this.expense;
        System.out.println("Vremya rabody generatora " + this.nameGen 
                + " sostavit - " + t + " chasov");
    }

    public void turn_on() {
        System.out.println("Zapustit' generator udalenno!");
    }  
}   
