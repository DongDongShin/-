package 백트래킹;

import java.util.Scanner;



public class N과_M_3 {
    public static int arr[];
    public static StringBuilder sb;
    public static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        M= sc.nextInt();
        N = sc.nextInt();
        arr= new int[N];
        bt(0);
        System.out.println(sb);
    }
    public static void bt(int depth){

        if(depth==N){
            for (int i : arr) {
               sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        else{
            for(int i =1;i<=M;i++){
                arr[depth]=i;
                bt(depth+1);
            }
        }
    }
}
