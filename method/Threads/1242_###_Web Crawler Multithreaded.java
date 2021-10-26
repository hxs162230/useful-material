1242. Web Crawler Multithreaded
Medium

164

23

Add to List

Share
Given a url startUrl and an interface HtmlParser, implement a Multi-threaded web crawler to crawl all links that are under the same hostname as startUrl. 

Return all urls obtained by your web crawler in any order.

Your crawler should:

Start from the page: startUrl
Call HtmlParser.getUrls(url) to get all urls from a webpage of given url.
Do not crawl the same link twice.
Explore only the links that are under the same hostname as startUrl.


As shown in the example url above, the hostname is example.org. For simplicity sake, you may assume all urls use http protocol without any port specified. For example, the urls http://leetcode.com/problems and http://leetcode.com/contest are under the same hostname, while urls http://example.org/test and http://example.com/abc are not under the same hostname.

The HtmlParser interface is defined as such: 

interface HtmlParser {
  // Return a list of all urls from a webpage of given url.
  // This is a blocking call, that means it will do HTTP request and return when this request is finished.
  public List<String> getUrls(String url);
}
Note that getUrls(String url) simulates performing a HTTP request. You can treat it as a blocking function call which waits for a HTTP request to finish. It is guaranteed that getUrls(String url) will return the urls within 15ms.  Single-threaded solutions will exceed the time limit so, can your multi-threaded web crawler do better?

Below are two examples explaining the functionality of the problem, for custom testing purposes you'll have three variables urls, edges and startUrl. Notice that you will only have access to startUrl in your code, while urls and edges are not directly accessible to you in code.

 

Follow up:

Assume we have 10,000 nodes and 1 billion URLs to crawl. We will deploy the same software onto each node. The software can know about all the nodes. We have to minimize communication between machines and make sure each node does equal amount of work. How would your web crawler design change?
What if one node fails or does not work?
How do you know when the crawler is done?
 

Example 1:



Input:
urls = [
  "http://news.yahoo.com",
  "http://news.yahoo.com/news",
  "http://news.yahoo.com/news/topics/",
  "http://news.google.com",
  "http://news.yahoo.com/us"
]
edges = [[2,0],[2,1],[3,2],[3,1],[0,4]]
startUrl = "http://news.yahoo.com/news/topics/"
Output: [
  "http://news.yahoo.com",
  "http://news.yahoo.com/news",
  "http://news.yahoo.com/news/topics/",
  "http://news.yahoo.com/us"
]
Example 2:



Input: 
urls = [
  "http://news.yahoo.com",
  "http://news.yahoo.com/news",
  "http://news.yahoo.com/news/topics/",
  "http://news.google.com"
]
edges = [[0,2],[2,1],[3,2],[3,1],[3,0]]
startUrl = "http://news.google.com"
Output: ["http://news.google.com"]
Explanation: The startUrl links to all other pages that do not share the same hostname.
 

Constraints:

1 <= urls.length <= 1000
1 <= urls[i].length <= 300
startUrl is one of the urls.
Hostname label must be from 1 to 63 characters long, including the dots, may contain only the ASCII letters from 'a' to 'z', digits from '0' to '9' and the hyphen-minus character ('-').
The hostname may not start or end with the hyphen-minus character ('-'). 
See:  https://en.wikipedia.org/wiki/Hostname#Restrictions_on_valid_hostnames
You may assume there're no duplicates in url library.


/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */


1. split string 
2. new thread Runnable thread , start , join 
3. 每個thread 去 recursively create a new thread (thread , start , join)並以此 curString 去 crawl 所有結果
4. join所有的thread 再進入下一層 搜索 (先創建一個threadList存起來)
%%%
當每次創建一個new thread時 並不能 new一個result hashset<String>();
%%%

time O (N)
space O (N)

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        int pos = startUrl.indexOf("/",7);
        String hostname = pos!=-1 ? startUrl.substring(0,pos):startUrl;
        
        Crawler crawler = new Crawler(hostname,startUrl,htmlParser);
        crawler.result = new HashSet<>();
        Thread thread = new Thread(crawler);
        thread.start();
        crawler.joinThread(thread);
        //System.out.print(hostname);
        return new ArrayList<>(crawler.result);
    }    
}

class Crawler implements Runnable{
        String base;
        String cur;
        HtmlParser html;
        
        public static volatile Set<String> result = new HashSet<>();
        
        public Crawler(String base,String cur,HtmlParser html){
            this.html = html;
            this.cur = cur;
            this.base = base;
        }
        @Override
        public void run(){
            if(this.cur.startsWith(base)&&!this.result.contains(cur)){
                addUrl(this.cur,this.result);
                List<Thread> threads = new ArrayList<>();
                for(String lks:html.getUrls(cur)){
                    if(result.contains(lks)) continue;
                    
                    Crawler crawler = new Crawler(base,lks,html);
                    Thread thread = new Thread(crawler);
                    threads.add(thread);
                    thread.start();
                }
                for(Thread td:threads){
                    joinThread(td);
                }
            }
        }
        public static synchronized void addUrl(String url,Set<String> res){
            res.add(url);
        }
        public static void joinThread(Thread t){
            try{
                t.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


2.
    exec + callable (thread pool)

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String host = getHost(startUrl);
        ExecutorService es = Executors.newCachedThreadPool(r -> {
            Thread t = Executors.defaultThreadFactory().newThread(r);
            t.setDaemon(true);
            return t;
        });
        Queue<String> q = new LinkedList<>();
        Set<String> set = new ConcurrentHashMap<>().newKeySet();
        set.add(startUrl);
        q.add(startUrl);
        try{
        while(!q.isEmpty()){
            List<Task> tasks = new ArrayList<>();
            for(int i=q.size();i>0;i--){
                String cur = q.poll();
                tasks.add(new Task(htmlParser,cur));
            }
            List<Future<List<String>>> futures = es.invokeAll(tasks);
            for(Future<List<String>> future:futures){
                for(String next:future.get()){
                    if(set.contains(next)) continue;
                    if(!next.startsWith(host)) continue;
                    set.add(next);
                    q.add(next);
                    
                }
            }
        }
        }
        catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        finally{
            es.shutdown();
        }
        return new ArrayList<>(set);
    }
    public String getHost(String url){
        int idx = url.indexOf("/",7);
        return idx==-1?url:url.substring(0,idx);
    } 
}
class Task implements Callable<List<String>>{
    HtmlParser html;
    String cur;
    public Task(HtmlParser html,String cur){
        this.html = html;
        this.cur = cur;
    }
    public List<String> call(){
        return this.html.getUrls(this.cur);
    }
}