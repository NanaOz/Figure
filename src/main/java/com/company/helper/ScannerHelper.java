package com.company.helper;

import com.company.Figure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Scanner;

public class ScannerHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final static Scanner READER = new Scanner(System.in);

    /**
     * @param text Метод для ввода ТОЛЬКО числа(double)
     */
    public static double getDoubleFromInput(String text) {
        boolean ifInputError = true;
        double number = 0;
        System.out.print(text);
        while (ifInputError) {    // цикл заставляет вводить только числа, не выводя ошибку InputMismatchException
            if (READER.hasNextDouble()) {
                number = READER.nextDouble();
                ifInputError = false;
            }
            else {
                System.out.print("Произошла ошибка при попытки ввода. Пожалуйста, введите число! " + text);
                READER.next();
            }
        }
        return number;
    }


    /**
     * @param text Метод для ввода ТОЛЬКО числа (int)
     */
    public static int getIntFromInput(String text) {
        boolean ifInputError = true;
        int number = 0;
        System.out.print(text);
        while (ifInputError) {    // цикл заставляет вводить только числа, не выводя ошибку InputMismatchException
            if (READER.hasNextInt()) {
                number = READER.nextInt();
                ifInputError = false;
            }
            else {
                System.out.print("Произошла ошибка при попытки ввода. Пожалуйста, введите число! " + text);
                READER.next();
            }
        }
        return number;
    }

    /**
     * @param text пользователь вводит "ДА"
     */
    public static boolean isYes(String text) {
        System.out.print(text);
        String answer = READER.next().toLowerCase().trim().replaceAll("\\p{P}", "");
        return "y".equals(answer) || "yes".equals(answer) || "да".equals(answer);
    }

    /**
     * Закрывает сканнер
     */
    public static void close() {
        READER.close();
    }

    public static String readString(){
        try{
            return bufferedReader.readLine();
        }
        catch (IOException e){
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }
    }

    public static int readInt(){
        try{
            return Integer.parseInt(readString());
        }
        catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readInt();
        }
    }

    public static double readDouble(){
        try{
            return Double.parseDouble(readString());
        }
        catch (NumberFormatException e){
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            return readDouble();
        }
    }
}
