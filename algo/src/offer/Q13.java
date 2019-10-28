package offer;

/**
 * 机器人的运动范围
 * 回溯
 */
public class Q13 {
    public static void main(String[] args) {
        System.out.println(new Q13().movingCount(5, 10, 10));
    }

    // r, c坐标  rows, columns 行数和列数
    boolean checkout_pos(int r, int c, int rows, int columns, int threshold, int[] visited) {
        if (r < rows && r >= 0 && c < columns && c >= 0 && visited[r * columns + c] != 1) {
            int sum = 0;
            while (r != 0) {
                sum += r % 10;
                r = r / 10;
            }

            while (c != 0) {
                sum += c % 10;
                c = c / 10;
            }

            return sum <= threshold;
        }

        return false;
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (cols < 0 || rows <= 0 || threshold <= 0) {
            return 0;
        }
        int[] visited = new int[rows * cols]; // 初始化数组, 记录每个位置是否访问过

        return movingcount(0, 0, rows, cols, threshold, visited);
    }

    // 从指定坐标开始可以访问的位置数
    public int movingcount(int r, int c, int rows, int columns, int threshold, int[] visited) {
        if (checkout_pos(r, c, rows, columns, threshold, visited)) {
            visited[r * columns + c] = 1;
            return 1 + movingcount(r, c - 1, rows, columns, threshold, visited)
                    + movingcount(r, c + 1, rows, columns, threshold, visited)
                    + movingcount(r - 1, c, rows, columns, threshold, visited)
                    + movingcount(r + 1, c, rows, columns, threshold, visited);
        }
        return 0;
    }
}
