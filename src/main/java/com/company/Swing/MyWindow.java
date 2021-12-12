package com.company.Swing;

import com.company.Figure;
import com.company.Main;
import com.company.Menu;
import com.company.factory.FigureCreator;
import com.company.figure.Circle;
import com.company.figure.Point;
import com.company.figure.Triangle;
import com.company.helper.FigureCreateHelper;
import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

import static com.company.Menu.*;
import static javax.swing.GroupLayout.Alignment.LEADING;

public class MyWindow extends JFrame implements ActionListener {
    private GraphicsCanvas canvas;
    private TreeMap<String, Figure> figures;
    private JPanel panel;
    private HashMap<String, ArrayList<JComponent>> components;
    private GridBagConstraints location;
    boolean chooseFigureAvailable = false;
    Figure activeFigure = null;
    JButton cancelChooseButton;

    JTextField angleTextField;//пробуем так
    JTextField scaleTextField;
    JTextField xMoveTextField;
    JTextField yMoveTextField;
    JTextField xTextField;
    JTextField yTextField;

    ArrayList<JTextField> xTexts;
    ArrayList<JTextField> yTexts;
    JList xList;
    JList yList;


    public MyWindow(TreeMap<String, Figure> figures) {
        super();
        this.figures = figures;
        this.setSize(800, 800);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.setLayout(new GridBagLayout());
        location = new GridBagConstraints();
        location.fill = GridBagConstraints.HORIZONTAL;
        location.weightx = 1;
        location.weighty = 1;
        location.gridwidth = 1;
        location.gridheight = 1;
        location.gridy = 0;
        location.gridx = 0;

        JLabel label1 = new JLabel(" ");
        JLabel label2 = new JLabel(" ");
        JLabel label3 = new JLabel(" ");
        JLabel label4 = new JLabel(" ");
        JLabel label5 = new JLabel(" ");
        JLabel label6 = new JLabel(" ");
        JLabel label7 = new JLabel(" ");
        JLabel label8 = new JLabel(" ");
        JLabel label9 = new JLabel(" ");
        JLabel label10 = new JLabel(" ");
        JLabel label11 = new JLabel(" ");
        JLabel label12 = new JLabel(" ");
        JLabel label13 = new JLabel(" ");
        JLabel label14 = new JLabel(" ");
        JLabel label15 = new JLabel(" ");
        JLabel label16 = new JLabel(" ");

        JLabel menuLabel = new JLabel("Выберите нужный пункт меню:");

        JLabel xLabel = new JLabel("введите X:");
        JLabel yLabel = new JLabel("введите Y:");
        JLabel angleLabel = new JLabel("на сколько градусов:");
        JLabel xMoveLabel = new JLabel("введите X:");
        JLabel yMoveLabel = new JLabel("введите Y:");
        JLabel scaleLabel = new JLabel("На сколько увеличить:");
//        JLabel xAddedLabel = new JLabel("Координаты по X:");
//        JLabel yAddedLabel = new JLabel("Координаты по Y:");

        JButton showButton = new JButton("ВЫВЕСТИ ВСЕ");
        JButton createButton = new JButton("СОЗДАТЬ");
        JButton changeButton = new JButton("ИЗМЕНИТЬ");
        JButton saveButton = new JButton("СОХРАНИТЬ");
        JButton plusButton = new JButton("ввести координаты");
        JButton okayButton = new JButton("OK");
        JButton rotateButton = new JButton("повернуть");
        JButton scaleButton = new JButton("масштаб");
        JButton moveButton = new JButton("переместить");
        JButton deleteButton = new JButton("удалить");
        JButton cancelButton = new JButton("отмена");

        xTextField = new JTextField("");
        yTextField = new JTextField("");
        angleTextField = new JTextField("");
        scaleTextField = new JTextField("");
        xMoveTextField = new JTextField("");
        yMoveTextField = new JTextField("");

        ArrayList<JComponent> voidLabels = new ArrayList<>();
        Collections.addAll(voidLabels, label1, label2, label3, label4, label5,
                label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16);

        ArrayList<JComponent> mainButtons = new ArrayList<>();
        Collections.addAll(mainButtons, showButton, createButton, moveButton, scaleButton);

        ArrayList<JComponent> addGroup = new ArrayList<>();
        Collections.addAll(addGroup, xLabel, yLabel, xTextField, yTextField, plusButton, okayButton, cancelButton);

        ArrayList<JComponent> changeGroup = new ArrayList<>();
        Collections.addAll(changeGroup, angleLabel, xMoveLabel, yMoveLabel, scaleLabel,
                rotateButton, scaleTextField, angleTextField, xMoveTextField, yMoveTextField, deleteButton, scaleButton, moveButton, cancelButton);

        ArrayList<JComponent> mainComponents = new ArrayList<>();
        Collections.addAll(mainComponents, menuLabel, canvas);

        components = new HashMap<>();
        components.put("voidLabels", voidLabels);
        components.put("mainButtons", mainButtons);
        components.put("addGroup", addGroup);
        components.put("changeGroup", changeGroup);
        components.put("mainComponents", mainComponents);

        showButton.addActionListener(this);
        createButton.addActionListener(this);
        changeButton.addActionListener(this);
        saveButton.addActionListener(this);
        plusButton.addActionListener(this);
        okayButton.addActionListener(this);
        rotateButton.addActionListener(this);
        scaleButton.addActionListener(this);
        moveButton.addActionListener(this);
        deleteButton.addActionListener(this);

        for (JComponent label : voidLabels) {
            this.panel.add(label, location);
            location.gridx++;
        }
        location.gridx = 8;
        location.gridy = 1;
        location.gridwidth = 8;
        this.panel.add(menuLabel, location);

        location.gridx = 8;
        location.gridy = 2;
        location.gridwidth = 2;
        this.panel.add(showButton, location);
        location.gridx = 10;
        this.panel.add(createButton, location);
        location.gridx = 12;
        this.panel.add(changeButton, location);
        changeButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
//        System.out.println(x+","+y);//the log(null, "x = " + x + " y =" + y, "title", JOptionPane.PLAIN_MESSAGE);
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

        location.gridx = 14;
        this.panel.add(saveButton, location);

        location.gridwidth = 1;
        location.gridy = 3;
        location.gridx = 8;
        this.panel.add(xLabel, location);
        location.gridx = 9;
        this.panel.add(xTextField, location);
        location.gridx = 12;
        this.panel.add(angleLabel, location);
        location.gridx = 15;
        this.panel.add(rotateButton, location);
//        location.gridx = 10;
//        this.panel.add(xAddedLabel, location);
//        location.gridx = 11;
//        this.panel.add(yAddedLabel, location);
        location.gridx = 13;
        location.gridwidth = 2;
        this.panel.add(angleTextField, location);

        //СДЕДАТЬ ЛИСТ БОКС - туда помещаются координаты фигуры, при добавлении.
//      location.gridx = 10;
//      location.gridwidth = 2;
//      location.gridheight = 5;

        location.gridy = 4;
        location.gridx = 8;
        location.gridwidth = 1;
        this.panel.add(yLabel, location);
        location.gridx = 9;
        this.panel.add(yTextField, location);
        location.gridx = 12;
        this.panel.add(scaleLabel, location);
        location.gridx = 15;
        this.panel.add(scaleButton, location);
        location.gridx = 13;
        location.gridwidth = 2;
        this.panel.add(scaleTextField, location);

        location.gridy = 5;
        location.gridx = 8;
        this.panel.add(plusButton, location);
        location.gridx = 13;
        this.panel.add(xMoveTextField, location);
        location.gridx = 12;
        location.gridwidth = 1;
        this.panel.add(xMoveLabel, location);

        location.gridy = 6;
        location.gridx = 12;
        this.panel.add(yMoveLabel, location);
        location.gridx = 15;
        this.panel.add(moveButton, location);
        location.gridx = 8;
        location.gridwidth = 2;
        this.panel.add(okayButton, location);
        location.gridx = 13;
        this.panel.add(yMoveTextField, location);

        location.gridy = 7;
        location.gridx = 13;
        this.panel.add(deleteButton, location);
        location.gridx = 15;
        location.gridwidth = 1;
        this.panel.add(cancelButton, location);

        this.canvas = new GraphicsCanvas(figures);
        location.gridx = 0;
        location.gridy = 0;
        location.gridwidth = 8;
        location.gridheight = 8;
        location.fill = GridBagConstraints.BOTH;
        this.panel.add(canvas, location);
        this.add(panel);

        this.panel.setVisible(true);

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                // JOptionPane.showMessageDialog(null, "x = " + x + " y =" + y, "title", JOptionPane.PLAIN_MESSAGE);
                activeFigure = defineFigureByCursor(x, y, canvas.multiplierX, canvas.multiplierY, figures);
                if (chooseFigureAvailable && activeFigure != null) {
//                    JOptionPane.showMessageDialog(null, "ФИГУРА ВЫБРАНА!", "title", JOptionPane.PLAIN_MESSAGE);
                    canvas.repaintGraphics(new TreeMap<>() {{
                        put("1", activeFigure);
                    }});
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
    }

    /**
     * определяет фигуру с помощью курсора на графике
     */
    public Figure defineFigureByCursor(int x, int y, int multiplierX, int multiplierY, TreeMap<String, Figure> figures) {
        for (Figure f : figures.values()) {
            if (f.containPoint(x, y, multiplierX, multiplierY)) return f;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Кнопка нажата");

//        else if (e.getSource().equals(components.get("mainButtons").get("createButton")))
        if (e.getActionCommand().equals("СОЗДАТЬ")) { //НЕ СДЕЛАНО

//            this.xTexts = new ArrayList<>();
//            this.yTexts = new ArrayList<>();

            JLabel xAddedLabel = new JLabel("Координаты по X:");
            JLabel yAddedLabel = new JLabel("Координаты по Y:");
            location.gridx = 10;
            location.gridy = 3;
            location.gridwidth = 1;
            location.gridheight = 1;
            this.panel.add(xAddedLabel, location);
            location.gridx = 11;
            this.panel.add(yAddedLabel, location);

            xList = new JList();
            location.gridx = 10;
            location.gridy = 4;
            location.gridwidth = 1;
            location.gridheight = 3;
            this.panel.add(xList, location);
            xList.setLayoutOrientation(JList.VERTICAL);

            yList = new JList();
            location.gridx = 11;
            this.panel.add(yList, location);
            xList.setLayoutOrientation(JList.VERTICAL);

            panel.revalidate();
        }
        else if (e.getActionCommand().equals("ИЗМЕНИТЬ")) {
//            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
//            JOptionPane.showMessageDialog(null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), "title", JOptionPane.PLAIN_MESSAGE);
            cancelChooseButton = new JButton("отменить действия");
            cancelChooseButton.addActionListener(this);
            panel.add(cancelChooseButton);
            this.chooseFigureAvailable = true;

            //впихнули кнопку - заменить одну из кнопок отмены
            location.gridx = 9;
            location.gridy = 7;
            location.gridwidth = 1;
            location.gridheight = 1;
            this.panel.add(cancelChooseButton, location);
        }
        else if (e.getActionCommand().equals("повернуть")) {
            Double a = Double.valueOf(angleTextField.getText());
            activeFigure.rotate(a);
            this.repaint();
        }
        else if (e.getActionCommand().equals("масштаб")) {
            Double a = Double.valueOf(scaleTextField.getText());
            activeFigure.scale(a);
            this.repaint();
        }
        else if (e.getActionCommand().equals("переместить")) { //хммм????вопросики
//            ArrayList <Point> points = new ArrayList<>();
//            for (int i = 0; i <xTexts.size(); i++){
//                points.add(new Point(Double.valueOf(xTexts.get(i).getText()), Double.valueOf(yTexts.get(i).getText())));
//            }
            Double x = Double.valueOf(xTextField.getText());
            Double y = Double.valueOf(yTextField.getText());
            activeFigure.move(new Point(x, y));
            this.repaint();
        }
        else if (e.getActionCommand().equals("ввести координаты")) { //НЕ СДЕЛАНО
            //пользователь вводит координаты в поля х у, их считать и поместить в лист
            Double x = Double.valueOf(xTextField.getText());
            DefaultListModel dlmX = new DefaultListModel ();
            xList = new JList(dlmX);
            dlmX.addElement(x); //или через цикл?
            this.xTextField.setText(""); //чистим поле
            Double y = Double.valueOf(yTextField.getText());
            DefaultListModel dlmY = new DefaultListModel ();
            xList = new JList(dlmY);
            dlmY.addElement(x);
            this.yTextField.setText(""); //чистим поле
        }
        else if (e.getActionCommand().equals("OK")) { //НЕ СДЕЛАНО
            //из всех введеных координат создать фигуру
//            ArrayList<Point> points = new ArrayList<>();
//            for (int i = 0; i < xTexts.size(); i++) {
//                points.add(new Point(Double.valueOf(xTexts.get(i).getText()), Double.valueOf(yTexts.get(i).getText())));
//            }
            //как их листх и листу нарисовать фигуру??
//            FigureCreateHelper.getFigureFactory(points).createFigure(points);
            this.repaint();

        }
        else if (e.getActionCommand().equals("удалить")) { //ммммм??????????
//            activeFigure.remove;
//            canvas.remove(activeFigure);
//            remove(activeFigure);
            this.repaint();

        }
        else if (e.getActionCommand().equals("ВЫВЕСТИ ВСЕ")) {
            canvas.repaintGraphics(figures);
            this.repaint();
        }
        else if (e.getActionCommand().equals("СОХРАНИТЬ")) {
            saveToFile(figures, Main.file);
        }
        else if (e.getActionCommand().equals("отменить действия")) {
            this.chooseFigureAvailable = false;
            this.panel.remove(cancelChooseButton);
        }
    }

}

