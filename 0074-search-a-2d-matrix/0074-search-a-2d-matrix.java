class Solution {
    /*
        2 Binary Search
            1 for finding the right row
            1 to search target inside the row
        Approach:
        -> Lower bound BS on Col 1 on range [0,0] and [0, len of col]
        -> Normal BS on that row for range [0,row] and [len of row, row]
            -> return true if target exists false otherwise 
    
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        int lenRow = matrix.length;
        int lenCol = matrix[0].length;
        int[] row = new int[lenCol];
        int top = 0;
        int bottom = lenRow-1;

        // out if matrix range - O(1)
        if(target < matrix[0][0] || target > matrix[lenRow-1][lenCol-1]) return false;

        // Find right row - garunteed to have
        while(top <= bottom){
            int midRow = top + (bottom - top) / 2;
            // target lies in this row or the prev row
            if(target >=  matrix[midRow][0] && target <= matrix[midRow][lenCol-1]){
                row = matrix[midRow];
                break;
            }
            if(target > matrix[midRow][lenCol-1]){
                top = midRow + 1;
            }
            else{
                bottom = midRow - 1;
            }
        }

        // we have row -> Normal BS
        int l = 0;
        int r = row.length - 1;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(row[mid] == target) return true;
            else if(target < row[mid]){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return false;
        
    }
}