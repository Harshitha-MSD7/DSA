class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        
        List<Integer> lis = new ArrayList<>();
        lis.add(1);
        res.add(lis);
        // res {{1}, {1}}
        for(int i = 1; i<numRows; i++){
            List<Integer> newLis = new ArrayList<>();
            newLis.add(1);

            List<Integer> prev = res.get(res.size()-1);

            for(int j = 1; j<i; j++){
                newLis.add(prev.get(j) + prev.get(j-1));
            }

            newLis.add(1); //last index 

            res.add(newLis);
        }

        return res;
    }
}