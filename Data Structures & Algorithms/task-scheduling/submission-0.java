class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        A - 0
        A -
        A 
        B - 1
        C
        */

        int time = 0;

        // when we poll from the heap the one with the maximum vlaue has to come out first 
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int[] count = new int[26];

        for(int i : tasks){
            count[i - 'A']++;
        } 
        // We have all the elements that we have to process inside the heap
        for(int cnt : count){
            if(cnt > 0){
                q.add(cnt);
            }
        }


        Queue<int[]> que = new LinkedList<>();
        // [count, idleTime]

        while(!q.isEmpty() || !que.isEmpty()){
            time++;
        // At any given point if the pq is empty means there is no elemets currently to fill the empty wait time right so we increment time to the next available Char in the queue
            if(q.isEmpty()){
                time = que.peek()[1];
            }
            // if there are elements in the heap
            else{
                // the frequency of whatever charecter this was is now being reduced by 1 and added to the Queue
                int freq = q.poll() - 1;
                if(freq > 0)
                    que.add(new int[]{freq, time + n});
            }

            //while we do process the lement in the heap if there are element in the queue that is also possible to be processed at this time then we go ahead and do that as well
            if(!que.isEmpty() && que.peek()[1] == time){
                q.add(que.poll()[0]);
            }


        }

        return time;
        
    }
}
