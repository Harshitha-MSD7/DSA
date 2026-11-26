class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        // genereate all possible substring
        for(int i = 0; i<s.length(); i++){
            for(int j = i; j<s.length(); j++){
                if(isPlaindrome(s.substring(i,j+1))){
                    res++;
                }
            }
        }

        return res;
    }

    private boolean isPlaindrome(String s){
        int l = 0; 
        int r = s.length() - 1;
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}