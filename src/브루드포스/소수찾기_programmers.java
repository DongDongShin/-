package 브루드포스;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_programmers {

    static boolean[] visited;
    static int[] arr;
    static Set<Integer> set;
    static int cnt =0;
    public static void main(String[] args) {
        solution("011");
    }

    public static void recur(int depth,int r,String str) {
        if (depth == r) {
            set.add(Integer.valueOf(str));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i]= true;
                recur(depth+1,r,str+arr[i]);
                visited[i] = false;
            }
        }
    }

    public static int solution(String numbers) {
        arr = new int[numbers.length()];
        set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers.charAt(i)-48;
        }
        for (int i = 1; i <= arr.length; i++) {
            visited = new boolean[arr.length];
            recur(0,i,"");
        }
        for (Integer n : set) {
            if(isPrime(n)) cnt+=1;
        }
        System.out.println(set);
        System.out.println(cnt);
        return -1;
    }

    public static boolean isPrime(int n) {
        if(n==1||n==0) return false;
        if(n==2) return true;
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
