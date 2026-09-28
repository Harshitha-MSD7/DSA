class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length-1;

        while(l < r){
            for(int i = 0; i<r-l; i++){
                int top = l;
                int bottom = r;

                // save the top left 
                int topLeft = matrix[top][l+i];

                // Doing the rotations
                matrix[top][l+i] = matrix[bottom-i][l];
                matrix[bottom-i][l] = matrix[bottom][r-i];
                matrix[bottom][r-i] = matrix[top+i][r];
                matrix[top+i][r] = topLeft;

            }
            r--;
            l++;
        }
    }
}
