/*
    ID -> 0 to n-1
    Function calls:
        1. Stored in a stack
        2. Start -> ID is pushed into the stack
        3. Ends -> ID is popped from the stack
        4. Current -> ID at the top of the stack  
        5. Each time a function starts or ends: 
            -> write a log with the ID, whether it started or ended, and the timestamp.
    [2 + 4  + 1 , 1]
*/
class Solution {
    // HashMap<Integer, Integer> -> ID -> exclusive time
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int pre = 0;

        for(String log : logs){
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String op = parts[1];
            int cur = Integer.parseInt(parts[2]);
            // start
            if(op.charAt(0) == 's'){
                // Non empty Stack
                if(!stack.isEmpty()){
                    res[stack.peek()] += cur - pre;
                }
                stack.push(id);
                pre = cur;
            }
            // end
            else{
                res[stack.pop()] += cur - pre + 1;
                pre = cur + 1;
            }
        }

        return res;
    }
}