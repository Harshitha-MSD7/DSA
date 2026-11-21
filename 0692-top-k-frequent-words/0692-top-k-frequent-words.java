class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Building and population the frequency hash map
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            if(! map.containsKey(word)){
                map.put(word,0);
            }
            map.put(word, map.get(word) + 1);
        }

        List<String> res = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
        int freqComp = Integer.compare(map.get(a), map.get(b));
        if (freqComp != 0) {
            return freqComp;
        }
        return b.compareTo(a);
        });

        for(String key : map.keySet()){
            pq.offer(key);
            if(pq.size() > k) pq.poll();
        }

        while(! pq.isEmpty()){
            res.add(pq.poll());
        }

        Collections.reverse(res);


        return res;
    }
}