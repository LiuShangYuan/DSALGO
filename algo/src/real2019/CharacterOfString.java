package real2019;

import java.util.Scanner;

public class CharacterOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()){
            System.out.println(characterOfStr(scanner.nextLine().trim()));
        }
    }




    // abcqweracb
    //
    public static String characterOfStr(String s){
        StringBuilder builder = new StringBuilder();

        int[] hash = new int[256];

        for (int i=0;i<s.length();i++){
            if (hash[s.charAt(i)] == 0){
                hash[s.charAt(i)] = 1;
            }
        }

        for (int i=0;i<s.length();i++){
            if (hash[s.charAt(i)] != 0){
                builder.append(s.charAt(i));
                hash[s.charAt(i)] = 0;
            }
        }

        return builder.toString();
    }
}
