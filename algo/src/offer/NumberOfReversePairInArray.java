package offer;

import org.junit.Test;

//数组中的逆序对
public class NumberOfReversePairInArray {
    public int InversePairs(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        return merge(array, 0, array.length -1);
    }

    // 1 2 3 4 5 6 7 0
    // 1 2 3 4 || 5 6 7 0
    // 1 2 || 3 4    ||||   5 6 || 7 0
    // 1 || 2   |||| 3  || 4   =====   5 || 6  |||| 7|| 0
    // l=0 r=0       l=0 r=0           l=0 r=0      l=0 r=0
    // [1]和[2]        [3]和[4]         [5]和[6]     [7]和[0]
    // return 0       return 0         return 0      return 1
    // l = 0          r = 0             l = 0        r = 1
    // [1 2] 和 [3 4] = 0                   [5 6]和[0 7] => 2
    // return 0                           return 3
    // left = 0                             right = 3
    // [1 2 3 4]      和    [0 5 6 7]  ====>   4
    //  return 7
    public int merge(int[] array, int start, int end) {
        // 只有一个元素，不会存在逆序对
        if (start == end) {
            return 0;
        }

        // 分别计算单独左边和右边的逆序对
        int mid = (start + end) / 2;
        int lnum = merge(array, start, mid);
        int rnum = merge(array, mid + 1, end);


        // 计算 left和right之间的逆序对
        //
        // [left ~ mid ]  && [mid+1 ~ end]
        //          p                  q
        int p = mid;
        int q = end;
        int num = 0;

        int[] tmparr = new int[end - start + 1];
        int index = tmparr.length - 1;
        while (p >= start && q > mid) {
            if (array[p] > array[q]) {
                tmparr[index--] = array[p--];
                num += (q - mid);
                if(num > 1000000007){
                    num %= 1000000007;
                }
            } else {
                tmparr[index--] = array[q--];
            }
        }
        // 剩余元素
        while (p >= start) {
            tmparr[index--] = array[p--];
        }

        while (q >= mid + 1) {
            tmparr[index--] = array[q--];
        }


        // 复制到原数组的相应位置

        for (int i=start,j=0;i<=end;i++,j++){
            array[i] = tmparr[j];
        }


        return (lnum + rnum + num) % 1000000007;

    }



    @Test
    public void test(){

        int[] arr = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        System.out.println(InversePairs(arr));
    }
}
