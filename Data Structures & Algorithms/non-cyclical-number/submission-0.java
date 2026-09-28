class Solution {
    public boolean isHappy(int n) {
        /*
        Build a set 
        in a loop keep summing the number and put the result in the Set
        if ever got 1 return true
        if ever reached a number that contains set return false
        
        */ 
        HashSet<Integer> set = new HashSet<>();
        int curNum = n;

        while(true){

            int res = sum(curNum);
            if(res == 1) {
                return true;
            }
            else if(set.contains(res)) {
                return false;
            }
            else{
                set.add(res);
                curNum = res;
            }
        }
        // will not get here
        
    }

    private int sum(int num){
        String s = String.valueOf(num);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        int res = 0;

        for(int i = 0; i<arr.length; i++){
            res += (arr[i] * arr[i]); 
        }

        return res;
    }
}
