package com.company.Swing;

import com.company.Figure;
import com.company.Main;
import com.company.Menu;
import com.company.figure.Circle;
import com.company.figure.Point;
import com.company.figure.Triangle;
import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import static com.company.Menu.*;

public class MyWindow extends JFrame implements ActionListener {
    private GraphicsCanvas canvas;
    private TreeMap<String, Figure> figures;
    private JPanel panel;
    private GridBagConstraints location;
    boolean chooseFigureAvailable=false;
    Figure activeFigure=null;
    JButton cancelChooseButton;

    //    int sizeX;
//    int sizeY;
    ArrayList<JTextField> xTexts;
    ArrayList<JTextField> yTexts;
//    GridBagConstraints location;

    public MyWindow(TreeMap<String, Figure> figures) {
        super();
        this.figures = figures;
        this.setSize(800, 800);
//        this.add(new GraphicsCanvas(figures));
        this.setVisible(true);
        this.canvas = new GraphicsCanvas(figures);
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
               // JOptionPane.showMessageDialog(null, "x = " + x + " y =" + y, "title", JOptionPane.PLAIN_MESSAGE);
                activeFigure=defineFigureByCursor(x, y, canvas.multiplierX, canvas.multiplierY, figures);
                if(chooseFigureAvailable && activeFigure!=null) {
                    //JOptionPane.showMessageDialog(null, "ФИГУРА ВЫБРАНА!", "title", JOptionPane.PLAIN_MESSAGE);
                    canvas.repaintGraphics(new TreeMap<>(){{put("1", activeFigure);}});
                    panel.add(new JButton("Повернуть фигуру"));
                    panel.add(new JTextField("Введите на сколько градусов повернуть"));


                    panel.add(new JButton("Переместить фигуру"));
                    panel.add(new JTextField("Введите куда переместить фигуру"));

                    panel.add(new JButton("Увеличить фигуру"));
                    panel.add(new JTextField("Введите на сколько увеличить фигуру"));

                    panel.add(new JButton("Удалить фигуру"));
                }


            }


            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(canvas);


        guiCanvas();
        setExtendedState(MAXIMIZED_BOTH);


        panel.setLayout(new GridBagLayout());
        location = new GridBagConstraints();

        location.fill = GridBagConstraints.HORIZONTAL;
        location.weightx = 3;
        location.weighty = 1;

        location.gridy = 0;
        location.anchor = GridBagConstraints.FIRST_LINE_START;
//        location.gridwidth = 0;
//        location.gridheight = 0;

    }

    public Figure defineFigureByCursor(int x, int y, int multiplierX, int multiplierY, TreeMap<String, Figure> figures) {
        for (Figure f : figures.values()) {
            if (f.containPoint(x, y, multiplierX, multiplierY)) return f;

        }
        return null;
    }

    public void guiCanvas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        JButton button;

        JLabel label = new JLabel("Выберите нужный пункт меню:");
        panel.add(label);

        button = new JButton("Вывести все фигуры");
        button.addActionListener(this);
//        location.gridx = 0;
        panel.add(button, location);

        JButton createButton = new JButton("Создать фигуру");
        createButton.addActionListener(this);
//        location.gridx = 1;
        panel.add(createButton);

        JButton changeButton = new JButton("Изменить фигуру");
        changeButton.addActionListener(this);

        changeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
//        System.out.println(x+","+y);//these co-ords are relative to the component
                JOptionPane.showMessageDialog(null, "x = " + x + " y =" + y, "title", JOptionPane.PLAIN_MESSAGE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        panel.add(changeButton);

        JButton saveButton = new JButton("Сохранить файл");
        saveButton.addActionListener(this);

        panel.add(saveButton);

        this.add(panel);
        this.setLayout(new GridLayout());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Кнопка нажата");
//        JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");

        if (e.getActionCommand().equals("Создать фигуру")) {
            location.fill = GridBagConstraints.HORIZONTAL;
            location.weightx = 1;
            location.weighty = 1;
            location.ipadx = 10;
            location.gridy = 1;
            location.anchor = GridBagConstraints.LINE_START;
            location.gridx = 0;
            this.xTexts = new ArrayList<>();
            this.yTexts = new ArrayList<>();
            panel.add(new JTextField("Введите x"));
//            location.gridx = 2;
//            location.gridy = 2;
            panel.add(new JTextField("Введите y"));
//            location.gridx = 3;
//            location.gridy = 2;
            panel.add(new JButton("создать фигуру"));
//            location.gridx = 4;
//            location.gridy = 2;
////
            panel.add(new JButton("добавить координаты точки"));
            panel.revalidate();
        } else if (e.getActionCommand().equals("Вывести все фигуры")) {
            canvas.repaintGraphics(figures);
            this.repaint();
        } else if (e.getActionCommand().equals("Изменить фигуру")) {
//            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
//            JOptionPane.showMessageDialog(null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), "title", JOptionPane.PLAIN_MESSAGE);
            cancelChooseButton = new JButton("Отменить выбор фигуры");
            cancelChooseButton.addActionListener(this);
            panel.add(cancelChooseButton);
            this.chooseFigureAvailable=true;

            panel.add(new JTextField("Выберите фигуру для изменения: "));

        } else if (e.getActionCommand().equals("Сохранить файл")) {


        }
        else if (e.getActionCommand().equals("Отменить выбор фигуры")){
            this.chooseFigureAvailable=false;
            this.panel.remove(cancelChooseButton);
        }
    }

}

