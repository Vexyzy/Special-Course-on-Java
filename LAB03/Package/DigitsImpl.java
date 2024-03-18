package Package;

import java.io.OutputStream;
import java.io.Writer;

/**
 * DigitsImpl
 */
public interface DigitsImpl {

    public int[] getList();
    public void setList(int[] listQualPapers);

    public int getLenPaper(int index);
    public void setLenPaper(int index, int value);

    public String getTytle();
    public void setTytle(String tytle);
    public String getType();

    public int getQuallityOfMainPages();
    
    public void byteWriter(OutputStream out);
    public void symbolWriter(Writer out);
    
    // public void simbolWriter(Writer out);
    @Override
    public String toString();
}