package offer;

import org.junit.Test;

// 字符流中第一个出现一次的字符
public class FirstAppearingOnceCharInStringStream {

    // 用整型数组代替哈希表
    int[] hash = new int[256];
    StringBuffer buffer = new StringBuffer();


    public void Insert(char ch) {
        buffer.append(ch);
        hash[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i=0;i<buffer.length();i++){
            if(hash[buffer.charAt(i)] == 1){
                return buffer.charAt(i);
            }
        }
        return '#';
    }


    @Test
    public void test(){
        FirstAppearingOnceCharInStringStream obj = new FirstAppearingOnceCharInStringStream();

        obj.Insert('g');
        System.out.println(obj.FirstAppearingOnce());
        obj.Insert('o');
        System.out.println(obj.FirstAppearingOnce());
        obj.Insert('o');
        System.out.println(obj.FirstAppearingOnce());
        obj.Insert('g');
        System.out.println(obj.FirstAppearingOnce());
        obj.Insert('l');
        System.out.println(obj.FirstAppearingOnce());
        obj.Insert('e');
        System.out.println(obj.FirstAppearingOnce());
    }
}
