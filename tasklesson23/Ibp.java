/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.tasklesson23;

/**
 *
 * @author Win10_SSD480
 */

//класс источника бесперебойного питания
public class Ibp extends Generator {
    double u_akb;//напряжение АкБ, В 
    double с_akb;//ёмкость АкБ, А*ч
    int kol;//количество АкБ
    
    
    Ibp(double a, double b,double c,double d, String e, int f){
        super(a,b,c,d,e,f);
        u_akb = a; 
        с_akb = c;
    }

    double poverAkb(){//расчёт мощьности
        return (с_akb*u_akb);
    }
    double poverAkb(int x){//перегрузка метода расчёт мощьности
        kol=x;
        return (с_akb*u_akb*kol);
    }
    @Override //переопоеделение метода расчёта мощьности
    void networkPower() {
        System.out.println("Obzhay mozhnost IBP - " + u_akb*i*2 +" vT");
    }
}
