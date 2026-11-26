class Solution {
    public boolean canAliceWin(int n) {
        int take = 10;
        boolean aliceTurn = true;

        while (n >= take) {
            n -= take;
            take--;
            aliceTurn = !aliceTurn;
        }

        // If it's currently Alice's turn and she can't take `take` stones, Alice loses.
        // If it's Bob's turn and he can't take `take` stones, Alice wins.
        return !aliceTurn;
    }
}