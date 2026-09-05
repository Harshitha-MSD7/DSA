/*

time based Key - Value (can store multiple values for the same key)

has to be sorted

*/
class Pair {
    String value;
    int timeStamp;

    public Pair(String value, int timeStamp){
        this.value = value;
        this.timeStamp = timeStamp;
    }
}
class TimeMap {
    // Initializes the object of the data structure
    private final HashMap<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>(); 
    }
    // Stores the key with the value at the given time timestamp
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));

    }
    // This is the trickiest part!
    // This is where binary search comes to play
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        
        // Binary Search
        int left = 0;
        int right = map.get(key).size()-1; 
        String result = "";
        while(left <= right){
            int mid = left + (right - left) / 2;
            // if there is an actual time stamp return the value
            //if(lis.get(mid).timeStamp == timestamp) return lis.get(mid).value;
            // This could be hte answer but also there could bea better answer
            if(map.get(key).get(mid).timeStamp <= timestamp){
                result = map.get(key).get(mid).value;
                left = mid+1;
            }
            else{
                right = mid-1;
            }

        }

        return result;

    }
}
