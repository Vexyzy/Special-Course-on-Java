package Threads;

import java.util.Random;

import Package.DigitsImpl;

public class WriteThread extends Thread{
    
    private DigitsImpl object;
    private int value;
    private Random random = new Random();

    public WriteThread(DigitsImpl object)
    {
        this.object = object;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < object.getLen(); i++)
        {
            value = random.nextInt(100) + 1;
            object.setLenPaper(i, value);
            System.out.printf("\nWrite: %d to position %d", value, i);
        }
    }
}
