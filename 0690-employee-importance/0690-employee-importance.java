/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Solution {

    // Return the sum of importance of all the employees in the id conneced graph

    public int getImportance(List<Employee> employees, int id) {
        // HashMap -> { ID (int) : Employee object}
        HashMap<Integer, Employee> map = new HashMap<>(); 

        for(Employee emp : employees){
            map.put(emp.id, emp);
        }

        return bfs(map, id);
           
    }

    private int bfs(HashMap<Integer, Employee> map, int id){

        int sum = map.get(id).importance;

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        while(!q.isEmpty()){
            int emp = q.poll();

            for(int nei : map.get(emp).subordinates){
                sum += map.get(nei).importance;
                q.add(nei);
            }
        }

        return sum;        
    }
    
}