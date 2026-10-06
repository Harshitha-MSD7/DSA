class Solution {
    public int[] twoSum(int[] numbers, int target) {

        /*
        [2,3,4]
        6
        6
        */

        int left = 0;
        int right = numbers.length-1;
        int[] res = new int[2];

        while(left < right){
            // reduce
            if(numbers[left] + numbers[right] > target){
                right--;
            }
            else if(numbers[left] + numbers[right] < target){
                left++;
            }
            else{
                res[0] = left+1;
                res[1] =  right+1;
                break;
            }
        }

        return res;
    }
}