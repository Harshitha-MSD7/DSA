import java.util.Random;
class RandomizedSet {

    List<Integer> lis;
    // Value -> Index
    HashMap<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
        lis = new ArrayList<>();
        // Value -> index
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        lis.add(val);
        map.put(val, lis.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int lastElement = lis.get(lis.size()-1);
        lis.set(map.get(val), lastElement);
        map.put(lastElement, map.get(val));
        map.remove(val);
        lis.remove(lis.size()-1);
        return true;
    }
    
    public int getRandom() {
        return lis.get(rand.nextInt(lis.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */