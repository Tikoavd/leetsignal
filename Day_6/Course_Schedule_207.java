//uncomplete, wrong answer on 44th case
import java.util.Hashtable;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(int i = 0; i < prerequisites.length; i++) {
            table.put(prerequisites[i][1], prerequisites[i][0]);
        }
        int i = 0;
        while(i < prerequisites.length && !(table.containsKey(prerequisites[i][0]) &&
              table.get(prerequisites[i][0]) == prerequisites[i][1] ||
                table.get(prerequisites[i][0]) != null
            && table.containsKey(table.get(prerequisites[i][0])))) {
            i++;
            System.out.print(i + " ");
        }
        if(i == prerequisites.length) return true;
        return ++i >= numCourses;        
    }
}
