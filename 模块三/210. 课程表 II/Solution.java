class Solution {
    private int n;
    private List<List<Integer>> to;
    private int[] inDeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        to = new ArrayList<List<Integer>>();
        this.n = numCourses;
        inDeg = new int[n];
        // 建立出边数组
        for (int i = 0; i < n; i++) {
            to.add(new ArrayList<Integer>());
        }
        for (int[] pre : prerequisites) {
            int ai = pre[0];
            int bi = pre[1];
            addEdge(bi, ai);
        }
        // 拓扑排序
        // 第一步，从零入度点出发
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        int[] lessons = new int[n];
        int m = 0;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            lessons[m] = x;
            m++;
            // 第二步，每扩展一个点，将周围的点的入度减一
            for (int y : to.get(x)) {
                inDeg[y]--;
                // 第三步，当点的入度为零，就可以将点入队了
                if (inDeg[y] == 0) {
                    queue.add(y);
                }
            }
        }
        // 记录出队次数，等于课程数说明能够学完，返回课程顺序数组
        if (m == n) return lessons;
        // 无法完成时返回空数组
        return new int[0];
    }

    void addEdge(int x, int y) {
        to.get(x).add(y);
        inDeg[y]++;
    }
}