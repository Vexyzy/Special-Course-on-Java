package Package;


public interface TextInformationImpl {
    public int getQualityOfPages(int index);
    public void setQualityOfPages(int index, int pages) throws Exception;
    public String getTitle();
    public void setTitle(String title);
    public int getQualityOfMinorPages();
    public void setQualityOfMinorPages(int pages) throws Exception;
    public int getQualityOfMainPages();
}