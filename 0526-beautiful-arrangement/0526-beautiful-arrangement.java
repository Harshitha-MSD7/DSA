class Solution {

    int count = 0;
    
    public int countArrangement(int n) {
        count = 0;
        boolean[] visited = new boolean[n+1]; // because 1 indexed
        // Map storing valid number pairs where key can be placed at position value
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // Precompute all valid pairs (position -> numbers)
        // For each position i, find all numbers j that can be placed at position i

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<n+1; j++){
                if(i%j == 0 || j%i == 0){
                    if(!map.containsKey(i)){
                        map.put(i, new HashSet<>());
                    }
                    map.get(i).add(j);
                }
            }
        }

        dfs(1, visited, map, n);
        return count;
    }

    private void dfs(int position, boolean[] visited, Map<Integer, Set<Integer>> map, int n){
        // base case - all posiitons have filled successfully
        if(position == n+1){
            count++;
            return;
        }

        // Try placing each valid number at the current position
        for (int number : map.get(position)) {
            // Only use numbers that haven't been placed yet
            if (!visited[number]) {
                // Mark number as used
                visited[number] = true;
                // Recursively fill the next position
                dfs(position + 1, visited, map, n);
                // Backtrack: unmark the number for other arrangements
                visited[number] = false;
            }
        }
    }

}