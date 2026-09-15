class Solution {
    public boolean isValid(String s) {
        /*
        see open pearathesis -> put opposite into the stack
        see closed paratheses -> pop stack and if equal continue if not or is stack is empty return false
        int the end resturn true         
        */

        ArrayDeque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i) == '{'){
                stack.push('}');
            }
            else if(s.charAt(i) == '['){
                stack.push(']');
            }
            else if(s.charAt(i) == '('){
                stack.push(')');
            }
            // we get here only when we have a closed paranthesis
            else{
                if(stack.isEmpty()) return false;
                if(stack.pop() != s.charAt(i)) return false;
            }

            i++;
        }

        return true;
    }
}
