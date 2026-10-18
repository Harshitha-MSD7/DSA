class Solution {
    public int maxDepth(String s) {

        int max = 0;
        int cur_parentheses = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                cur_parentheses++;
                max = Math.max(max, cur_parentheses);
            }
            else if(c == ')'){
                cur_parentheses--;
            }
        }
        return max;
    }
}