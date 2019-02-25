package FirstProject;

import java.util.ArrayList;

class Semaphore {

    private int onQueue;

    public Semaphore() {}

    public synchronized void  take(){
        onQueue++;
        if (onQueue > 1)
            try{
                wait();
            } catch (Exception e){
                e.printStackTrace();
            }
    }

    public synchronized void release() {
        onQueue--;
        this.notify();
    }
}
