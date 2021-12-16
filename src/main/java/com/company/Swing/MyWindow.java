package com.company.Swing;

import com.company.Figure;
import com.company.Main;
import com.company.figure.Point;
import com.company.helper.FigureCreateHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static com.company.Menu.*;

public class MyWindow extends JFrame implements ActionListener {
    private GraphicsCanvas canvas;
    private JPanel panel;
    private GridBagConstraints location;
    private TreeMap<String, Figure> figures;

    private HashMap<String, HashMap<String, JComponent>> components;
    private HashMap<String, JComponent> groupButtons; //группа кнопок

    JList<String> pointsListXY;

    boolean chooseFigureAvailable = false;
    Figure activeFigure = null;
    JButton cancelChooseButton;

    JTextField angleTextField;//пробуем так
    JTextField scaleTextField;
    JTextField xMoveTextField;
    JTextField yMoveTextField;
    JTextField xTextField;
    JTextField yTextField;
    //паршелкласс-читай PartialClass


    public MyWindow(TreeMap<String, Figure> figures) {
        super("Фигуры");
        this.figures = figures;
        this.setSize(800, 800);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
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

        JButton showButton = new JButton("ВЫВЕСТИ ВСЕ");
        JButton createButton = new JButton("СОЗДАТЬ");
        JButton changeButton = new JButton("ИЗМЕНИТЬ");
        JButton saveButton = new JButton("СОХРАНИТЬ");
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
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

        for (JComponent label : voidLabels) {
            this.panel.add(label, location);
            location.gridx++;
        }

        showButton.addActionListener(this);
        createButton.addActionListener(this);
        changeButton.addActionListener(this);
        saveButton.addActionListener(this);
        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        okayButton.addActionListener(this);
        rotateButton.addActionListener(this);
        scaleButton.addActionListener(this);
        moveButton.addActionListener(this);
        deleteButton.addActionListener(this);

        components = new HashMap<>();
        HashMap<String, JComponent> mainButtons = new HashMap<>(); //группа главных кнопок
        mainButtons.put("showButton", showButton);
        mainButtons.put("createButton", createButton);
        mainButtons.put("changeButton", changeButton);
        mainButtons.put("saveButton", saveButton);
        components.put("mainButtons", mainButtons);

        HashMap<String, JComponent> createGroup = new HashMap<>(); //группа кнопок "Создать"
        createGroup.put("xLabel", xLabel);
        createGroup.put("yLabel", yLabel);
        createGroup.put("xTextField", xTextField);
        createGroup.put("yTextField", yTextField);
        createGroup.put("plusButton", plusButton);
        createGroup.put("minusButton", minusButton);
        createGroup.put("okayButton", okayButton);
        createGroup.put("pointsListXY", pointsListXY);
        components.put("createGroup", createGroup);

        xLabel.setVisible(false);
        yLabel.setVisible(false);
        xTextField.setVisible(false);
        yTextField.setVisible(false);
        plusButton.setVisible(false);
        minusButton.setVisible(false);
        okayButton.setVisible(false);

        HashMap<String, JComponent> changeGroup = new HashMap<>();  //группа кнопок "Изменить"
        changeGroup.put("angleLabel", angleLabel);
        changeGroup.put("scaleLabel", scaleLabel);
        changeGroup.put("xMoveLabel", xMoveLabel);
        changeGroup.put("yMoveLabel", yMoveLabel);
        changeGroup.put("angleTextField", angleTextField);
        changeGroup.put("scaleTextField", scaleTextField);
        changeGroup.put("xMoveTextField", xMoveTextField);
        changeGroup.put("yMoveTextField", yMoveTextField);
        changeGroup.put("rotateButton", rotateButton);
        changeGroup.put("scaleButton", scaleButton);
        changeGroup.put("moveButton", moveButton);
        changeGroup.put("deleteButton", deleteButton);
        changeGroup.put("cancelButton", cancelButton);
        components.put("changeGroup", changeGroup);

        angleLabel.setVisible(false);
        scaleLabel.setVisible(false);
        xMoveLabel.setVisible(false);
        yMoveLabel.setVisible(false);
        angleTextField.setVisible(false);
        scaleTextField.setVisible(false);
        xMoveTextField.setVisible(false);
        yMoveTextField.setVisible(false);
        rotateButton.setVisible(false);
        scaleButton.setVisible(false);
        moveButton.setVisible(false);
        deleteButton.setVisible(false);
        cancelButton.setVisible(false);

        location.gridx = 8;
        location.gridy = 0;
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
        location.gridx = 13;
        location.gridwidth = 1;
        this.panel.add(angleTextField, location);

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
        location.gridwidth = 1;
        this.panel.add(scaleTextField, location);

        location.gridx = 13;
        this.panel.add(xMoveTextField, location);
        location.gridwidth = 1;
        location.gridy = 5;
        location.gridx = 8;
        this.panel.add(plusButton, location);
        location.gridx = 9;
        this.panel.add(minusButton, location);
        location.gridx = 12;
        this.panel.add(xMoveLabel, location);

        location.gridy = 6;
        location.gridx = 12;
        this.panel.add(yMoveLabel, location);
        location.gridx = 15;
        this.panel.add(moveButton, location);
        location.gridx = 8;
        location.gridwidth = 1;
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
        location.ipadx = (int) (this.getWidth() * 0.4);
        location.fill = GridBagConstraints.BOTH;
        this.panel.add(canvas, location);
        location.fill = GridBagConstraints.HORIZONTAL;
        this.add(panel);

        this.panel.setVisible(true);

        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX()-canvas.getWidth()/2;
                int y = -e.getY()+canvas.getHeight()/2;
                activeFigure = defineFigureByCursor(x, y, canvas.multiplierX, canvas.multiplierY, figures);
                if (chooseFigureAvailable && activeFigure != null) {
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
        this.revalidate();
        this.repaint();
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

        if (e.getSource().equals(components.get("mainButtons").get("createButton"))) { // кнопка главного меню "Создать"
            components.get("createGroup").get("xLabel").setVisible(true);
            components.get("createGroup").get("yLabel").setVisible(true);
            components.get("createGroup").get("xTextField").setVisible(true);
            components.get("createGroup").get("yTextField").setVisible(true);
            components.get("createGroup").get("plusButton").setVisible(true);
            components.get("createGroup").get("minusButton").setVisible(true);
            components.get("createGroup").get("okayButton").setVisible(true);

            location.gridx = 10;
            location.gridy = 3;
            location.gridwidth = 2;
            location.gridheight = 3;
            location.fill=GridBagConstraints.BOTH;
            pointsListXY = new JList<String>();
            this.panel.add(pointsListXY, location);
            location.fill=GridBagConstraints.HORIZONTAL;
            panel.revalidate();
        } else if (e.getSource().equals(components.get("mainButtons").get("changeButton"))) { //кнопка изменить
            cancelChooseButton = new JButton("отменить действия");
            cancelChooseButton.addActionListener(this);
            panel.add(cancelChooseButton);
            this.chooseFigureAvailable = true;

            components.get("changeGroup").get("angleLabel").setVisible(true);
            components.get("changeGroup").get("scaleLabel").setVisible(true);
            components.get("changeGroup").get("xMoveLabel").setVisible(true);
            components.get("changeGroup").get("yMoveLabel").setVisible(true);
            components.get("changeGroup").get("angleTextField").setVisible(true);
            components.get("changeGroup").get("scaleTextField").setVisible(true);
            components.get("changeGroup").get("xMoveTextField").setVisible(true);
            components.get("changeGroup").get("yMoveTextField").setVisible(true);
            components.get("changeGroup").get("rotateButton").setVisible(true);
            components.get("changeGroup").get("scaleButton").setVisible(true);
            components.get("changeGroup").get("moveButton").setVisible(true);
            components.get("changeGroup").get("deleteButton").setVisible(true);
            components.get("changeGroup").get("cancelButton").setVisible(true);

            //впихнули кнопку - заменить одну из кнопок отмены
            location.gridx = 9;
            location.gridy = 7;
            location.gridwidth = 1;
            location.gridheight = 1;
            this.panel.add(cancelChooseButton, location);
        } else if (e.getSource().equals(components.get("changeGroup").get("rotateButton"))) { //кнопка поворота
            Double a = Double.valueOf(angleTextField.getText());
            activeFigure.rotate(a);
            this.repaint();
        } else if (e.getSource().equals(components.get("changeGroup").get("scaleButton"))) { //кнопка масштаб
            Double a = Double.valueOf(scaleTextField.getText());
            activeFigure.scale(a);
            this.repaint();
        } else if (e.getSource().equals(components.get("changeGroup").get("moveButton"))) { //кнопка перемещения
            Double x = Double.valueOf(xTextField.getText());
            Double y = Double.valueOf(yTextField.getText());
            activeFigure.move(new Point(x, y));
            this.repaint();
        } else if (e.getSource().equals(components.get("createGroup").get("plusButton"))) { //кнопка + добавления координат
            String point = xTextField.getText() + ";" + yTextField.getText();
            this.xTextField.setText("");
            this.yTextField.setText("");
            Vector<String> pointsVector = new Vector<>();
            ListModel<String> points = pointsListXY.getModel();
            for (int i = 0; i < points.getSize(); i++)
                pointsVector.add(points.getElementAt(i));
            pointsVector.add(point);
            pointsListXY.setListData(pointsVector);
        } else if (e.getSource().equals(components.get("createGroup").get("minusButton"))) { //кнопка - удаление координат
            if (!pointsListXY.isSelectionEmpty()) {
                int stringNum = pointsListXY.getSelectedIndex();
//                pointsListXY.remove(stringNum);
                xTextField.remove(stringNum);
                yTextField.remove(stringNum);
            }
            this.revalidate();
            this.repaint();
        } else if (e.getSource().equals(components.get("createGroup").get("okayButton"))) { //кнопка ОК, создание фигуры
            ArrayList<Point> points = new ArrayList<>();
            for(int i = 0; i< pointsListXY.getModel().getSize();i++){
                System.out.println(pointsListXY.getModel().getElementAt(i));
            }
            Vector<String> pointsVector = new Vector<>();
            ListModel<String> pointsModel = pointsListXY.getModel();
            for (int i = 0; i < pointsModel.getSize(); i++) {
                pointsVector.add(pointsModel.getElementAt(i));
                String arrayOfPoint[] = pointsModel.getElementAt(i).split(";");
                points.add(new Point(Double.valueOf(arrayOfPoint[0]), Double.valueOf(arrayOfPoint[1])));
            }

            FigureCreateHelper.id++;
            figures.put(String.valueOf(FigureCreateHelper.id), FigureCreateHelper.getFigureFactory(points).createFigure(points));

            this.canvas.repaintGraphics(figures);
            pointsListXY.removeAll();
            this.repaint();

        } else if (e.getSource().equals(components.get("changeGroup").get("deleteButton"))) {  //кнопка удаления выбраной фигуры
            String id = FigureCreateHelper.getKeyByFigure(figures, activeFigure);
            if (id != null) {
                figures.remove(id);
                this.repaint();
            }
        } else if (e.getSource().equals(components.get("mainButtons").get("showButton"))) { //кнопка вывода всех фигур
            canvas.repaintGraphics(figures);
            this.repaint();
        } else if (e.getSource().equals(components.get("mainButtons").get("saveButton"))) {  //кнопка сохранения
            saveToFile(figures, Main.file);
        } else if (e.getActionCommand().equals("отменить действия")) {  //кнопка отмены действий
            this.chooseFigureAvailable = false;
            this.panel.remove(cancelChooseButton);
        }
    }
}