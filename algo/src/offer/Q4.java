package offer;

/**
 * 4. 二维数组中的查找
 *
 * 从数组的右上角开始查找
 */
public class Q4 {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(new Q4().Find(5, array));
    }

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int j = array[0].length - 1;
        int i = 0;

        while (j >= 0 && i < array.length) {
            if (array[i][j] == target) {
                return true;
            }

            if (array[i][j] > target) {
                j--;
                continue;
            }

            if (array[i][j] < target) {
                i++;
                continue;
            }
        }


        return false;
    }
}
