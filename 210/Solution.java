public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {//BFS
        int[] ans = new int[numCourses];
        int[] numOfPre = new int[numCourses];
        ArrayList<ArrayList<Integer>> children = new ArrayList<ArrayList<Integer>>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            children.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            children.get(prerequisites[i][1]).add(prerequisites[i][0]);
            numOfPre[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int visited = 0;
        for(int i = 0; i < numCourses; i++) {
            if(numOfPre[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            Integer curt = queue.poll();
            ans[visited++] = curt;
            if(children.get(curt).size() == 0) {
                continue;
            }
            for(Integer child: children.get(curt)){
                numOfPre[child]--;
                if(numOfPre[child] == 0) {
                    queue.offer(child);
                }
            }
        }
        if (visited < numCourses) {
            return new int[0];
        }
        return ans;
    }
}