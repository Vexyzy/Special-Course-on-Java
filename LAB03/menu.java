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
    private static TextInformationImpl[] arr_of_essays = null;
    private static TextInformationImpl[] arr_of_article = null;
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
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    disintegrateArr();
                    break;
                case "6":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    printDisintegrateArr();
                    break;
                default:
                    System.out.println("Такого пункта в меню нет, повторите ввод: ");
                    break;
            }
        }
    }
    public static void createArr()
    {
        arr_of_textInformation = null;
        arr_bsns_TextInformationImpls = null;
        arr_of_essays = null;
        arr_of_article = null;
        System.out.print("Введите количество статей и сочинений: ");
        userChoice = in.next();
        int arr_len = toInt(userChoice);
        while(arr_len < 0)
        {
            System.out.println("Длина массива не может быть отрицательной, повторите ввод: ");
            userChoice = in.next();
            arr_len = toInt(userChoice);
        }
        boolean isChosen = false;

        arr_of_textInformation = new TextInformationImpl[arr_len];
        for(int i = 0; i < arr_len; i++)
        {
            String support = String.format("Выберите каким будет %d элемент:\n1. Сочинение\n2. Статья", i+1);
            System.out.println(support);
            while(!isChosen)
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
                                String title = in.nextLine();
                                String support_line = in.nextLine();
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
                        isChosen = true;
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
                                String title = in.nextLine();
                                System.out.print("Введите количество статей в сборнике: ");
                                String support_line = in.nextLine();
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
                        isChosen = true;
                        break;
                    default:
                        System.out.println("Такого пункта в меню нет, повторите ввод: ");
                        break;
                }
            }
            isChosen = false;
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
        for(int i = 0; i < arr_of_textInformation.length - 1; i++)
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
        for(int i = 0; i < arr_bsns_TextInformationImpls.length; i++)
        {
            if(arr_bsns_TextInformationImpls[i].length == 1)
            {
                arr_bsns_TextInformationImpls[i] = null;
            }
        }
    }
    public static void printArrBsns()
    {
        if(arr_bsns_TextInformationImpls == null || arr_bsns_TextInformationImpls.length == 0)
        {
            System.out.println("Массива не существует!");
            return;
        }
        for(int i = 0; i < arr_bsns_TextInformationImpls.length; i++)
        {
            for(int j = 0; j < arr_bsns_TextInformationImpls[i].length; j++)
            {
                if(arr_bsns_TextInformationImpls[i] != null)
                {
                    System.out.println("Элемент " + (i+1) + "-го массива:\n" + arr_bsns_TextInformationImpls[i][j].toString());
                }
            }
        }
        System.out.print("Введите любую строку для продолжения: ");
        String support = in.next();
    }
   
   public static void disintegrateArr()
   {
    if(arr_of_textInformation == null || arr_of_textInformation.length == 0)
        {
            System.out.println("Массива не существует!");
            return;
        }
        int quantityOfEssays = 0;
        int quantityOfArticles = 0;
   

        for(int i = 0; i < arr_of_textInformation.length; i++)
        {
            if(arr_of_textInformation[i] instanceof DigitsOfArticle)
            {
                quantityOfArticles++;
            }
            else
            {
                quantityOfEssays++;
            }
        }  
        arr_of_essays = new TextInformationImpl[quantityOfEssays];
        arr_of_article = new TextInformationImpl[quantityOfArticles];

        int j = 0;
        for(int i = 0; i < arr_of_textInformation.length; i++)
        {
            if(j == quantityOfEssays)
            {
                break;
            }
            if(arr_of_textInformation[i] instanceof SeriesOfEssays)
            {
                arr_of_essays[j] = arr_of_textInformation[i];
                j++;
            }
        }
        j = 0;
        for(int i = 0; i < arr_of_textInformation.length; i++)
        {
            if(j == quantityOfArticles)
            {
                break;
            }
            if(arr_of_textInformation[i] instanceof DigitsOfArticle)
            {
                arr_of_article[j] = arr_of_textInformation[i];
                j++;
            }
        }
        printDisintegrateArr();
    }

    public static void printDisintegrateArr()
    {
        if(arr_of_essays == null || arr_of_article == null)
        {
            System.out.println("Сначала выполните 5 пункт.");
            return;
        }
        if((arr_of_essays != null && arr_of_article == null) || (arr_of_essays.length != 0 && arr_of_article.length == 0))
        {
            System.out.println("Массив статей пуст. Будет выведен исходный массив.");
            printArr();
            return;
        }
        if((arr_of_article != null && arr_of_essays == null) || (arr_of_article.length != 0 && arr_of_essays.length == 0))
        {
            System.out.println("Массив сочинений пуст. Будет выведен исходный массив.");
            printArr();
            return;
        }
        System.out.println("Массив сочинений: ");
        for(int i = 0; i < arr_of_essays.length; i++)
        {
            System.out.println(arr_of_essays[i].toString());
            System.out.println();
        }

        System.out.println("Массив статей: ");
        for(int i = 0; i < arr_of_article.length; i++)
        {
            System.out.println(arr_of_article[i].toString());
            System.out.println();
        }
        System.out.print("Введите любую строку для продолжения: ");
        String support = in.next();
    }
    org.omg.stub;
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
