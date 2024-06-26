import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import Package.DigitsArrWR;
import Package.DigitsImpl;
import Package.DigitsOfArticle;
import Package.DigitsOfSeries;

class Main
{
    // консольный clear
    // System.out.print("\033[H\033[2J");
    // System.out.flush();

    private static Scanner in = new Scanner(System.in);
    private static DigitsImpl[] digit;
    private static DigitsImpl[][] digitsImpls;

    private static DigitsOfArticle[] digitsOfArticles;
    private static DigitsOfSeries[] digitsOfSeries;
    public static void main(String[] args)
    {
        String userChoice;
        Boolean isDigitsExist = false;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Лабораторная работа №3 студента группы 6201-020302D Никулина Ивана");
        while(true)
        {
            System.out.print("Выберите пункт меню:"
                            +"\n0. Выход"
                            +"\n1. Создать массив объектов типа Digits"
                            +"\n2. Работа с массивом объектов типа Digits"
                            +"\n3. Десериализовать массив"
                            +"\nВыбор: ");
            userChoice = in.next();
            switch (userChoice) {
                case "0":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    return;
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    digit = createArrDigits();
                    isDigitsExist = true;
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    if(isDigitsExist)
                        getMenu();
                    else
                    {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.print("Нельзя перейти в этот пункт, не создав массив или не десериализовав его. Повторите ввод\n");
                    }
                    break;
                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    digit = deserialize();
                    if(digit != null)
                    {
                        isDigitsExist = true;
                    }
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("Такого пункта нет. Повторите ввод\nВыбор: ");
                    break;
            }
        }
    } 
    
    public static DigitsImpl[] createArrDigits()
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
                    result[i] = addDigit("Series");
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    result[i] = addDigit("Article");
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

    public static void printDigit(DigitsImpl[] digit)
    {
        for(int i = 0; i < digit.length; i++)
        {
            if(digit[i] == null)
                break;
            System.out.println("===================================");
            System.out.println(digit[i].toString());
            System.out.println("===================================");
        }
        
    }

    public static void printDigitsArr()
    {
        for(int i = 0; i < digitsImpls.length; i++)
        {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + 
                                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            System.out.println("Массив " + (i+1) + ".");
            printDigit(digitsImpls[i]);
        }
    }

    public static DigitsImpl addDigit(String type)
    {
        // Этот метод должен создавать экземляр класса Статьи или Сочинения 
        String tytle;
        String userChoice;
        char userChar;
        int len;
        int[] blockOfPapers;
        int qualityOfInfPapers;
        DigitsImpl digit;
        String support;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Заполнить элемент автоматически?\n1. Да\n2. Нет");
        userChoice = in.next();
        userChar = userChoice.charAt(0);
        if(userChar == '1')
        {
            if(type == "Series")
            {
                digit = new DigitsOfSeries();
                return digit;
            }
            digit = new DigitsOfArticle();
            return digit;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Введите название: ");
        tytle = in.next();
        support = in.nextLine();
        System.out.print("Сколько элементов вы хотите добавить: ");
        userChoice = in.next();
        len = toInt(userChoice);
        while(len <= 0)
        {
            System.out.print("Элементов не может быть 0 или меньше 0\nСколько элементов вы хотите добавить: ");
            userChoice = in.next();
            len = toInt(userChoice);
        }

        blockOfPapers = new int[len];
        for(int i = 0; i < len; i++)
        {
            System.out.print("Введите количество страниц для " + (i+1) + " элемента: ");
            userChoice = in.next();
            blockOfPapers[i] = toInt(userChoice);
            while(blockOfPapers[i] <= 1)
            {
                System.out.println("Количество страниц не может быть <= 1 (должна быть минимум 1 информационная страница). Повторите ввод.");
                System.out.print("Введите количество страниц для " + (i+1) + " элемента: ");
                userChoice = in.next();
                blockOfPapers[i] = toInt(userChoice);
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("Введите количество информационных страниц: ");
        userChoice = in.next();
        qualityOfInfPapers = toInt(userChoice);
        while(true)
        {
            try
            {
                if(type == "Series")
                {
                    digit = new DigitsOfSeries(tytle, blockOfPapers, qualityOfInfPapers);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Объект список сочинений успешно создан!");
                    return digit;
                }
                digit = new DigitsOfArticle(tytle, blockOfPapers, qualityOfInfPapers);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Объект список статей успешно создан!");
                return digit;
            }
            catch(Exception e)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(e.getMessage());
                System.out.print("Введите количество информационных страниц: ");
                userChoice = in.next();
                qualityOfInfPapers = toInt(userChoice);
            }
        }
    }

    public static DigitsImpl[][] getDigitsImplArr()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        DigitsImpl[][] result;
        int len;

        for(DigitsImpl i: digit)
        {
            if(!list.contains(i.getQuallityOfMainPages()))
            {
                list.add(i.getQuallityOfMainPages());
            }
        }

        len = list.size();
        result = new DigitsImpl[len][];
        for(int i = 0; i < len; i++)
        {
            result[i] = new DigitsImpl[digit.length];
            int k = 0;
            for(int j = 0; j < digit.length; j++)
            {
                if(digit[j].getQuallityOfMainPages() == list.get(i))
                {
                    result[i][k] = digit[j];
                    k++;
                }
            }
        }

        return result;
    }

    public static void getMenu()
    {
        String userChoice;
        while(true)
        {
            System.out.print("Выберите пункт меню:\n"
                            +"0. Выход\n" 
                            +"1. Вывести массив\n"
                            +"2. Найти в массиве объекты, бизнес-метод которых возвращают одинаковый результат, поместить такие объекты в другие массивы и вывести массив\n"
                            +"3. Разбить исходный массив на два массива, в которых будут храниться однотипные элементы\n"
                            +"4. Записать исходный массив в байтовый поток (запись в byteFile.txt)\n"
                            +"5. Чтение из byteFile.txt\n"
                            +"6. Записать исходный массив в символьный поток (запись в symbolFile.txt)\n"
                            +"7. Чтение из symbolFile.txt\n"
                            +"8. Сериализовать массив\n"
                            +"9. Форматировать массив\n" 
                            +"10. Форматированный вывод массива\n" 
                            +"Ваш выбор: "
                            );
            userChoice = in.next();
            switch (userChoice) {
                case "0":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    return;
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    printDigit(digit);
                    break;
                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    digitsImpls = getDigitsImplArr();
                    printDigitsArr();
                    break;
                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    toShareDigits();
                    System.out.println("===================================");
                    System.out.println("/////////Массив статей/////////");
                    System.out.println("===================================");
                    printDigit(digitsOfArticles);
                    System.out.println("===================================");
                    System.out.println("/////////Массив сочинений/////////");
                    System.out.println("===================================");
                    printDigit(digitsOfSeries);
                    break;
                case "4":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    writeBytes();
                    break;
                case "5":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    readBytes();
                    break;
                case "6":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    writeSymbols();
                    break;
                case "7":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    readSymbols();
                    break;
                case "8":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    serialize();
                    break;
                case "9":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    printStream();
                    break;
                case "10":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    readStream();
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("Такого пункта нет. Повторите ввод\nВыбор: ");
                    break;
            }
        }
    }

    private static void toShareDigits()
    {
        DigitsOfArticle objArticle = new DigitsOfArticle();
        int lenArcticle = 0;
        int lenSeries = 0;
        for(DigitsImpl i : digit)
        {
            if(i.getClass() == objArticle.getClass())
            {
                lenArcticle++;
            }
            else
            {
                lenSeries++;
            }
        }

        digitsOfArticles = new DigitsOfArticle[lenArcticle];
        digitsOfSeries = new DigitsOfSeries[lenSeries];
        int j = 0;
        int k = 0;
        for(DigitsImpl i : digit)
        {
            if(i.getClass() == objArticle.getClass())
            {
                digitsOfArticles[j] = (DigitsOfArticle) i;
                j++;
            }
            else
            {
                digitsOfSeries[k] = (DigitsOfSeries) i;
                k++;
            }
        }
    }

    public static void writeBytes()
    {
        OutputStream byteWriter;
        try
        {
            byteWriter = new FileOutputStream("byteFile.txt");
            DigitsArrWR.byteWriter(digit, byteWriter);
            System.out.println("Файл успешно записан!");
        }
        catch(IOException exception)
        {
            System.out.println("Output error");
        }
    }

    public static void readBytes()
    {
        try(FileInputStream stream = new FileInputStream("byteFile.txt"))
        {
            System.out.println(DigitsArrWR.byteReader(stream));
        }
        catch(IOException exception)
        {
            System.out.println("Файл не существует. Создайте файл, перед тем, как из него что-либо прочитать.");
        }   
    }

    public static void writeSymbols()
    {
        Writer fileWriter;
        try
        {
            fileWriter = new FileWriter("symbolFile.txt");
            DigitsArrWR.symbolWriter(digit, fileWriter);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Файл успешно записан!");
        }   
        catch(IOException exception)
        {
            System.out.println("Output error");
        }
    }

    public static void readSymbols()
    {
        try
        {
            FileReader fileReader = new FileReader("symbolFile.txt");
            System.out.println(DigitsArrWR.symbolReader(fileReader));
        }
        catch(IOException exception)
        {
            System.out.println("Input error");
        }

    }

    public static void serialize()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("save.txt");
            
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            DigitsArrWR.serialze(digit, outputStream);
            fileOutputStream.close();
        }
        catch(IOException exception)
        {
            System.out.println("Serialize error");
        }
    }

    public static DigitsImpl[] deserialize()
    {
        try
        {   
            FileInputStream fileInputStream = new FileInputStream("save.txt");
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);

            DigitsImpl[] result = DigitsArrWR.deserialize(objectOutputStream);

            fileInputStream.close();
            return result;
        }  
        catch(IOException exception)
        {
            System.out.println("Deserialize exception");
            return digit;
        }
    }

    public static void printStream()
    {
        Writer fileWriter;
        try
        {
            fileWriter = new FileWriter("printStream.txt");
            DigitsArrWR.printStream(digit, fileWriter);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Файл успешно записан!");
        }   
        catch(IOException exception)
        {
            System.out.println("Output error");
        }
    }

    public static void readStream()
    {
        try
        {
            File doc = new File("printStream.txt");
            Scanner obj = new Scanner(doc);
            DigitsImpl[] newDigit = DigitsArrWR.readFormat(obj);
            printDigit(newDigit);
        }
        catch(Exception exception)
        {
            System.out.println("Файл не существует. Создайте файл перед тем как считывать его");
        }
        
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

