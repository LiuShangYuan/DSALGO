package offer;

import java.util.*;

// 字符串的全排列
// abc   对字符串进行N遍扫描每次选择一个没访问过最小的字符
public class PermutationString {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if(str == null || str.length()==0){
            return arrayList;
        }

        char[] chars = str.toCharArray();
        // 排序
        Arrays.sort(chars);
        char[] temp = new char[chars.length];
        // 使用LinkedHashSet可以保证插入的顺序
        Set<String> set = new LinkedHashSet<>();
        boolean[] visited = new boolean[chars.length];

        help(0, chars, temp, set, visited);
        arrayList.addAll(set);
        return arrayList;
    }


    // dfs
    public void help(int index, char[] str, char[] temp, Set<String> set, boolean[] visited) {
        // 匹配完了
        if (index == str.length) {
            set.add(new String(temp)); //添加到集合
            return;
        }

        for (int i = 0; i < str.length; i++) {
            if(!visited[i]){
                temp[index] = str[i]; // 可以进行排列
                visited[i] = true;
                help(index+1, str, temp, set, visited);
                visited[i] = false;
            }
        }
    }
}
