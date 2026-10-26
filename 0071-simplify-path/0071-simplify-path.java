class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for(String cur : parts){
            if(cur.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            // if it is dir name -> push 
            else if (!cur.equals("") && !cur.equals(".")) {
                stack.push(cur);
            }
        }

        return "/" + String.join("/", stack);
    }
}