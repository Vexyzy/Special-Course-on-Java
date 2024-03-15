import java.util.Scanner;

import Package.DigitsImpl;
import Package.DigitsOfSeries;

class Main
{
    // консольный clear
    // System.out.print("\033[H\033[2J");
    // System.out.flush();

    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        String userChoice;
        Boolean isDigitsExist = false;

        System.out.println("Лабораторная работа №3 студента группы 6201-020302D Никулина Ивана");
        while(true)
        {
            System.out.print("Выберите пункт меню:\n0. Выход\n1. Создать массив объектов типа Digits\n2. Работа с массивом объектов типа Digits\nВыбор: ");
            userChoice = in.next();
            switch (userChoice) {
                case "0":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    return;
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    isDigitsExist = true;
                    createArr();
                    break;
                case "2":
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("Такого пункта нет. Повторите ввод\nВыбор: ");
                    break;
            }
        }
    } 
    
    public static DigitsImpl[] createArr()
    {
        // This method create array of DigitsImpl[] of DigitsOfArticle and DigitsOfSeries
        int len;
        String userChoice;
        DigitsImpl[] result;

        System.out.print("Введите количество элементов массива: ");
        userChoice = in.next();
        len = toInt(userChoice);

        while(len <= 0)
        {
            System.out.print("Размерность массива не может быть <= 0\nВведите количество элементов массива: ");
            userChoice = in.next();
            len = toInt(userChoice);
        }

        result = new DigitsImpl[len];

        for(int i = 0; i < len; i++)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Выберите элемент для добавления: \n1. Массив сочинений\n2. Массив статей\nВаш выбор: ");
            userChoice = in.next();
            switch (userChoice) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Такого выбора не было предоставлено. Автоматически был создан массив сочинений");
                    break;
            }
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        return result;
    }


    public static void addPapers(DigitsImpl digit)
    {
        // Этот метод должен создавать экземляр класса Статьи или Сочинения 
        String tytle;
        int[] blockOfPapers;
        int quaalityOfInfPapers;
        

    }

    public static int toInt(String userString)
    {
        int result;
        while(true)
        {
            try
            {
                result = Integer.parseInt(userString);
                return result;
            }
            catch (Exception e)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("Вы ввели не число\nПовторите ввод: ");
                userString = in.next();
            }
        }
    }
}