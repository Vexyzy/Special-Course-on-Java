package Package;

/**
 * DigitsImpl
 */
public interface DigitsImpl {

    public int[] getList();
    public void setList(int[] listQualPapers);

    public int getLenPaper(int index);
    public void setLenPaper(int index, int value) throws Exception;

    public String getTytle();
    public void setTytle(String tytle);

    public int getQuallityOfMainPages();

}