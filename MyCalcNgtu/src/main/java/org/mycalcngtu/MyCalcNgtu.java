/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.mycalcngtu;

/**
 *
 * @author Win10_SSD480
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.*;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyCalcNgtu extends JFrame {

    private JTextField txtFld;
    double raschet;                     // основная переменная для вычислений
    double base;                        // 1-я переменная для степени
    double exponent;                    // 2-я переменная для степени
    String sbrosPolya="";               // переменная очистки поля
    String operaciay="";                // переменная операции для мыши
    String chisloKey;                   // переменная для удаления знака в поле
    String chisloKey1;                  // переменная для удаления знака в поле
    char simvol=' ';                    // считывание символа данных
    char znak;                          // переменная симовла операции
    int codeKey;                        // переменная кода клавиши
    int dlinaStr;                       // переменная длинны строки ввода

public MyCalcNgtu() {				//создание окна калькулятора
    setBounds(620,250, 360, 400);		//расположение на экране
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Калькулятор");
    getContentPane().setLayout(null);           

    txtFld = new JTextField();		// поле отображения ввода и результата
    txtFld.setEditable(false);          // запрет редактирования
    txtFld.addKeyListener(new KeyAdapter() {    // слушатель клавиатуры
        @Override
        public void keyTyped(KeyEvent e) {      // обработка ввода символа
            txtFld.requestFocus();              // установка фокуса в строку
            simvol=e.getKeyChar();              // получить символ
            chisloKey = String.valueOf(simvol); // преобразовать в строку
            txtFld.setText(txtFld.getText()+chisloKey); 
                                // прочитать строку и добавить новую строку            
            dlinaStr=txtFld.getText().length(); // получить длинну строки

            if (e.getKeyChar()=='+'|e.getKeyChar()=='-'|e.getKeyChar()=='*'
                |e.getKeyChar()=='/'|e.getKeyChar()=='^'|e.getKeyCode() ==10){
                    //проверка введённого знака операции, для выбора действия    
                znak=e.getKeyChar();            // получение символа операции
                simvol=e.getKeyChar();          // получение символа данных
                dlinaStr=dlinaStr-1;            // уменьшить длинну строки на 1
                chisloKey=txtFld.getText();     // занести строку в переменную
                chisloKey1 = chisloKey.substring(0, dlinaStr);
                    // в новую переменную занести строку без последнего знака
                raschet = Double.valueOf(chisloKey1);// преобразовать строку в число
                txtFld.setText(sbrosPolya);     // очистить поле
                txtFld.requestFocus();          // установить фокус
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {   // обработка ввода кода символа
            codeKey=e.getKeyCode();             // получить код клавиши
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    txtFld.setText(sbrosPolya); //очистка поля клавишей Esc

            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        // по коду клавиши выполнить соответствующую операцию
                try {                           // отловить ошибку ввода 
                    if(znak=='+') {             // операция сложения
                        txtFld.requestFocus();
                        txtFld.setText(String.valueOf(raschet+
                                Double.valueOf(txtFld.getText())));
                    }
                    if(znak=='-') {             // операция вычитания
                        txtFld.requestFocus();
                        txtFld.setText(String.valueOf(raschet-
                                Double.valueOf(txtFld.getText())));
                    }
                    if(znak=='*') {             // операция умножения
                        txtFld.requestFocus();
                        txtFld.setText(String.valueOf(raschet*
                                Double.valueOf(txtFld.getText())));
                    }
                    if(znak=='/') {             // операция деления
                        txtFld.requestFocus();
                        txtFld.setText(String.valueOf(raschet/
                                Double.valueOf(txtFld.getText())));
                    }
                    if(znak=='^') {             // операция возведения в степень
                        txtFld.requestFocus();
                        txtFld.setText(String.valueOf(Math.pow(raschet,
                                Double.valueOf(txtFld.getText()))));
                    }
                }catch(Exception evv){          // вызов окна ошибки 									
                    showMessageDialog(null, "Ошибка ВВОДА.\n"+
                                    "Пользуйтесь либо клавиатурой, либо мышью.\n"
                                    + "Вводите только цифры.",
                                    "Ошибка",ERROR_MESSAGE);
                }
            }
        }
    });
    txtFld.setHorizontalAlignment(SwingConstants.RIGHT);	
    txtFld.setFont(new Font("Tahoma", Font.BOLD, 16));	
    txtFld.setBounds(10, 11, 324, 40);		
    getContentPane().add(txtFld);			
    txtFld.setColumns(10);					
    txtFld.setEditable(false);		//запрет редактирования

    JButton btn0 = new JButton("0");				// кнопка "0"
    btn0.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {    //слушатель кнопки	
            txtFld.requestFocus();                  //установка фокуса
            txtFld.setText(txtFld.getText()+e.getKeyChar());//занесение символа в поле
        }
    });
    btn0.addActionListener(new ActionListener() {   //слушатель мыши
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"0");   //занесение символа в поле	
        }
    });
    btn0.setForeground(new Color(0, 0, 0));         // установка цвета шрифта	
    btn0.setBackground(new Color(169, 169, 169));   // установка цвета поля
    btn0.setFont(new Font("Tahoma", Font.BOLD, 14));// установить шрифт
    btn0.setBounds(10, 245, 110, 50);               // установить размер поля
    getContentPane().add(btn0);                     //добавление кнопки 

    JButton btn20 = new JButton(".");				// кнопка "."
    btn20.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();       
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn20.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+".");
        }
    });
    btn20.setForeground(Color.BLACK);
    btn20.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn20.setBackground(new Color(169, 169, 169));
    btn20.setBounds(130, 245, 50, 50);
    getContentPane().add(btn20);

    JButton btn2 = new JButton("2");				// кнопка "2"
    btn2.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();              
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"2");
        }
    });
    btn2.setForeground(Color.BLACK);
    btn2.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn2.setBackground(new Color(169, 169, 169));
    btn2.setBounds(70, 184, 50, 50);
    getContentPane().add(btn2);

    JButton btn1 = new JButton("1");				// кнопка "1"
    btn1.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();              
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"1");
            repaint();
        }
    });
    btn1.setForeground(Color.BLACK);
    btn1.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn1.setBackground(new Color(169, 169, 169));
    btn1.setBounds(10, 184, 50, 50);
    getContentPane().add(btn1);

    JButton btn3 = new JButton("3");				// кнопка "3"
    btn3.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();                       
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"3");
        }
    });
    btn3.setForeground(Color.BLACK);
    btn3.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn3.setBackground(new Color(169, 169, 169));
    btn3.setBounds(130, 184, 50, 50);
    getContentPane().add(btn3);

    JButton btn4 = new JButton("4");				// кнопка "4"
    btn4.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();                            
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"4");
        }
    });
    btn4.setForeground(Color.BLACK);
    btn4.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn4.setBackground(new Color(169, 169, 169));
    btn4.setBounds(10, 123, 50, 50);
    getContentPane().add(btn4);

    JButton btn5 = new JButton("5");				// кнопка "5"
    btn5.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();                               
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"5");
        }
    });
    btn5.setForeground(Color.BLACK);
    btn5.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn5.setBackground(new Color(169, 169, 169));
    btn5.setBounds(70, 123, 50, 50);
    getContentPane().add(btn5);

    JButton btn6 = new JButton("6");				// кнопка "6"
    btn6.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();                           
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"6");
        }
    });
    btn6.setForeground(Color.BLACK);
    btn6.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn6.setBackground(new Color(169, 169, 169));
    btn6.setBounds(130, 123, 50, 50);
    getContentPane().add(btn6);

    JButton btn7 = new JButton("7");				//кнопка "7"
    btn7.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();                           
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"7");
        }
    });
    btn7.setForeground(Color.BLACK);
    btn7.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn7.setBackground(new Color(169, 169, 169));
    btn7.setBounds(10, 62, 50, 50);
    getContentPane().add(btn7);

    JButton btn8 = new JButton("8");				//кнопка "8"
    btn8.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();                             
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"8");
        }
    });
    btn8.setForeground(Color.BLACK);
    btn8.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn8.setBackground(new Color(169, 169, 169));
    btn8.setBounds(70, 62, 50, 50);
    getContentPane().add(btn8);

    JButton btn9 = new JButton("9");				// кнопка "9"
    btn9.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            txtFld.requestFocus();                             
            txtFld.setText(txtFld.getText()+e.getKeyChar());
        }
    });
    btn9.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(txtFld.getText()+"9");
        }
    });
    btn9.setForeground(Color.BLACK);
    btn9.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn9.setBackground(new Color(169, 169, 169));
    btn9.setBounds(130, 62, 50, 50);
    getContentPane().add(btn9);

    JButton btn21 = new JButton("C");				// кнопка Сброс
    btn21.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            txtFld.setText(sbrosPolya);                         //очистка поля
            txtFld.requestFocus();
        }
    });
    btn21.setForeground(Color.BLACK);
    btn21.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn21.setBackground(new Color(169, 169, 169));
    btn21.setBounds(212, 62, 62, 50);
    getContentPane().add(btn21);

    JButton btn22 = new JButton("x^2");				// Х в степени 2
    btn22.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            raschet = Double.valueOf(txtFld.getText());     // расчёт
            txtFld.setText(String.valueOf(raschet*raschet));// вывод 
            txtFld.requestFocus();                      // установка фокуса
        }
    });									
    btn22.setForeground(Color.BLACK);
    btn22.setFont(new Font("Arial", Font.BOLD, 14));
    btn22.setBackground(new Color(169, 169, 169));
    btn22.setBounds(212, 123, 62, 50);
    getContentPane().add(btn22);

    JButton btn24 = new JButton("");			// квадратный корень
    btn24.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            raschet = Double.valueOf(txtFld.getText());	
            txtFld.setText(String.valueOf(Math.sqrt(raschet))); 
            txtFld.requestFocus();
        }
    });
    btn24.setIcon(new ImageIcon("E:\\____eclipse-java-2025-06-R-win32-x86_64\\"
                    + "Project_25_06_SE\\MyCalcNgtu\\2Vx_c.png"));  //иконка
    btn24.setForeground(Color.BLACK);
    btn24.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn24.setBackground(new Color(169, 169, 169));
    btn24.setBounds(212, 245, 62, 50);
    getContentPane().add(btn24);

    JButton btn23 = new JButton("x^y");				// любая степень
    btn23.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            operaciay = "^";                   //символ для распознавания кнопки             
            base = Double.valueOf(txtFld.getText());                           
            txtFld.setText(sbrosPolya);	
            txtFld.requestFocus();
        }
    });
    btn23.setForeground(Color.BLACK);
    btn23.setFont(new Font("Arial", Font.BOLD, 14));
    btn23.setBackground(new Color(169, 169, 169));
    btn23.setBounds(212, 185, 62, 50);
    getContentPane().add(btn23);

    JButton btn25 = new JButton("=");				// кнопка =
    btn25.addKeyListener(new KeyAdapter() {                
        @Override                                          
        public void keyPressed(KeyEvent e) {         
        }                                       
        @Override
        public void keyReleased(KeyEvent e) {                          
            codeKey=e.getKeyCode();
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)       
                txtFld.setText(sbrosPolya); //очистка поля перед выводом результата
        }
    });
    btn25.addActionListener(new ActionListener() {
                                    // отработка нажатия кнопки операции мышью
        public void actionPerformed(ActionEvent e) {
                                    // занесение 2-го числа и вывод результата
            try {                                        //проверка ошибки ввода
                switch(operaciay){   // проверка операции - нажатия кнопки мышью
                case "+": 
                    txtFld.setText(String.valueOf(raschet+
                            Double.valueOf(txtFld.getText()))); 
                    break;
                case "-": 
                    txtFld.setText(String.valueOf(raschet-
                            Double.valueOf(txtFld.getText()))); 
                    break;
                case "*": 
                    txtFld.setText(String.valueOf(raschet*
                            Double.valueOf(txtFld.getText()))); 
                    break;
                case "/": 
                    txtFld.setText(String.valueOf(raschet/
                            Double.valueOf(txtFld.getText()))); 
                    break;
                case "^": 
                    exponent = Double.valueOf(txtFld.getText()); 
                                                    //ввести значение экспоненты 
                    txtFld.setText(String.valueOf(Math.pow(base, exponent)));	
                                                    //вычислить
                    raschet = Double.valueOf(txtFld.getText());	
                                                    //получить результат
                    txtFld.setText(String.valueOf(raschet));
                    break;
                }
            }catch(Exception evv){                          // вывод окна ОШИБКИ								
                showMessageDialog(null, "Ошибка ВВОДА.\n"+
                                    "Пользуйтесь либо клавиатурой либо мышью.",
                                    "Ошибка",ERROR_MESSAGE);
            }
            txtFld.requestFocus();
        }
    });
    btn25.setForeground(Color.BLACK);
    btn25.setFont(new Font("Tahoma", Font.BOLD, 18));
    btn25.setBackground(new Color(169, 169, 169));
    btn25.setBounds(88, 306, 171, 50);
    getContentPane().add(btn25);

    JButton btn26 = new JButton("+");				// кнопка +
    btn26.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {            //1-е число клавиатуры    
        }
    });
    btn26.addActionListener(new ActionListener() {      //1-е число мыши
        public void actionPerformed(ActionEvent e) {
            operaciay = "+";
            raschet = Double.valueOf(txtFld.getText());
            txtFld.setText(" ");
            txtFld.requestFocus();
        }
    });
    btn26.setForeground(Color.BLACK);
    btn26.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn26.setBackground(new Color(169, 169, 169));
    btn26.setActionCommand("+");
    btn26.setBounds(284, 62, 50, 50);
    getContentPane().add(btn26);

    JButton btn27 = new JButton("-");				// кнопка -
    btn27.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
        }
    });
    btn27.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {
            operaciay = "-";
            raschet = Double.valueOf(txtFld.getText());
            txtFld.setText("");
            txtFld.requestFocus();
        }
    });
    btn27.setForeground(Color.BLACK);
    btn27.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn27.setBackground(new Color(169, 169, 169));
    btn27.setActionCommand("-");
    btn27.setBounds(284, 123, 50, 50);
    getContentPane().add(btn27);

    JButton btn28 = new JButton("*");				// кнопка *
    btn28.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) { 
        }
    });
    btn28.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            operaciay = "*";
            raschet = Double.valueOf(txtFld.getText());
            txtFld.setText(" ");
            txtFld.requestFocus();
        }
    });
    btn28.setForeground(Color.BLACK);
    btn28.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn28.setBackground(new Color(169, 169, 169));
    btn28.setActionCommand("*");
    btn28.setBounds(284, 184, 50, 50);
    getContentPane().add(btn28);

    JButton btn29 = new JButton("/");				// кнопка /
    btn29.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {  
        }
    });
    btn29.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            operaciay = "/";
            raschet = Double.valueOf(txtFld.getText());
            txtFld.setText("");
            txtFld.requestFocus();
        }
    });
    btn29.setForeground(Color.BLACK);
    btn29.setFont(new Font("Tahoma", Font.BOLD, 14));
    btn29.setBackground(new Color(169, 169, 169));
    btn29.setActionCommand("/");
    btn29.setBounds(284, 245, 50, 50);
    getContentPane().add(btn29);

}
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {                                                                                               //в потоке отправки событий
            public void run() {				//точка входа в поток
                    new MyCalcNgtu().setVisible(true);	//запуск и отображение
            }
        });
    }
}
