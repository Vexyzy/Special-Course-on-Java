package RunnableThreads;

public class WriteRunnableThread implements Runnable{


    private Synchronizer object;

    public WriteRunnableThread(Synchronizer object)
    {
        this.object = object;
    }

    @Override
    public void run()
    {
        while(object.canRead())
            try {
                object.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    
}
