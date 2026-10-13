/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/*
Each node has a weight, return the sum of all the weights in the connected graph containg the id
*/
// a single source traversal with tracking sum 
class Solution {
    // Return the total importance value of this employee and all their direct and indirect subordinates
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees){
            map.put(employee.id, employee);
        }

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(id);
        
        int sum = 0;

        while(!q.isEmpty()){
            int emp = q.poll();
            sum += map.get(emp).importance;
            for(int empId : map.get(emp).subordinates){
                q.offer(empId);
            }
        }
        return sum;     
    }
    
}