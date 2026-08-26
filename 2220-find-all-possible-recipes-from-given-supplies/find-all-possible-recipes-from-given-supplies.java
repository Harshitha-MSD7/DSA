class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> ans = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        for(String s : supplies){
            q.offer(s);
        }

        // inDegree
        HashMap<String, Integer> inDegree = new HashMap<>();
        for(int i = 0; i< recipes.length; i++){
            inDegree.put(recipes[i],ingredients.get(i).size());
        }
        // ingredients -> {recipies}
        HashMap<String, List<String>> adj = new HashMap<>();

        // adj list

        for(int j = 0; j<ingredients.size(); j++){
            for(String ingredient : ingredients.get(j)){
                if(adj.containsKey(ingredient)){
                    adj.get(ingredient).add(recipes[j]);
                }
                else{
                    List<String> newList = new ArrayList<>();
    newList.add(recipes[j]);
    adj.put(ingredient, newList);
                }
            }
        }
        while(!q.isEmpty()){
            String node = q.poll();

            if(adj.containsKey(node)){
                for(String s : adj.get(node)){
                    inDegree.put(s, inDegree.get(s) - 1);
                    if(inDegree.get(s) == 0){
                        ans.add(s);
                        q.offer(s);
                    }

                }
            }

        }

        return ans;

    }
}