package com.company;

import javax.swing.*;
import java.awt.*;


public class Screen{
    JFrame window;
    Container con;
    JPanel startbuttonpanel,iconpanel,racepanel;
    JLabel icon,label;
    JButton startbutton;
    Font font=new Font("Times New Roman",Font.CENTER_BASELINE,30);
    Font nfont=new Font("Times New Roman",Font.BOLD,25);


    public void StartScreen(){
        //initializes game screen panel
        window= new JFrame();
        window.setSize(1280,800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        con=window.getContentPane();

        //sets the start button
        startbuttonpanel=new JPanel();
        startbuttonpanel.setBounds(470,640,400,200);
        startbuttonpanel.setBackground(new Color(0,0,0,0));

        startbutton=new JButton();
        startbutton.setPreferredSize(new Dimension(125,43));
        startbutton.setBackground(new Color(0,0,0,0));
        startbutton.setForeground(new Color(0,0,0,0));
        startbutton.addActionListener(new ActionHandler());
        startbutton.setFocusPainted(false);
        startbuttonpanel.add(startbutton);

        //set background
        iconpanel=new JPanel();
        iconpanel.setBounds(1,1,1280,720);
        iconpanel.setBackground(new Color(0,0,0,0));

        icon=new JLabel();
        icon.setIcon(new ImageIcon("Background.png"));
        iconpanel.add(icon);

        //implements to the window
        con.add(startbuttonpanel);
        con.add(iconpanel);

        window.setVisible(true);
    }

    public void RaceScreen (){


    }
}
