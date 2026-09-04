class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*
        Given: Multiple cars at Multiple positions at different speed reching target
        CAR FLEET - # of cars EITHER INDIVIDUAL OR MERGED (count as 1) that crosses the target 
        Edge Case: COUNT THE ONES THAT MERGES EXACTLY AT TARGET LOCATION TOO  
        AFTER MERGE THE CAR'S SPPED WILL THE THE MAX SPEED OF ALL THE CARS IN THAT CLUSTER
        */

        /*
        eg:
        A car at position 4 -> 2 mph needs to go to 10
        10 - 4 = 6 miles to cover -> 2mph 
        this car takes 6/2 = 3 hours to reach target
        and then car at pos 1 is gonna take 4.5 hours to reach the destination

        CORE INTIUTION:
         Does a car behind take less time to reach the target than the car ahead of it?
         If the back car needs less (or equal) time, it catches up and joins the fleet ahead. If it takes longer, it's too slow to catch up and forms its own separate fleet behind.

        When will cars merge?


        In Context to Speed
        [10, 7]

        if stack.peek > current -> NO MERGE
        if stack.peek <= current -> MERGE! -> stack.push max(stack.pop, curr)

        return stack.size();

        
        */

        // MONOTONIC STACK PROBLEM

        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // position
            cars[i][1] = speed[i];    // speed
        }

        // Sort descending by position (b[0] - a[0])
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        ArrayDeque<Double> stack = new ArrayDeque<>();
        // as we read the time it takes for each car to reach the target
        for(int i = 0; i<n; i++){
            // we push stuff in stack when
            // stack is empty
            // 
            double current = (double)(target - cars[i][0]) / cars[i][1];
            
            // If the current car takes more time than the fleet ahead of it, 
            // it cannot catch up and forms a new fleet.
            if(stack.isEmpty() || stack.peek() < current){
                stack.push(current);
            }
            
        }

        return stack.size();

    }

}