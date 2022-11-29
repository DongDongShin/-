package 재귀;

import java.util.Scanner;

public class 재귀의_귀재 {
    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    static int cnt = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count =0;
        count= sc.nextInt();
        for (int i = 0; i < count; i++) {
            String str = sc.next();//새로운 문자를받고 재귀를 시작
            cnt=0;//숫자를 초기화를 합시다요
            System.out.println(isPalindrome(str)+" "+cnt);

        }
    }
}