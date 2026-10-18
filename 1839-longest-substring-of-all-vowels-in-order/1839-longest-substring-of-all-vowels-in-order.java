class Solution {
    // last seen vowel 
    // order -> A E I O U 
    public int longestBeautifulSubstring(String word) {
        /*
            Return the length of the longest substring that has vowels in order 

        */
        

        int max = 0;
        int currentLen = 1;
        int vowelCount = 1;

        for(int i = 1; i<word.length(); i++){
            if(word.charAt(i) == word.charAt(i - 1)){
                currentLen++;
            }
            else if(word.charAt(i) > word.charAt(i - 1)){
                currentLen++;
                vowelCount++;
            }
            // ordet broken -> new streak
            else{
                currentLen = 1;
                vowelCount = 1;
            }
            if(vowelCount == 5){
                max = Math.max(max, currentLen);
            }

        }

        return max;

    }
}