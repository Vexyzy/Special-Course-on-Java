package Package;

import java.io.OutputStream;
import java.io.Writer;

public class DigitSynchronize implements DigitsImpl {

    private DigitsImpl digit;

    public DigitSynchronize(DigitsImpl digit)
    {
        this.digit = digit;
    }

    @Override
    public synchronized int[] getList() {
        return digit.getList();
    }

    @Override
    public synchronized void setList(int[] listQualPapers) {
        digit.setList(listQualPapers);
    }

    @Override
    public synchronized int getLenPaper(int index) {
        return digit.getLenPaper(index);
    }

    @Override
    public synchronized void setLenPaper(int index, int value) {
        digit.setLenPaper(index, value);
    }

    @Override
    public synchronized String getTytle() {
        return digit.getTytle();
    }

    @Override
    public synchronized void setTytle(String tytle) {
        digit.setTytle(tytle);
    }

    @Override
    public synchronized String getType() {
        return digit.getType();
    }

    @Override
    public synchronized int getQuallityOfInfPapers() {
        return digit.getQuallityOfInfPapers();   
    }

    @Override
    public synchronized int getLen() {
       return digit.getLen();
    }

    @Override
    public synchronized int getQuallityOfMainPages() {
        return digit.getQuallityOfMainPages();
    }

    @Override
    public synchronized void byteWriter(OutputStream out) {
        digit.byteWriter(out);
    }

    @Override
    public synchronized void symbolWriter(Writer out) {
        digit.symbolWriter(out);
    }
    
}
