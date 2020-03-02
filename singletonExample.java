
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