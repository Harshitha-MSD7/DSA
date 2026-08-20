class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap 
        // keys -> String of freqArray and Values -> list of strings 

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] freq = new int[26];
            for(int i = 0; i<str.length(); i++){
                freq[str.charAt(i)-'a'] = freq[str.charAt(i)-'a'] + 1;
            }
            // Build the Freq String
            String key = Arrays.toString(freq);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> group : map.values()){
            res.add(group);
        }

        return res;
    }
}