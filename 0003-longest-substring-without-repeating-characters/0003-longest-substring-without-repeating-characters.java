class Solution {
    // abcabcbb
    // 
    // sliding window + HashSet
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int max = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();

        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max = Math.max(max, j-i+1);
            }
            // if it is in hte set -> reduce the window until it is not in the set
            else{
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(s.charAt(j));
            }
            j++;
        }

        return max;
    }
}