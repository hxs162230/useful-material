do {
    // writer requests for critical section
    wait(wrt);  
   
    // performs the write

    // leaves the critical section
    signal(wrt);

} while(true);



do {
    
   // Reader wants to enter the critical section
   wait(mutex);

   // The number of readers has now increased by 1
   readcnt++;                          

   // there is atleast one reader in the critical section
   // this ensure no writer can enter if there is even one reader
   // thus we give preference to readers here
   if (readcnt==1)     
      wait(wrt);                    

   // other readers can enter while this current reader is inside 
   // the critical section
   signal(mutex);                   

   // current reader performs reading here
   wait(mutex);   // a reader wants to leave

   readcnt--;

   // that is, no reader is left in the critical section,
   if (readcnt == 0) 
       signal(wrt);         // writers can enter

   signal(mutex); // reader leaves

} while(true);




import java.util.concurrent.Semaphore;

/**
 * @author 12130
 */
public class ReadWriteLock {
    /* Two mutually exclusive semaphores */
    private Semaphore readSemaphore = new Semaphore(1);
    private Semaphore writeSemaphore = new Semaphore(1);
    
    /* Number of read threads */
    private int count = 0;

    /**
     * Get read lock
     */
    public void readLock() throws InterruptedException {
        readSemaphore.acquire();
        if(count == 0){
            writeSemaphore.acquire();
        }
        count++;
        readSemaphore.release();
    }

    /**
     * Release read lock
     */
    public void readUnLock() throws InterruptedException {
        readSemaphore.acquire();
        count--;
        if(count == 0){
            writeSemaphore.release();
        }
        readSemaphore.release();
    }

    /**
     * Get write lock
     */
    public void writeLock() throws InterruptedException {
        writeSemaphore.acquire();
    }

    /**
     * Release write lock
     */
    public void writeUnlock(){
        writeSemaphore.release();
    }
}