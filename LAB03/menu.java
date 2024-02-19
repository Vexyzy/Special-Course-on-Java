import java.lang.Package.*;
import java.util.ArrayList;
import java.util.Scanner;

import Package.DigitsOfArticle;
import Package.SeriesOfEssays;
import Package.TextInformationImpl;

public class menu
{
    private static Scanner in = new Scanner(System.in);
    private static String userChoice;
    private static TextInformationImpl[] arr_of_textInformation = null;
    private static TextInformationImpl[][] arr_bsns_TextInformationImpls = null;
    public static void main(String[] objects)
    {
        System.out.println("Лабораторная работа №3\nСтудента группы 6201-020302D\n");
        while(true)
        {
            System.out.println("Выберите пункт меню:\n0. Выход из программы\n1. Создать массив сочинений и статей\n2. Вывести полную информацию обо всех объектах массива\n3. Найти в массивах объекты с одинаковыми выходными данными бизнес-метода и поместить их в новый массив\n4. Вывести массив с одинакомы выходными данными бизнес-метода\n5. Разбить основной массив на 2 массива по типу данных\n6. Вывести массивы предыдущего пункта");
            userChoice = in.next();
            switch (userChoice) {
                case "0":
                    return;
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    createArr();
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    printArr();
                    break;
                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    bsnsArr();
                    break;
                case "4":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    printArrBsns();
                    break;
                case "5":
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Такого пункта в меню нет, повторите ввод: ");
                    break;
            }
        }
    }
    public static void createArr()
    {
        System.out.print("Введите количество статей и сочинений: ");
        userChoice = in.next();
        int arr_len = toInt(userChoice);
        while(arr_len < 0)
        {
            System.out.println("Длина массива не может быть отрицательной, повторите ввод: ");
            userChoice = in.next();
            arr_len = toInt(userChoice);
        }
        boolean isChoosen = false;

        arr_of_textInformation = new TextInformationImpl[arr_len];
        for(int i = 0; i < arr_len; i++)
        {
            String support = String.format("Выберите каким будет %d элемент:\n1. Сочинение\n2. Статья", i+1);
            System.out.println(support);
            while(!isChoosen)
            {
                userChoice = in.next();
                switch (userChoice) {
                    case "1":
                        System.out.println("Выберите пунтк:\n1. Заполнить автоматески\n2. Заполнить вручную");
                        userChoice = in.next();
                        switch (userChoice) {
                            case "1":
                                arr_of_textInformation[i] = new SeriesOfEssays();
                                System.out.println("Объект успешно добавлен");
                                break;
                            case "2":
                                System.out.print("Введите название серии: ");
                                String title = in.next();
                                System.out.print("Введите количество сочинений в серии: ");
                                userChoice = in.next();
                                int quality_of_essays = toInt(userChoice);
                                int[] quality_of_pages = new int[quality_of_essays];
                                for(int j = 0; j < quality_of_essays; j++)
                                {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    support = String.format("Введите количество страниц в %d сочинении: ", j+1);
                                    System.out.print(support);
                                    userChoice = in.next();
                                    quality_of_pages[j] = toInt(userChoice);
                                    while(quality_of_pages[j] <= 1)
                                    {
                                        System.err.print("Количество страниц не может быть <= 1\nПовторите ввод: ");
                                        userChoice = in.next();
                                        quality_of_pages[j] = toInt(userChoice);
                                    }
                                }
                                System.out.print("Введите количество информационных страниц: ");
                                userChoice = in.next();
                                int quality_of_minor_pages = toInt(userChoice);
                                while (true) {
                                    try
                                    {
                                        arr_of_textInformation[i] = new SeriesOfEssays(quality_of_pages, title, quality_of_minor_pages);
                                        break;
                                    }
                                    catch(Exception e)
                                    {
                                        System.err.println(e.getMessage().toString());
                                        System.out.print("Повторите ввод: ");
                                        userChoice = in.next();
                                        quality_of_minor_pages = toInt(userChoice);
                                    }
                                }
                                break;
                            default:
                                arr_of_textInformation[i] = new SeriesOfEssays();
                                System.out.println("Такого пункта в меню нет. Объект будет добавлен автоматически");
                                break;
                        }
                        isChoosen = true;
                        break;
                    case "2":
                        System.out.println("Выберите пунтк:\n1. Заполнить автоматески\n2. Заполнить вручную");
                        userChoice = in.next();
                        switch (userChoice) {
                            case "1":
                                arr_of_textInformation[i] = new DigitsOfArticle();
                                System.out.println("Объект успешно добавлен");
                                break;
                            case "2":
                                System.out.print("Введите название сборника статей: ");
                                String title = in.next();
                                System.out.print("Введите количество статей в сборнике: ");
                                userChoice = in.next();
                                int quality_of_essays = toInt(userChoice);
                                int[] quality_of_pages = new int[quality_of_essays];
                                for(int j = 0; j < quality_of_essays; j++)
                                {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    support = String.format("Введите количество страниц в %d статьи: ", j+1);
                                    System.out.print(support);
                                    userChoice = in.next();
                                    quality_of_pages[j] = toInt(userChoice);
                                    while(quality_of_pages[j] <= 1)
                                    {
                                        System.err.print("Количество страниц не может быть <= 1\nПовторите ввод: ");
                                        userChoice = in.next();
                                        quality_of_pages[j] = toInt(userChoice);
                                    }
                                }
                                System.out.print("Введите количество информационных страниц: ");
                                userChoice = in.next();
                                int quality_of_minor_pages = toInt(userChoice);
                                while (true) {
                                    try
                                    {
                                        arr_of_textInformation[i] = new DigitsOfArticle(quality_of_pages, title, quality_of_minor_pages);
                                        break;
                                    }
                                    catch(Exception e)
                                    {
                                        System.err.println(e.getMessage().toString());
                                        System.out.print("Повторите ввод: ");
                                        userChoice = in.next();
                                        quality_of_minor_pages = toInt(userChoice);
                                    }
                                }
                                break;
                            default:
                            arr_of_textInformation[i] = new DigitsOfArticle();
                                System.out.println("Такого пункта в меню нет. Объект будет добавлен автоматически");
                                break;
                        }
                        isChoosen = true;
                        break;
                    default:
                        System.out.println("Такого пункта в меню нет, повторите ввод: ");
                        break;
                }
            }
            isChoosen = false;
        }
    }
    
    public static void printArr()
    {
        if(arr_of_textInformation == null || arr_of_textInformation.length == 0)
        {
            System.out.println("Массива не существует!");
            return;
        }
        System.err.println("===\n");
        for(int i = 0; i < arr_of_textInformation.length; i++)
        {
            System.out.println(i+1 + " элемент.\n" + arr_of_textInformation[i].toString() + "\n===\n");
        }
        System.out.print("Напишите любую строку для возвращение в меню: ");
        userChoice = in.next();
    }

    public static void bsnsArr()
    {
        ArrayList<Integer> list_of_duplicate_values = new ArrayList<Integer>();
        int counter = 0;
        
        if(arr_of_textInformation == null || arr_of_textInformation.length == 0)
        {
            System.out.println("Массива не существует!");
            return;
        }
        System.out.println("===\n");
        for(int i = 0; i < arr_of_textInformation.length; i++)
        {
            for(int j = 1; j < arr_of_textInformation.length; j++)
            {
                if(arr_of_textInformation[i].getQualityOfMainPages() == arr_of_textInformation[j].getQualityOfMainPages())
                {
                    if(!list_of_duplicate_values.contains(arr_of_textInformation[i].getQualityOfMainPages()))
                    {
                        list_of_duplicate_values.add(arr_of_textInformation[i].getQualityOfMainPages());
                    }
                }
            }
        }
        arr_bsns_TextInformationImpls = new TextInformationImpl[list_of_duplicate_values.size()][];
        for(int i = 0; i < list_of_duplicate_values.size(); i++)
        {
            for(int j = 0; j < arr_of_textInformation.length; j++)
            {
                if(arr_of_textInformation[j].getQualityOfMainPages() == list_of_duplicate_values.get(i))
                {
                    counter++;
                }
            }
            arr_bsns_TextInformationImpls[i] = new TextInformationImpl[counter];
            int k = 0;
            for(int j = 0; j < arr_of_textInformation.length; j++)
            {
                if(arr_of_textInformation[j].getQualityOfMainPages() == list_of_duplicate_values.get(i))
                {
                    arr_bsns_TextInformationImpls[i][k] = arr_of_textInformation[j];
                    k++;
                }
            }
            k=0;
            counter = 0;
        }
    }
    public static void printArrBsns()
    {
        for(int i = 0; i < arr_bsns_TextInformationImpls.length; i++)
        {
            for(int j = 0; j < arr_bsns_TextInformationImpls[i].length; j++)
            {
                System.out.println("Элемент" + (i+1) + "-го массива:\n" + arr_bsns_TextInformationImpls[i][j].toString());
            }
        }
    }
    public static int toInt(String value)
    {
        int result;
        while(true)
        {
            try
            {
                result = Integer.parseInt(value);  
                return result;
            }
            catch(NumberFormatException e)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("Вы ввели не число!\nПовторите ввод: ");
                value = in.next();
            }
        }
    }
}
