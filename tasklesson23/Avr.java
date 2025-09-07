/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.tasklesson23;

/**
 *
 * @author Win10_SSD480
 */

//класс автоматического ввода резерва
public abstract class Avr {
    double u;//напряжение сети, В
    double i;//ток нагрузки, А
    
    Avr(double a, double b){
        u=a;
        i=b;
    }
    
    abstract void networkPower ();
}
