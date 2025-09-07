/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tasklessonninetwo;

/**
 *
 * @author Win10_SSD480
 */
public class TaskLessonNineTwo {

    public static void main(String[] args) {
        int iMass2[][];
        iMass2 = new int[10][]; //определим размер массива по строкам

        iMass2[0]=new int[1];
        iMass2[1]=new int[2];
        iMass2[2]=new int[3];
        iMass2[3]=new int[4];
        iMass2[4]=new int[5];
        iMass2[5]=new int[6];
        iMass2[6]=new int[7];
        iMass2[7]=new int[8];
        iMass2[8]=new int[9];
        iMass2[9]=new int[10];
        
        int i,j,a;
       
        for (i = 0; i < iMass2.length; ++i) { //сформируем сам массив
            for(j = 0; j < iMass2[i].length; ++j) {

                if(j==0){
                    iMass2[i][j]=1; //заполним 1(единицами)в ячейках J=0
                    System.out.print(iMass2[i][j] + "  "); // вывод колонок
                    continue;
                }
                if((j>=1)&(j!=i)){ //N строки >=1 И не последняя ячейка
                    a = iMass2[i-1][j-1]+iMass2[i-1][j]; //сложить 2 ячейки выше слева
                    iMass2[i][j]=a; // результат в новую ячейку
                    System.out.print(iMass2[i][j] + "  "); // вывод колонок
                    continue;
                }
                if(j<iMass2[i].length){//заполним 1(единицами)в ячейках I=J (последние  в строках)
                    iMass2[i][j]=1; //заполним его 1(единицами)
                    System.out.print(iMass2[i][j] + "  "); // вывод колонок
                }
            }
            System.out.println(); //разбивка по строкам
        }
    }                                                                             //}
} 
                                                                                //}
                                                                                //}

