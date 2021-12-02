package com.company.Swing;

import com.company.Figure;
import com.company.figure.Point;
import com.company.figure.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Frame extends JFrame {

    public Frame(){
        super();
//

    }

    private Panel panel;

    private List<Figure> figures;

    public Frame(List<Figure> figures){
        super("Отрисовка фигур");
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.figures = figures;
        this.panel = new Panel(figures);
        JButton jButton = new JButton("Кнопка");
        jButton.setVisible(true);
        jButton.setBounds(50, 50, 50, 50);
        this.panel.add(jButton);
        this.panel.setVisible(true);
        this.add(panel);

//        panel = new Panel();
        panel.drawFigures(figures);
//        panel.setVisible(true);
//        JPanel jPanel = new JPanel();
        JButton jButton2 = new JButton("Нажми и случится чудо");


        jButton2.addActionListener(this::actionPerformed );



        panel.add(jButton2);

//        getContentPane().setLayout(new FlowLayout());
        panel.setBounds(0,0,1000,1000);       //позиция 1панели
        add(panel);

//        this.update(panel.drawFigures(figures));

//        jPanel.setLayout(new GridLayout(10, 10));
//        jPanel.setBounds(300,200,200,200);  //позиция 2панели
//        add(jPanel);

    }


    public void actionPerformed(ActionEvent e) {
        ArrayList<Point> trianglePoints = new ArrayList<>();
        Collections.addAll(trianglePoints, new Point(0, 0), new Point(0, 3), new Point(4, 3));
        Triangle triangle = new Triangle(trianglePoints);
        ArrayList <Figure> f = new ArrayList<>();
        f.add(triangle);
        panel = new Panel (f);
        this.update(this.getGraphics());
        this.repaint();

//                panel.setVisible(!panel.isVisible());

    }
}
