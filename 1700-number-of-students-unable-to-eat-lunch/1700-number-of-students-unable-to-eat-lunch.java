class Solution {

    /*
    students - queue [1, 1, 0, 0]
    sandwiches - stack [0, 1, 0, 1]

    
    */
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> q = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<students.length; i++){
            q.offer(students[i]);
        }
        for(int i = sandwiches.length-1; i>=0; i--){
            stack.push(sandwiches[i]);
        }

        int count = 0;
        while(!q.isEmpty()){
            // student can eat
            if(q.peek() == stack.peek()){
                count = 0;
                q.poll();
                stack.pop();
            }
// 0 1 00000
// 1111111111
            else{
                q.offer(q.poll());
                count++;
                if(count == q.size()){
                    return q.size();
                }
            }
        }

        return 0;
    }
}