class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        dfs(0, 0, n, res, stack);
        return res;
    }

    public void dfs(int openN, int closedN, int n, List<String> res, StringBuilder stack){
        if(openN == closedN && openN == n){
            res.add(stack.toString());
            return;
        }

        if(openN < n){
            stack.append('(');
            dfs(openN + 1 , closedN, n, res, stack);
            stack.deleteCharAt(stack.length()-1);
        }

        if(closedN < openN){
            stack.append(')');
            dfs(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
