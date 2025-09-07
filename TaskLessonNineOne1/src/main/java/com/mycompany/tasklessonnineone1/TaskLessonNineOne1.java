/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tasklessonnineone1;

/**
 *
 * @author Win10_SSD480
 */
public class TaskLessonNineOne1 {

   public static void main(String[] args) {
        
        int total=7;                            //кол-во элементов массива
        int iMass[];                            //Объявление массива
        iMass=new int[total];                   //Определение размера массива
        for (int i=0; i<iMass.length; i++){     //заполнение случайными числами
            iMass[i]=(int) (Math.random()*101);
            System.out.println(iMass[i] + ".");
        }
        
        for (int i=0; i < iMass.length-1; i++){     //начало цикла      
        //System.out.println(iMass[i] +" A i ++A "+iMass[++i]);
            for (int j=0; j<iMass.length-i-1;j++){ //от первого до предпоследнего
            if (iMass[j]>iMass[j+1]){ //предыдущий больше последующего?
                //System.out.println(iMass[j] +"A > ++A "+iMass[j+1]);
                int iTemp=iMass[j]; //временная ячека для обмена значениями
                //System.out.println("iz A v Temp= "+ j + "/" + iTemp);
                iMass[j]=iMass[j+1]; //обмен местами
                //System.out.println("iz ++A v A = "+iMass[j+1] + "/" + j);
                iMass[j+1]=iTemp; //обмен местами
                //System.out.println("iz Temp v ++A = " + iTemp + "/" + iMass[j]);
                }
            }
        }
        System.out.print("Result:  ");
    for(int i = 0; i < iMass.length; i++){ //вывод нового массива
        System.out.print(iMass[i] + " ");     
        }
    }
} 