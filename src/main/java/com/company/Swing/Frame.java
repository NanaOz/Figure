package com.company.Swing;

import com.company.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Frame extends JFrame {
    private Panel panel;

    private List<Figure> figures;
    //или ArrayList?????
    public Frame(List<Figure> figures){  //нужен ли (List)?
        super("Отрисовка фигур");
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.figures = figures;
        panel = new Panel(this.figures);
        panel.setVisible(false);
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("Нажми и случится чудо");  //но чудо не получается!:(

//пробуем фишки с гугла)))Непонятно -нужно разобраться, но работет)
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(true);
                panel.setVisible(false);
                panel.setVisible(true);
            }
        });

        jPanel.add(jButton);

        getContentPane().setLayout(null);                      //или используем flowLayout????
        panel.setLayout(new GridLayout(10, 10));
        panel.setBounds(0,0,300,400);       //позиция 1панели
        add(panel);

        jPanel.setLayout(new GridLayout(10, 10));
        jPanel.setBounds(300,200,200,200);  //позиция 2панели
        add(jPanel);
    }

}
