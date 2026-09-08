class Solution {
    public boolean lemonadeChange(int[] bills) {
        /*
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<bills.length; i++){
            if(bills[i] == 5) set.add(5);
            // 10
            else if(bills[i] == 10){
                if(!set.contains(5)) return false;
                set.remove(5);
                set.add(10);
            }
            // 20
            else {
                if(set.contains(10)){
                    set.remove(10);
                    if(set.contains(5)){
                        set.remove(5); 
                        continue;
                    }
                }

            }
        }

        return true;
        */

        /* 
            [5, 5, 5, 20]
                       i
            five = 3
            ten = 0
        */

        int five = 0;
        int ten = 0;

        for(int i = 0; i<bills.length; i++){
            if(bills[i] == 5) five++;

            else if(bills[i] == 10){
                if(five <= 0) return false;
                five--;
                ten++;
            }

            else{
                if(ten >= 1){
                    if(five <= 0) return false;

                    five--;
                    ten--;
                }
                else{
                    if(five < 3) return false;
                    five -= 3;
                }

            }
        }

        return true;
    }

}