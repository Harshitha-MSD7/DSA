class Solution {
    /*
    Input constrains:
        1. Length is always even
        2. Length is always >= 2 
        3. # of '[' is always equal to the # of ']'
    */
    public int minSwaps(String s) {
        int max = 0;
        int extraClosing = 0;

        for(char c : s.toCharArray()){
            if(c == '['){
                extraClosing--;
            }
            else{
                extraClosing++;
                if(extraClosing > 0) max = Math.max(max, extraClosing);
            }
        }

        return (max+1)/2;
    }
}