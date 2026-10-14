class Pair {
    String name;
    double value;

    Pair(String name, double value) {
        this.name = name;
        this.value = value;
    }
}
class Solution {
    /* equations - array of variable pairs - 2D array wich has pairs and Ai/Bi = values[i]
       values - array of real numbers
    
    Input: equations = [["a","b"],["b","c"]]
    values = [2.0,3.0]
    queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

    Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]


    Cases: 
    1. If any one of the string int the query DNE -> return -1
    2. If both the string in the query are the same -> return 1 
    3. id able to reach -> return product
    4. If unable to reach -> return -1

    */
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] res = new double[queries.size()];

        // HashMap is going to represent the graph
        Map<String, List<Pair>> adj = new HashMap<>(); // Map a -> list of [b, a/b]

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(a).add(new Pair(b, values[i]));
            adj.get(b).add(new Pair(a, 1 / values[i]));
        }

        for(int j = 0; j<queries.size(); j++){
            res[j] = bfs(queries.get(j).get(0), queries.get(j).get(1), adj); 
        }

        return res;
    }

    // Khan's
    private double bfs(String src, String des, Map<String, List<Pair>> graph){

        if(!graph.containsKey(src) || !graph.containsKey(des)) return -1.0;
        if(src.equals(des)) return 1.0;

        Deque<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        double product = 1.0;
        q.add(new Pair(src, product));

        while(!q.isEmpty()){
            Pair node = q.poll();
            product = node.value;
            if(node.name.equals(des)) return product;
    
            for(Pair pair : graph.get(node.name)){
                if(!visited.contains(pair.name)){
                    visited.add(pair.name);
                    q.offer(new Pair(pair.name, product*pair.value));
                }
            }
        }

        return -1.0;
    }
}