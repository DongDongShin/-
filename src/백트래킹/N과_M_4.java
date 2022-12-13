package 백트래킹;


import java.util.Scanner;

public class N과_M_4 {
    public static int N,M;
    public static  int[] arr;
    public static StringBuilder sb;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();


        N = sc.nextInt();//depth
        M = sc.nextInt();//size

        arr = new int[M];
        bt(1,0);
        System.out.println(sb);

    }
    public static void bt(int n,int depth){
        if(depth==M){
            for (int i : arr) {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i =n;i<=N;i++){
                arr[depth]=i;
                bt(i,depth+1);
            }
        }
    }
}
