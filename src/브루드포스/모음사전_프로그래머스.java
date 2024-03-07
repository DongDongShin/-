package 브루드포스;

import java.util.ArrayList;

public class 모음사전_프로그래머스 {
    public static void main(String[] args) {

        System.out.println(solution("AAAAE"));

    }

    static char[] arr ;
    static ArrayList<String> list = new ArrayList<>();

    public static int solution(String word) {
        arr = new char[]{'A', 'E', 'I', 'O', 'U'};
        //완전 탐색.. 모든 경우의 수를 돌리고 거기서 특정 경우를 탐색.

        dfs("");

        System.out.println(list.indexOf(word)+1);

        return list.indexOf(word)+1;


    }

    public static void dfs(String str){
        if (str.length() == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            list.add(str+arr[i]);
            dfs(str+arr[i]);

        }

    }
}
