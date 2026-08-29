class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Building the inDegree map
        HashMap<String, Integer> inDegree = new HashMap<>();
        // recipie -> # of dependent nodes
        for(int i = 0; i<recipes.length; i++){
            inDegree.put(recipes[i], ingredients.get(i).size());
        }

        // Bulding the adjacency list
        // ingredients -> recipies
        HashMap<String, List<String>> adj = new HashMap<>();
        for(int j = 0; j<ingredients.size(); j++){
            for(String s : ingredients.get(j)){
                if(!adj.containsKey(s)){
                    adj.put(s,new ArrayList<>());
                }   
                adj.get(s).add(recipes[j]);
                
            }
        }

        // No dependecies for the particualar nodes
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(String s : supplies){
            q.offer(s);
        }

        // Kahn's traversal
        while(!q.isEmpty()){
            String node = q.poll();
            if(adj.containsKey(node)){
                for(String it : adj.get(node)){
                    inDegree.put(it,inDegree.get(it) - 1);
                    if(inDegree.get(it) == 0){
                        res.add(it);
                        q.offer(it);
                    }
                }
            }

        }   
        return res;
    }
}