import java.util.Scanner;

import Packages.Vector;

public class Main {

    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Лабораторная работа №2\nВыполнил студент группы - 6201-020302D\nНикулин Иван");
            System.out.println("Выберите пункт меню:\n0. Выйти из программы\n1. Работа с вектором\n2. Операции над векторами");
            String user_choice = in.next();
            switch (user_choice) {
                case "0":
                    return;
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    work_with_vector();
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    operations__vectors();
                    break;
                default:
                    System.out.print("Такого пунтка нет в меню, повторите ввод: ");
                    break;
            }
        }
    }
    private static Vector get__vector()
    {
        int vector_length;
        double element_value;
        Vector vector;

        System.out.print("Введите размерность (длину) вектора: ");
        vector_length = in.nextInt();

        vector = new Vector(vector_length);
        for(int i = 0; i < vector_length; i++)
        {
            System.out.print(String.format("Введите значение для %d элемента: ", i+1));
            element_value = in.nextDouble();
            vector.setElement(i, element_value);
        }
        
        return vector;
    }
    private static void work_with_vector()
    {
        Vector vector = get__vector();
        while(true)
        {
            System.out.println("\nВыберите пункт меню:\n0. Выход\n1. Вывести вектор\n2. Изменить элемент(ы) вектора\n3. Отсортировать по возрастанию вектор\n4. Умножить на число вектор\n5. Вычислить максимальное и минимальное значение вектора\n6. Найти евклидову норму вектора");
            String user_choice = in.next();
            switch (user_choice) {
                case "0":
                    return;
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    print__vector(vector);
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    change__vector_element(vector);
                    break;
                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    sort__vector(vector);
                    break; 
                case "4":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    mull__vector(vector);
                    break;
                case "5":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    min_max__vector(vector);
                    break;
                case "6":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    norm__vector(vector);
                    break;
                default:
                    System.out.println("Такого пункта нет в меню. Повторите ввод. ");
                    break;
            }
        }
    }
    private static void print__vector(Vector vector)
    {
        System.out.print("Элементы вектора: [");
        for(int i = 0; i < vector.getLength(); i++)
        {
            if(i == vector.getLength()-1)
                System.out.print(vector.getElement(i));
            else
                System.out.print(vector.getElement(i) + " ");
        }
        System.out.println("]\nДлина вектора: " + vector.getLength());
    }
    private static void change__vector_element(Vector vector)
    {
        int index;
        double value;
        print__vector(vector);
        System.out.print("Ввведите номер элемента, который хотите изменить (отсчёт начинается с 0): ");
        index = in.nextInt();
        System.out.print("Выбран элемент №"+ index + ". Его текущее значение: " + vector.getElement(index) + "\nВведите новое значение: ");
        value = in.nextDouble();

        vector.setElement(index, value);
        System.out.println("Значение элемента с №" + index + " успешно изменено на " + value);
    }
    private static void sort__vector(Vector vector)
    {
        vector.sort();
        System.out.println("Вектор успешно отсортирован!");
        print__vector(vector);
    }
    private static void mull__vector(Vector vector)
    {
        double value;
        System.out.print("Введите чиcло, на которое будет умножен вектор: ");
        value = in.nextDouble();
        vector.mulVector(value);
        System.out.println("Вектор успешно умножен на число " + value);
        print__vector(vector);
    }
    private static void min_max__vector(Vector vector)
    {
        print__vector(vector);
        System.out.print("Минимальный элемент вектора: " + vector.min_and_max_values()[0]);
        System.out.println(" Максимальный элемент вектора: " + vector.min_and_max_values()[1]);
    }
    private static void norm__vector(Vector vector)
    {
        System.out.print("Евклидова величина вектора: " + vector.getNorm());
    }

    private static void operations__vectors()
    {
        System.out.println("Ввод первого вектора: ");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Vector firstVector = get__vector();
        System.out.println("Ввод второго вектора: ");
        Vector secondVector = get__vector();
        String user_choice;

        while(true)
        {
            System.out.println("\nВыберите пункт меню:\n0. Выход\n1. Вывести вектора\n2. Сложить два вектора\n3. Найти скалярное произведения двух векторов");
            user_choice = in.next();
            switch (user_choice) {
                case "0":
                    return;
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Первый вектор: ");
                    print__vector(firstVector);
                    System.out.println("Второй вектор: ");
                    print__vector(secondVector);
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Сумма векторов: ");
                    print__vector(summ_vectors(firstVector, secondVector));
                    break;
                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    if(scalar_vectors(firstVector, secondVector) == -1)
                    {
                        System.out.println("Скалярное произведение векторов невозможно посчитать");
                    break;
                    }
                    System.out.println("Скалярное произведение векторов: " + scalar_vectors(firstVector, secondVector));
                    break;
                default:
                    System.out.print("Такого пунтка нет в меню, повторите ввод: ");
                    break;
            }
        }
    }
    private static Vector summ_vectors(Vector vector1, Vector vector2)
    {
        Vector vector = Vector.getSumVectors(vector1, vector2);
        return vector;
    }

    private static double scalar_vectors(Vector vector1, Vector vector2)
    {
        double value = Vector.getMultiplyVector(vector1, vector2);
        return value;
    }
}