/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.contacteditor;

/**
 *
 * @author matth
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel; 
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.Rectangle;

//import java.awt.Graphics;

public class ContactEditor {
    //Instantiation
    JFrame window;
    JPanel panel,p2;
    JLabel textLabel, tl2, tl3;
    Font font = new Font("Times New Roman", Font.PLAIN, 28);
    KeyHandler khand = new KeyHandler();
    int count=0, count2=0;
    boolean releasedd, releaseda;
    Rectangle r = new Rectangle(100,40,30,30);

    public static void main(String[] args) {
        new ContactEditor();
        
    }
    //public void paint(Graphics g){
      //  g.drawRect(100, 20, 30, 30);
    //}
    public ContactEditor(){
        window = new JFrame();
        window.setSize(800,600);
        window.getDefaultCloseOperation(/*JFrame.EXIT_ON_CLOSE*/);
        
        //creates window
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.addKeyListener(khand); //Adds the key listener
        
        //Background
        panel = new JPanel();
        panel.setBounds(100, 150, 650, 400);
        panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(3,1));
        window.add(panel);
        
        //Try to move this box
        p2 = new JPanel();
        p2.setBounds(100,40,30, 30);
        p2.setBackground(Color.red);
        p2.setLayout(new GridLayout(1,1));
        window.add(p2);
        
        
        //last key typed is shown by number
        textLabel = new JLabel("Hello there.");
        textLabel.setBackground(Color.black);
        textLabel.setForeground(Color.white);
        textLabel.setFont(font);
        panel.add(textLabel);
        
        //velocity in the positive x
        tl2 = new JLabel(""+count);
        tl2.setBackground(Color.black);
        tl2.setForeground(Color.white);
        tl2.setFont(font);
        panel.add(tl2);
        
        //Velocity in the negative x
        tl3 = new JLabel(""+count);
        tl3.setBackground(Color.black);
        tl3.setForeground(Color.white);
        tl3.setFont(font);
        panel.add(tl3);
        
        
        
        
        
        window.setVisible(true);
    }
    
    public class KeyHandler implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_D->{
                    textLabel.setText("D");
                    releasedd=false;
                    while(count<11&&!releasedd){
                        count++;
                        tl2.setText(""+count);
                        
                        
                    }
                    
                    break;
                }
                case KeyEvent.VK_A->{
                    textLabel.setText("A");
                    releaseda=false;
                    while(count2>-11&&!releaseda){
                        count2--;
                        tl3.setText(""+count2);
                    }
                    break; 
                }
                case KeyEvent.VK_W -> {
                    textLabel.setText("Jump");
                }
            }
        }
        @Override
        public void keyReleased(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_D->{
                    textLabel.setText("-D");
                    releasedd=true;
                    while(count!=0&&releasedd){
                        count--;
                        tl2.setText(""+count);
                    }
                    break;
                }
                case KeyEvent.VK_A->{
                    textLabel.setText("-A");
                    releaseda=true;
                    while(count2!=0&&releaseda){
                        count2++;
                        tl3.setText(""+count2);
                    }
                    break; 
                }
            }
        }
        @Override
        public void keyTyped(KeyEvent e){
            
        }
    }
}
