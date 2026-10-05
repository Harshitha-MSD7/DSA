class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            // if not alpha numeric chars then
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // if it is alpha numeric chars
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
