355. Design Twitter
Medium

614

155

Favorite

Share
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);


!!!!!!
class Twitter {
        class tweet{
        int timePost;
        int tweetID;
        public tweet(int tweetId,int timePost){
            this.timePost = timePost;
            this.tweetID = tweetId;
        }
    }
    /** Initialize your data structure here. */
     HashMap<Integer,LinkedList<tweet>> tweetmap;
    
     HashMap<Integer,Set<Integer>> followees;
    
     static int timestamp;
     static final int maxcapacity = 10;
    
    public Twitter() {
        tweetmap = new HashMap<>();
        followees = new HashMap<>();
        timestamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!tweetmap.containsKey(userId)){
            tweetmap.put(userId,new LinkedList<tweet>());
            follow(userId,userId);
        }
            tweetmap.get(userId).add(0,new tweet(tweetId,timestamp++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
       List<Integer> lst = new LinkedList<>();
        PriorityQueue<tweet> pq = new PriorityQueue<tweet>(new Comparator<tweet>(){
            public int compare(tweet a,tweet b){
                return a.timePost - b.timePost;
            }
        });
        if(followees.get(userId)!=null){
            Set<Integer> hs = followees.get(userId);
            for(int hs_single :hs){
                LinkedList<tweet> lst_hs_single = tweetmap.get(hs_single);
                if(lst_hs_single==null) continue;
                for(tweet t: lst_hs_single){
                    if(pq.size()<maxcapacity){
                        pq.add(t);
                    }
                    else{
                        if(t.timePost <= pq.peek().timePost) break; //t的MOST RECENT 比PQ.PEEK()老
                        else{
                            pq.add(sg);
                            pq.poll();
                        }
                    }
                }
            }
        }
        while(!pq.isEmpty()){
            lst.add(0,pq.poll().tweetID);
        }
        return lst;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followees.containsKey(followerId)){
            followees.put(followerId,new HashSet<Integer>());
        }
            followees.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followees.containsKey(followerId) && followerId!=followeeId){
            followees.get(followerId).remove(followeeId);            
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */