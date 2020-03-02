package offeragain;

public class String2Int {
    public static int strToInt(String str) {

        if (str == null || "".equals(str)){
            return 0;
        }

        str = str.trim();
        boolean flag = true;
        int start = 0;

        if (str.startsWith("-")) {
            flag = false;
            start = 1;
        }else if(str.startsWith("+")){
            flag = true;
            start = 1;
        }

        long res = 0;
        for (int i=start;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9'){
                int value = ch - '0';
                // 保证不溢出
                // 负数极值的绝对值比正数大1 {-2147483648, 2147483647}
                // 正数溢出肯定 >= 2147483648, 对应的负数刚好边界值或也溢出, 都拉回边界值
                if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && value > Integer.MAX_VALUE - (Integer.MAX_VALUE / 10) * 10 )){
                    if(flag){
                        return Integer.MAX_VALUE;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
                res = res * 10 + value;
            }else {
                break;
            }
        }

        if (!flag){
            res = -res;
        }

        return (int) res;
    }


    public static void main(String[] args) {

        System.out.println(strToInt("-2147483648"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
