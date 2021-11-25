package Windows;

import com.company.Rectangle;

import javax.swing.*;

public class Windows {

    public static class ContentPaneReplace extends JFrame {
        private static final long serialVersionUID = 1L;

        public ContentPaneReplace() {
            super("Figure");
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            // Создание панели
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Выберите нужный пункт меню:");
            panel.add(label);
            panel.add(new JButton("1. Вывести все фигуры"));
            panel.add(new JButton("2. Добавить фигуру"));
            panel.add(new JButton("3. Изменить фигуру"));
            panel.add(new JButton("4. Удалить фигуру"));
            panel.add(new JButton("5. Сохранить файл"));

            // определение местоположения фигур в окне

            // Замена панели содержимого
            setContentPane(panel);

            // Определение размера окна
            setSize(280, 400);

            // Открытие окна
            setVisible(true);
        }

        public static void main(String[] args) {
            JFrame.setDefaultLookAndFeelDecorated(true);
            new ContentPaneReplace();
        }
    }
}