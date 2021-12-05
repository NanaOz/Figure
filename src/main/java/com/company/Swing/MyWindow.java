package com.company.Swing;

import com.company.Figure;
import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.TreeMap;

public class MyWindow extends JFrame {

    public MyWindow(TreeMap<String, Figure> figures) {
        super();
        this.figures = figures;
        this.setSize(800, 800);
        this.add(new GraphicsCanvas(figures));
        this.setVisible(true);
        guiCanvas();
    }

    private GraphicsCanvas panel;
    private TreeMap<String, Figure> figures;


    public void guiCanvas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Container container = getContentPane();
//        container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button;
        JComboBox cb = new JComboBox();
        panel.add(cb);
        button = new JButton("Вывести все фигуры");
        panel.add(button);
        button.setVisible(true);
        button.setBounds(50, 50, 50, 50);
        button = new JButton("Создать фигуру");
        panel.add(button);
        button = new JButton("Изменить фигуру");
        panel.add(button);
        button = new JButton("Сохранить файл");
        panel.add(button);



//        JButton button1 = new JButton("Вывести все фигуры");
//        button1.setActionCommand("Button 1 was pressed!");
//        button1.addActionListener(new ListenerAction());
//        button1.addChangeListener(new ListenerChange());
//        panel.add(button1);
//        button1.getRolloverIcon();
//        button1.setVisible(true);
//        button1.setBounds(50, 50, 50, 50);
////        container.add(button1);
//
//        JButton button2 = new JButton("Создать фигуру");
//        button2.setActionCommand("Button 2 was pressed!");
//        button2.addActionListener(new ListenerAction());
//        button2.addChangeListener(new ListenerChange());
//        button2.getRolloverIcon();
//        panel.add(button2);
////        container.add(button2);
//
//        JButton button3 = new JButton("Изменить фигуру");
//        button3.setActionCommand("Button 3 was pressed!");
//        button3.addActionListener(new ListenerAction());
//        button3.addChangeListener(new ListenerChange());
//        button3.getRolloverIcon();
//        panel.add(button3);
////        container.add(button3);
//
//        JButton button4 = new JButton("Сохранить файл");
//        button4.setActionCommand("Button 4 was pressed!");
//        button4.addActionListener(new ListenerAction());
//        button4.addChangeListener(new ListenerChange());
//        button4.getRolloverIcon();
//        panel.add(button4);
////        container.add(button4);
//
//        JButton button5 = new JButton("Выход");
//        button5.setActionCommand("Button 5 was pressed!");
//        button5.addActionListener(new ListenerAction());
//        button5.addChangeListener(new ListenerChange());
//        button5.getRolloverIcon();
//        panel.add(button5);
////        container.add(button5);

    }

    class ListenerAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Нажатие кнопки" + e.getActionCommand() + "\n");

        }
    }

    class ListenerChange implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            // Источник события
            Object src = e.getSource();
            System.out.println("Cообщение о смене состояния объекта : " + src.getClass());
        }
    }

//    public void gCanvas(List<Figure> figures){
//        setVisible(true);
//        setSize(500,500);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.figures = figures;
//        this.panel = new Panel(figures);
//        JButton jButton = new JButton("Кнопка");
//        jButton.setVisible(true);
//        jButton.setBounds(50, 50, 50, 50);
//
//
////        this.panel.add(jButton); //комент
//
//
//        this.panel.setVisible(true);
//        this.add(panel);
//
//
////        panel = new Panel();   //комент
////        panel.drawFigures(figures);
////        panel.setVisible(true);
////        JPanel jPanel = new JPanel();
//
//
//        JButton jButton2 = new JButton("Нажми и случится чудо");
//        jButton2.addActionListener(this::actionPerformed );
//
//
////        panel.add(jButton2);    //комент
////        getContentPane().setLayout(new FlowLayout());
//
//
//        panel.setBounds(0,0,1000,1000);       //позиция 1панели
//        add(panel);
//
//
////        this.update(panel.drawFigures(figures));   //комент
////        jPanel.setLayout(new GridLayout(10, 10));
////        jPanel.setBounds(300,200,200,200);  //позиция 2панели
////        add(jPanel);
//
//    }
//
//    public void actionPerformed(ActionEvent e) {
//        ArrayList<Point> trianglePoints = new ArrayList<>();
//        Collections.addAll(trianglePoints, new Point(0, 0), new Point(0, 3), new Point(4, 3));
//        Triangle triangle = new Triangle(trianglePoints);
//        ArrayList <Figure> f = new ArrayList<>();
//        f.add(triangle);
//        panel = new Panel (f);
//        this.update(this.getGraphics());
//        this.repaint();
//
////                panel.setVisible(!panel.isVisible());
//
//    }
}
