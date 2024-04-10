class post{
    int user,postId;
    public post(int user,int postId){
        this.user=user;
        this.postId=postId;
    }
}
class Twitter {
    ArrayList<post> arr;
    HashMap<Integer,HashMap<Integer,Boolean>> map ;
    public Twitter() {
        arr=new ArrayList<>();
        map= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        arr.add(new post(userId,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        int c=10,i=arr.size()-1;
        while(c>0&&i>=0){
            if((map.get(userId)!=null&&map.get(userId).get(arr.get(i).user)!=null)||arr.get(i).user==userId){
                c-=1;
                ans.add(arr.get(i).postId);
            }
            i-=1;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(map.get(followerId)!=null)
            map.get(followerId).put(followeeId,true);
        else{
            HashMap<Integer,Boolean> map2= new HashMap<>();
            map.put(followerId,map2);
            map.get(followerId).put(followeeId,true);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(map.get(followerId)!=null&&map.get(followerId).get(followeeId)!=null)
            map.get(followerId).remove(followeeId);
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