class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // base case (sum of code > sum of gas) return -1
        int sum_cost = 0;
        int sum_gas = 0;

        //[-2, -2, 2 -2 1]

        int[] diff = new int[gas.length];

        for(int i = 0; i<gas.length; i++){
            sum_gas += gas[i];
            sum_cost += cost[i];
            diff[i] = gas[i] - cost[i];
        }

        if(sum_cost > sum_gas) return -1;

        int total = 0;

        // if it goes here it means we have a solution that is unique
        // we just have to return it 
        int j = 0;
        int ans = 0;
        while(j<diff.length){
            total += diff[j];
            if(diff[j] < 0){
                ans = j+1;
            }
            j++;
        }

        return ans;


    }
}
