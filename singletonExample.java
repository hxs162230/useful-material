
Class SingletonExample{
	private volatile static SingletonExample singletonExample;
	private SingletonExample(){

	}
	public static SingletonExample getInstance(){    //no object so we add static 
		if(singletonExample==null){
			synchronized(SingletonExample.class){
				if(singletonExample==null)
				singletonExample = new SingletonExample();
			}
		}
		return singletonExample;
	}
}

feature : 
	double check lock 
	lazy loading 

volatile通常出現在multi-threading的code裡面 代表著這個變數很不穩定 加上這個變數之後給了我們兩個保證

1.對於這個變數的寫 會保證寫進memory(所以其他thread會看到最新的值) 對於這個變數的讀 會保證從memory讀

2.JVM 跑compiler optimization的時候 不可以隨便改變volatile變數的順序




volatile keyword in Java
Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread safe. Thread safe means that a method or class instance can be used by multiple threads at the same time without any problem.

Consider below simple example.

class SharedObj
{
   // Changes made to sharedVar in one thread
   // may not immediately reflect in other thread
   static int sharedVar = 6;
}
Suppose that two threads are working on SharedObj. If two threads run on different processors each thread may have its own local copy of sharedVariable. If one thread modifies its value the change might not reflect in the original one in the main memory instantly. This depends on the write policy of cache. Now the other thread is not aware of the modified value which leads to data inconsistency.



Below diagram shows that if two threads are run on different processors, then value of sharedVariable may be different in different threads.
volatileJava

Note that write of normal variables without any synchronization actions, might not be visible to any reading thread (this behavior is called sequential consistency). Although most modern hardware provide good cache coherence therefore most probably the changes in one cache are reflected in other but it’s not a good practice to rely on hardware for to ‘fix’ a faulty application.

class SharedObj
{
   // volatile keyword here makes sure that
   // the changes made in one thread are 
   // immediately reflect in other thread
   static volatile int sharedVar = 6;
}
 

Note that volatile should not be confused with static modifier. static variables are class members that are shared among all objects. There is only one copy of them in main memory.

volatile vs synchronized:
Before we move on let’s take a look at two important features of locks and synchronization.

Mutual Exclusion: It means that only one thread or process can execute a block of code (critical section) at a time.
Visibility: It means that changes made by one thread to shared data are visible to other threads.
Java’s synchronized keyword guarantees both mutual exclusion and visibility. If we make the blocks of threads that modifies the value of shared variable synchronized only one thread can enter the block and changes made by it will be reflected in the main memory. All other thread trying to enter the block at the same time will be blocked and put to sleep.

In some cases we may only desire the visibility and not atomicity. Use of synchronized in such situation is an overkill and may cause scalability problems. Here volatile comes to the rescue. Volatile variables have the visibility features of synchronized but not the atomicity features. The values of volatile variable will never be cached and all writes and reads will be done to and from the main memory. However, use of volatile is limited to very restricted set of cases as most of the times atomicity is desired. For example a simple increment statement such as x = x + 1; or x++ seems to be a single operation but is s really a compound read-modify-write sequence of operations that must execute atomically.