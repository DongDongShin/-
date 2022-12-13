package 백트래킹;

import java.util.Scanner;

public class N과_M_2 {


    public static int arr[];
    public static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        M= sc.nextInt();
        arr = new int[M];//배열을 선언해서 이러쿵 저러쿵

        bt(1,0);
    }

    public static void bt(int at, int depth){//시작점, 깊이
        if(depth == M){
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for (int i=at; i <=N; i++) {
            arr[depth]=i;
            bt(i+1,depth+1);

        }

    }



}
