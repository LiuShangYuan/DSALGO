package offer;

/**
 * 3. 数组中重读的数字
 * <p>
 * 0 ~ n-1 之间的数字(重点)
 */
public class Q3 {
    public static void main(String[] args) {
        int[] array = {2,3,1,0,2,5,3};
        int[] d = new int[1];
        System.out.println(new Q3().duplicate(array, array.length, d));
        System.out.println(d[0]);
    }


    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            if (i == numbers[i]) {
                continue;
            }else{
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    int t = numbers[i];
                    numbers[i] = numbers[t];
                    numbers[t] = t;
                }
            }
        }
        return false;
    }
}
