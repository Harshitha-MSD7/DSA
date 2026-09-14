class Twitter {
    // we are capping posts at 10 most recent

    private int count; // -> Overall post number
    private HashMap<Integer, List<int[]>> tweetMap; // {count , tweetId}
    private HashMap<Integer, Set<Integer>> followMap;

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] {count, tweetId});
        if (tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        count--;
    }

    public List<Integer> getNewsFeed(int userId) {
        // Return 10 most recent tweetIDs
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // Go to followers set of this user + the user and for each of them we have to start an
        // iteration. and when you pop something from that follower the pointer there increments.
        // How am I going to do this? int index = followeeId.size()-1 Inside the heap -> new
        // int[]{followeeId.get(index)[0], followeeId.get(index)[1], followeeId, index} iterating
        // the set of following ppl
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followeeId : followMap.get(userId)) {
            List<int[]> tweet = tweetMap.get(followeeId);

            if (tweet != null && !tweet.isEmpty()) {
                int index = tweet.size() - 1;
                maxHeap.add(
                    new int[] {tweet.get(index)[0], tweet.get(index)[1], followeeId, index});
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] current = maxHeap.poll();
            res.add(current[1]); // tweetId

            int user = current[2];
            int index = current[3];

            if (index > 0) {
                List<int[]> tweets = tweetMap.get(user);
                int[] prevTweet = tweets.get(index - 1);
                maxHeap.add(new int[] {prevTweet[0], prevTweet[1], user, index - 1});
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
