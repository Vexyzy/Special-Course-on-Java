package Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;

public class DigitsArrWR {
    
    public static void byteWriter(DigitsImpl[] digit, OutputStream out)
    {   
        for(DigitsImpl i : digit)
        {
            i.byteWriter(out);
        }
    }

    public static String byteReader(InputStream stream)
    {
        int symbol;
        String line = "";
        try
        {
            while((symbol = stream.read()) != -1)
            {
                line += ((char) symbol);
            }

            return line;
        }
        catch(IOException exception)
        {
            return "Input error";
        }
    }

    public static void symbolWriter(DigitsImpl[] digit, Writer out)
    {
        for(DigitsImpl i : digit)
        {
            i.symbolWriter(out);
        }
    }

    public static String symbolReader(FileReader fileReader)
    {
        BufferedReader reader = new BufferedReader(fileReader);
        String resultLine = "";
        try
        {
            String line = reader.readLine();
            while(line != null)
            {
                resultLine += line + '\n';
                line = reader.readLine();
            }
            return resultLine;
        }
        catch(IOException exception)
        {
            return "Input error";
        }
    }

    public static void serialze(DigitsImpl[] digit, ObjectOutputStream out)
    {
        try
        {
            out.writeInt(digit.length);
            for(DigitsImpl i : digit)
            {
                out.writeObject(i);
            }
        }
        catch(IOException exception)
        {
            //LOG
            System.out.println("Serialize error");
        }
    }

    public static DigitsImpl[] deserialize(ObjectInputStream inputStream)
    {
        DigitsImpl[] result;
        try
        {
            int len = inputStream.readInt();
            result = new DigitsImpl[len];
            for(int i = 0; i < len; i++)
            {
                result[i] = (DigitsImpl)inputStream.readObject();
            }
            return result;
        }
        catch(IOException exception)
        {
            System.out.println("Serialize exception");
            return null;
        }
        catch(ClassNotFoundException exception)
        {
            System.out.println("Class not found");
            return null;
        }
    }
}




