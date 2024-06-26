package Package;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class DigitsOfSeries implements DigitsImpl {
    
    private int[] listQualPapers;
    private String tytle;
    private int qualOfInfoPapers;

    

    private String type = "Digits of series";
    
    public DigitsOfSeries(String tytle, int[] listQualPapers, int qualOfInfoPapers) {

        int min = listQualPapers[0];
        for(int i = 1; i < listQualPapers.length; i++)
        {
            if(listQualPapers[i] < min)
            {
                min = listQualPapers[i];
            }
        }
        if(qualOfInfoPapers < 0)
        {
            throw new RuntimeException("Значение информационных страниц не может быть отрицательно");
        }
        if(qualOfInfoPapers >= min)
        {
            throw new RuntimeException("Значение информационных страниц не может быть >= " + min);
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
    public void setLenPaper(int index, int value)
    {
        if(value <= 0)
        {
            throw new RuntimeException("Значение не может быть <= 0");
        }
        if(value <= qualOfInfoPapers)
        {
            throw new RuntimeException("Значение не может быть <= " + qualOfInfoPapers);
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

    public String getType()
    {
        return type;
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

    public boolean equals(Object o){
        if(o != null && o.getClass() == this.getClass())
        {
            DigitsOfSeries digit = (DigitsOfSeries)o;
            if(this.getTytle() == digit.getTytle()
            && this.getType() == digit.getType()
            && this.getList().length == digit.getList().length
            && this.getQuallityOfMainPages() == digit.getQuallityOfMainPages())
            {
                for(int i = 0; i < this.getList().length; i++){
                    if(this.getLenPaper(i) != digit.getLenPaper(i))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return getList().hashCode() + getType().hashCode() + super.hashCode();
    }

    @Override
    public String toString()
    {
        String line = String.format("Type of element: %s\nTytle: %s\nArray of papers: [", type, tytle);
        for(int i = 0; i < listQualPapers.length - 1; i++) 
        {
            line += Integer.toString(listQualPapers[i]) + ", ";
        }
        line += Integer.toString(listQualPapers[listQualPapers.length - 1]) + "]\n";
        line += "Quallity of information papers: " + Integer.toString(qualOfInfoPapers) + '\n';
        line += "Result buiseness method: " + Integer.toString(getQuallityOfMainPages());
        line += '\n';

        return line;
    }
}
