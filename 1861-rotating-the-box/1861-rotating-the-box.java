class Solution {
    /*
    Approach:
    2 parts for this solution
    part 1 - moving the stones to right place
    part 2 - m X n -> n x m
    
    Implementation:
    Part 1: (In-Place pos changes)
        Have 2 pointers i and c going from right to left (both start at the right)
            -> i position to place and c stone pos
            -> c has to go left until you find a stone
            -> then put the stone at pos c in pos i 
                -> if i != c then mark empty
            -> after swapping move i and c to the left
            -> if c ever hits a block move i and c one step to the left of the block
            -> this loop continues until c reaches the end of the left
    
    Part 2: (90 degree rotation)
        2 pointers
        -> row pointer goes from bottom up and col goes left right
        -> filling in the res matrix left right and top bottom copying cell by cell
    
    */
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] res = new char[boxGrid[0].length][boxGrid.length];

        // Part 1
        for(int row = 0; row<boxGrid.length; row++){
            int i = boxGrid[0].length-1;
            int c = i;
            while(c >= 0){
                if(boxGrid[row][c] == '*'){
                    i = c - 1;
                }
                else if(boxGrid[row][c] == '#'){
                    boxGrid[row][i] = '#';
                    if(c != i){
                       boxGrid[row][c] = '.'; 
                    }
                    i--;
                }
                c--;
            }
        }

        // Part 2

        for(int col = boxGrid[0].length-1; col >= 0; col--){
            for(int row = 0; row < boxGrid.length; row++){  
                res[col][boxGrid.length-row-1] = boxGrid[row][col];
            }
        }

        return res;
    }
}