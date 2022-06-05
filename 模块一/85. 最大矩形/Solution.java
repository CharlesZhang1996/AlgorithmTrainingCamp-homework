class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int ans = 0;
        int[] heights = new int[n];
        for (int row = 0; row < m; row++) {
            // 对每一行，生成柱状图的heights数组，只要遇到0，之前累计的值就无效，归零
            for(int col = 0; col < n; col++) {
                if (matrix[row][col] == '0') {
                    heights[col] = 0;
                } else {
                    heights[col]++;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    // 计算每一行的柱状图
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Rectangle> stack = new Stack<Rectangle>();
        for (int height : heights) {
            int width = 0;
            while (!stack.isEmpty() && stack.peek().height >= height) {
                Rectangle a = stack.pop();
                width += a.width;
                ans = Math.max(ans, a.height * width);
            }
            stack.push(new Rectangle(height, width + 1));
        }
        int width = 0;
        while(!stack.isEmpty()) {
            Rectangle a = stack.pop();
            width += a.width;
            ans = Math.max(ans, a.height * width);

        }
        return ans;
    }

    class Rectangle {
        public int height;
        public int width;

        public Rectangle(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }
}