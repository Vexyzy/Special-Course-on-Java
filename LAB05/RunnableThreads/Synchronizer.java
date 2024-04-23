package RunnableThreads;

import java.util.Random;

import Package.DigitsImpl;

public class Synchronizer {
    private DigitsImpl i;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean set = false;
   
    public <Интерфейс>Synchronizer(DigitsImpl i) {
        this.i = i;
    }
   
    public int read() throws InterruptedException {
        int val;
        synchronized(lock) {
            if (!canRead()) throw new InterruptedException();
            while (!set)
                lock.wait();
            val = i.getLenPaper(current++);
            System.out.printf("\nRead %d from position %d", val, current-1);
            set = false;
            lock.notifyAll();
        }
        return val;
    }  
   
    public void write(int val) throws InterruptedException {
        synchronized(lock) {
            if (!canWrite()) throw new InterruptedException();
            while (set)
                lock.wait();
            i.setLenPaper(current, val);
            System.out.printf("\nWrite %d to position %d", val, current);
            set = true;
            lock.notifyAll();
        }
    }
    
    public boolean canRead() {
        return current < i.getLen();
    }
    
    public boolean canWrite() {
        return (!set && current < i.getLen()) || (set && current < i.getLen() - 1);
    }
}
