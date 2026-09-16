class Solution {
    public int[] separateDigits(int[] nums) {
    // 13 -> 1,3
    // x >= 10 
    // 1300 -> 1, 3, 0, 0
    // 1300
    // what I need when x >= 10 is x%10 then do x = x/10 repeat the process until x<10
    // 1300 % 10 -> 0, 130 % 10 -> 0, 13 % 10 -> 3, 1 -> 1 
    // do this for all number in the list do collections.reverse
    // then convert to the int array and return it
    //   O(m*n) -> m - length of int and n = length of array
    // Space O(n)

    List<Integer> res = new ArrayList<>();
        
        for (int num : nums) {
            List<Integer> temp = new ArrayList<>();
            
            // Extract digits right-to-left
            while (num > 0) {
                temp.add(num % 10);
                num /= 10;
            }
            
            // Add them back to the main list in left-to-right order
            
            for (int i = temp.size() - 1; i >= 0; i--) {
                res.add(temp.get(i));
            }
            
        }
        
        // Convert List<Integer> to primitive int[]
        return res.stream().mapToInt(i -> i).toArray();

    }
}