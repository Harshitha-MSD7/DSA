class Solution {
    /*
    
    . Q . . 
    . . . Q 
    Q . . . 
    . . Q . 
    
    
    */
    /*
        1. A recursive call handles a particular row.
        2. Loop through columns starting at 0.
        3. If a position is unsafe, skip it.
        4, If it’s safe, place a queen, then recurse to the next row.
        5. When that recursive call returns, remove the queen you placed and continue to the next column.
    
    */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }


        backtracking(0, board, res);


        return res;
    }
    
    private void backtracking(int row, char[][] board, List<List<String>> res){
        if (row == board.length) {
            // copy the solution
            List<String> solution = new ArrayList<>();
            for (char[] boardRow : board) {
                solution.add(new String(boardRow));
            }
            res.add(solution);
            return;
        }
        for(int col = 0; col<board.length; col++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                backtracking(row+1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board){
        // Checking row - not required
       
        //Checking col 
        for(int i = row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //checking left diagonal
        int n = row-1;
        int m = col-1;

        while(n>=0 && m>=0){
            if(board[n][m] == 'Q'){
                return false;
            }
            n--;
            m--;
        }

        //checking right diagonal
        
        int p = row-1;
        int q = col+1;

        while(p>=0 && q<board.length){
            if(board[p][q] == 'Q'){
                return false;
            }
            p--;
            q++;
        }

        return true;
    }
}
