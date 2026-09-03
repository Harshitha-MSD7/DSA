class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length()<s1.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int k = 0; k<s1.length(); k++){
            freq1[s1.charAt(k) - 'a']++;
            freq2[s2.charAt(k) - 'a']++;
        }

        int i = 0;
        int j = s1.length();

        if(Arrays.compare(freq1, freq2) == 0) return true;

        while(j<s2.length()){
            if(Arrays.compare(freq1, freq2) == 0) return true;
            
            freq2[s2.charAt(i) - 'a']--;
            freq2[s2.charAt(j) - 'a']++;
            
            i++;
            j++;

        }
        if(Arrays.compare(freq1, freq2) == 0) return true;

        return false;

    }


}
