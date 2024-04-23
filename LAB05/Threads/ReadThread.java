package Threads;

import java.util.Random;

import Package.DigitsImpl;

public class ReadThread extends Thread{
    
    private DigitsImpl object;
    private int value;
    private Random random = new Random();

    public ReadThread(DigitsImpl object)
    {
        this.object = object;
    }

    @Override
    public void run()
    {
        for(int i = 0; i < object.getLen(); i++)
        {
            System.out.printf("\nRead: %d from position %d", object.getLenPaper(i), i);
        }
    }
}