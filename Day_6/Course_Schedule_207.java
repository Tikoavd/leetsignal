//passed 48/52 cases...
import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        
        Hashtable<Integer, ArrayList<Integer>> table = 
            new Hashtable<Integer, ArrayList<Integer>>();
        
        for (int[] prerequisite : prerequisites) {
            if (!table.containsKey(prerequisite[1])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(prerequisite[0]);
                table.put(prerequisite[1], l);
            } else table.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        int count = 0;
        int steps = 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        
        for (int[] prerequisite : prerequisites){
            if(visited.contains(prerequisite[0])) {
                steps++;
                continue;
            }
            else visited.add(prerequisite[0]);
            if(noCycle(table, prerequisite[0], prerequisite[1])) {
                count++;
            }
        }
        
        if(steps + count == prerequisites.length) return true;
        return count >= numCourses;        
    }
    
    public static boolean noCycle(Hashtable<Integer, ArrayList<Integer>> table, Integer Value, Integer Key){
        if(!table.containsKey(Value)) return true;
        else if(table.get(Value).contains(Key)) return false;
        else return noCycle(table, table.get(Value), Value, 0);
    }
    public static boolean noCycle(Hashtable<Integer, ArrayList<Integer>> table, ArrayList<Integer> Values, Integer Key,int counts){
        if(counts > table.size()) return false;
        counts++;
        for (Integer n : Values){
            if(!table.containsKey(n)) return true;
            else if(table.get(n).contains(Key)) return false;
            else return noCycle(table, table.get(n), n, counts);
        }
        return true;
    }
}
