package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
    static int[] inputs;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            if(size==0) break;//0을 입력을 하면 프로그램을 종료함
            inputs = new int[size];
            visited = new boolean[size];
            for (int i = 0; i < size; i++) {
                inputs[i] = Integer.parseInt(st.nextToken());
            }
            backtracking(0,0,"");
            System.out.println();

        }

    }

    public static void backtracking(int idx,int depth,String str){
        if(depth == 6){
            System.out.println(str.trim());
            return;
        }
        for (int i = idx; i < inputs.length; i++) {
                backtracking(i+1,depth+1,str+" "+inputs[i]);

        }
    }
}
