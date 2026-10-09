class Solution {
    public String foreignDictionary(String[] words) {

     HashMap<Character, Set<Character>> adj = new HashMap<>();
     HashMap<Character, Integer> inDegree = new HashMap<>();

     // Populate both maps's key
     for(String str : words){
          for(char c : str.toCharArray()){
               adj.putIfAbsent(c, new HashSet<>());
               inDegree.putIfAbsent(c, 0);
          }
     }

     // take pairs and compare them char by char 
     for(int i = 0; i<words.length-1; i++){
          String word1 = words[i];
          String word2 = words[i+1];
          int len = Math.min(word1.length(), word2.length());
          if(word1.length() > word2.length() && word1.substring(0, len).equals(word2.substring(0, len))){
               return "";
          }
          // loop to compare chars
          for(int j = 0; j< len; j++){
               // if there is a mis match -> we found a directed edge 
               if(word1.charAt(j) != word2.charAt(j)){
                    // We have to check if it is already contained in the map so that we do not increment the inDegree many times for the same prerequisite 
                    if(!adj.get(word1.charAt(j)).contains(word2.charAt(j))){     
                         adj.get(word1.charAt(j)).add(word2.charAt(j));
                         inDegree.put(word2.charAt(j), inDegree.get(word2.charAt(j))+1);
                    }
                    break;
               }
          }
          
     }

     // OG Khan's 
     // Setting up the queue for traversal
     Queue<Character> q = new LinkedList<>();
     for(char ch : inDegree.keySet()){
          if(inDegree.get(ch) == 0){
               q.add(ch);
          }
     }

     StringBuilder res = new StringBuilder();

     while(!q.isEmpty()){
          char node = q.poll();
          res.append(node);
          // iterate the adj map's HashSet for this node 
          for(char ch : adj.get(node)){
               inDegree.put(ch, inDegree.get(ch)-1);
               if(inDegree.get(ch) == 0){
                    q.offer(ch);
               }
          }
     }

     if(res.length() != adj.size()){
          return "";
     }

     return res.toString();
     
    }
}
