package Package;

import java.util.EmptyStackException;

import javax.swing.border.EmptyBorder;

public class DigitsOfSeries implements DigitsImpl {
    
    private int[] listQualPapers;
    private String tytle;
    private int qualOfInfoPapers;
    
    public DigitsOfSeries(String tytle, int[] listQualPapers, int qualOfInfoPapers) throws Exception {

        int min = listQualPapers[0];
        for(int i = 1; i < listQualPapers.length; i++)
        {
            if(i < min)
            {
                min = i;
            }
        }
        if(qualOfInfoPapers < 0)
        {
            throw new Exception("Значение информационных страниц не может быть отрицательно");
        }
        if(qualOfInfoPapers >= min)
        {
            throw new Exception("Значение информационных страниц не может быть >= " + min);
        }
        this.tytle = tytle;
        this.listQualPapers = listQualPapers;
        this.qualOfInfoPapers = qualOfInfoPapers;
    }

    public DigitsOfSeries()
    {
        this.tytle = "NO_TYTLE";
        this.listQualPapers = new int[5];
        for(int i = 0; i < this.listQualPapers.length; i++)
        {
            listQualPapers[i] = 10;
        }
        this.qualOfInfoPapers = 2; 
    }

    public int[] getList()
    {
        return listQualPapers;
    }
    public void setList(int[] listQualPapers)
    {
        this.listQualPapers = listQualPapers;
    }

    public int getLenPaper(int index)
    {
        return listQualPapers[index];
    }
    public void setLenPaper(int index, int value) throws Exception
    {
        if(value <= 0)
        {
            throw new Exception("Значение не может быть <= 0");
        }
        if(value <= qualOfInfoPapers)
        {
            throw new Exception("Значение не может быть <= " + qualOfInfoPapers);
        }
        listQualPapers[index] = value;
    }

    public String getTytle()
    {
        return this.tytle;
    }
    public void setTytle(String tytle)
    {
        this.tytle = tytle;
    }

    public int getQuallityOfMainPages()
    {
        // Метод подсчитывает общее количество страниц без учета информационных
        int result = 0;
        for(int i : listQualPapers)
        {
            result = result + i - qualOfInfoPapers;
        }
        return result;
    }
}
