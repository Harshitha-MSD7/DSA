class Solution {
    /*
    1. iterate the whole board cell by cell
    2. if we do find something starting with srting's first char
    3. call a helper function (checks 4 directions & boundary range to see if we can find the string)
    4. if found return true and if not continue grid traversal
    5. if grid traversal is done then rertun false because we cannot find the string
    6. In the helper function have a boolean grid to avoid reusing the same cell during dfs traversal
    */
    private final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(wordSearch(row, col, board, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean wordSearch(int row, int col, char[][] board, String word, int i){
        // base case
        if(i == word.length()) return true;
        // out of bounds case
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        // Inequal case
        if(board[row][col] != word.charAt(i)){
            return false;
        }
        // dfs - chat at this pos = chat at word i -> look 4 directions within boundary
        char temp = board[row][col];
        board[row][col] = '#';
        for(int[] dir : directions){
            int nr = row + dir[0];
            int nc = col + dir[1];
            
            if(wordSearch(nr, nc, board, word, i+1)) return true;
        }
        board[row][col] = temp;

        return false;

    }
}
