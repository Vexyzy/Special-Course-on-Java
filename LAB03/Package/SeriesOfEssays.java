package Package;

public class SeriesOfEssays implements TextInformationImpl
{
    private int[] quality_of_page;
    private String title;
    private int quality_of_minor_pages;
    private int min_quality_of_page;

    //Конструктор без параматров
    public SeriesOfEssays()
    {
        quality_of_page = new int[] {10, 10, 10, 10, 10};
        title = "None";
        quality_of_minor_pages = 1;
    }
    //Конструктор с параметрами
    public SeriesOfEssays(int[] quality_of_page, String title, int quality_of_minor_pages) throws Exception
    {
        if(quality_of_minor_pages <= 0)
        {
            throw new Exception("Количество информационных страниц не может быть <= 0");
        }
        min_quality_of_page = quality_of_page[0];
        for(int i = 1; i < quality_of_page.length; i++)
        {
            if(quality_of_page[i] < min_quality_of_page)
            {
                min_quality_of_page = quality_of_page[i];
            }
        }
        if(quality_of_minor_pages >= min_quality_of_page)
        {
            throw new Exception("Число страниц не может превышать или быть равным минимальному числу страниц в одном из сочинений");
        }
        this.quality_of_page = quality_of_page;
        this.title = title;
        this.quality_of_minor_pages = quality_of_minor_pages;
    }
    //Получение количества книг
    public int getQualityOfExamples()
    {
        return quality_of_page.length;
    }
    //Гетер и сеттер для массива количества страниц
    public int getQualityOfPages(int index) throws IndexOutOfBoundsException
    {
        if(index < 0 || index >= quality_of_page.length)
        {
            String error_msg = String.format("Индекс не может быть меньне 0 и больше %d", quality_of_page.length - 1);
            throw new IndexOutOfBoundsException(error_msg);
        }
        return quality_of_page[index];
    }
    public void setQualityOfPages(int index, int quality_of_page) throws Exception
    {   
        if(quality_of_page <= 1)
        {
            throw new Exception("Количество страниц не может быть <= 1");
        }
        if(quality_of_page < min_quality_of_page)
        {
            min_quality_of_page = quality_of_page;
        }
        if(index < 0 || index >= this.quality_of_page.length)
        {
            String error_msg = String.format("Индекс не может быть меньше 0 и больше %d", this.quality_of_page.length-1);
            throw new Exception(error_msg);
        }
        this.quality_of_page[index] = quality_of_page;
    }
    //Геттер и сеттер для названия серии
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    //Геттер и сеттер для количества информационных строк
    public int getQualityOfMinorPages()
    {
        return quality_of_minor_pages;
    }
    public void setQualityOfMinorPages(int quality_of_minor_pages) throws Exception
    {
        if(quality_of_minor_pages <= 0)
        {
            throw new Exception("Количество информационных страниц не может быть <= 0");
        }
        if(quality_of_minor_pages >= min_quality_of_page)
        {
            throw new Exception("Количество информационных страниц не может быть больше или равно количеству основных");
        }
        this.quality_of_minor_pages = quality_of_minor_pages;
    }

    //бизнес-метод подсчета общего числа страниц без учета информационных 
    public int getQualityOfMainPages()
    {
        int quality = 0;
        for(int i=0; i<quality_of_page.length; i++)
        {
            quality += quality_of_page[i] - quality_of_minor_pages;
        }
        return quality;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        String support_string;

        stringBuilder.append("Название сборника сочинений: " + title + "\n");
        stringBuilder.append("Количество сочинений в сборнике: " + quality_of_page.length + "\n");
        stringBuilder.append("Информационных страниц: " + quality_of_minor_pages + "\n");
        stringBuilder.append("Всего страниц без учета информационных: " + getQualityOfMainPages() + "\n");
        for(int i = 0; i < quality_of_page.length; i++)
        {
            support_string = String.format("Количество страниц в сочинении %d: %d\n", i+1, quality_of_page[i]);
            stringBuilder.append(support_string);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object object)
    {
        boolean isEquals = false;
        if(object != null && object.getClass() == this.getClass())
        {
            SeriesOfEssays obEssays = (SeriesOfEssays)object;
            if(obEssays.getTitle() ==  this.getTitle() && 
            obEssays.getQualityOfMinorPages() == this.getQualityOfMinorPages() &&
            obEssays.getQualityOfExamples() == this.getQualityOfExamples())
            {
                for(int i = 0; i < obEssays.getQualityOfExamples(); i++)
                {
                    if(obEssays.getQualityOfPages(i) != this.getQualityOfPages(i))
                    {
                        return isEquals;
                    }
                }
                isEquals = true;
                return isEquals;
            }
        }
        return isEquals;
    }
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }
}