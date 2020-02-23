package real2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 图的遍历

// 改成dfs (除了最长的路径, 其他路径都走两边)
public class MapVisit {
    public static int solution(int[][] matrix, int n) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        return help(matrix, n, 0, visited);
    }

    public static int help(int[][] matrix, int n, int node, boolean[] visited) {
        int maxV = 0;
        boolean init = true;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (i == node || visited[i])
                continue;
            // 有边
            if (matrix[node][i] == 1) {
                visited[i] = true;
                int res = 1 + help(matrix, n, i, visited);
                if (init) {
                    maxV = res;
                } else {
                    if (res > maxV) {
                        maxV = res;
                    }
                }
                pre += res;
            }
        }
        return 2 * pre - maxV;
    }


    public static int bfs(int[][] matrix, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // 第一个节点

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> tmp = new LinkedList<>();
        int deep = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 当前访问节点

            for (int i = 0; i < n; i++) {
                if (node != i && !visited[i] && matrix[node][i] == 1){
                    tmp.add(i);
                    visited[i] = true;
                }
            }

            if (queue.isEmpty()){
                Queue<Integer> t = queue;
                queue = tmp;
                tmp = t;
                tmp.clear();
                deep++;
            }
        }

        return 2 * (n-1) -deep + 1;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[a - 1][b - 1] = 1;
            matrix[b - 1][a - 1] = 1;
        }

        System.out.println(bfs(matrix, n));
    }
}
