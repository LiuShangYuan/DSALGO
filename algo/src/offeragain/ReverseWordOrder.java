package offeragain;

public class ReverseWordOrder {
    /***
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     *
     * eulb si yks eht
     *
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder(s);
        String[] tmp = builder.reverse().toString().split(" ");
        StringBuilder builderres = new StringBuilder();

        for (String str:tmp){
            if(!"".equals(str)) {
                builderres.append(new StringBuilder(str).reverse().toString());
                builderres.append(" ");
            }
        }
        return builderres.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }
}
