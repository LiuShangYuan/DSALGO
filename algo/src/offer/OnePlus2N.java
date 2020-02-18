package offer;
// 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
public class OnePlus2N {
    public int Sum_Solution(int n) {
        int sum = n;
        // 如果 n 大于0 继续算后半部分
        boolean t = (n > 0) && (sum += Sum_Solution(n-1))>0;
        return sum;
    }
}
