class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Char -> int(freq)
        /*
        acttt
        a -> 1
        c -> 1
        t -> 3

        strs = ["act","pots","tops","cat","stop","hat"]


        */
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }

        }

        return new ArrayList<>(map.values());
    }
}
