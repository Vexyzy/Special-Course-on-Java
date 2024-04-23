package RunnableThreads;

import java.util.Random;

public class ReadRunnableThread implements Runnable{
    
    private Synchronizer object;
    private Random random = new Random();

    public ReadRunnableThread(Synchronizer object)
    {
        this.object = object;
    }

    @Override
    public void run()
    {
        while(object.canWrite())
            try {
                object.write(random.nextInt(100) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
