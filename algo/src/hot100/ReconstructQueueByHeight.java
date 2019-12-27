package hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * User: yinkai
 * Date: 2019-12-27
 * Time: 19:59
 */

// 406. 根据身高重建队列

public class ReconstructQueueByHeight {


    @Test
    public void test() {
//        int[][] peopel = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] peopel = {{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}};

        int[][] res = reconstructQueue(peopel);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }


    }

    public int[][] reconstructQueue(int[][] people) {
        boolean[] visited = new boolean[people.length];

        for (int k = 0; k < people.length; k++) {
            int minh = Integer.MAX_VALUE;
            int minIdx = -1;


            // 找到最低
            for (int i = 0; i < people.length; i++) {
                if (!visited[i] && people[i][0] < minh) {
                    minh = people[i][0];
                    minIdx = i;
                }
            }

            // 放置最低
            int count = 0;
            for (int i = 0; i < people.length; i++) {
                if (visited[i] == false) {
                    if (count == people[minIdx][1]) {
                        int[] tmp = people[i];
                        people[i] = people[minIdx];
                        people[minIdx] = tmp;
                        visited[i] = true;
                        break;
                    }
                    count++;
                } else {
                    if (people[minIdx][0] <= people[i][0]) {
                        count++;
                    }
                }
            }

        }

        return people;

    }


}
