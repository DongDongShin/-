package 브루드포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든순열 {
    static boolean[] visited;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        visited = new boolean[size+1];
        bf(0,"");
    }

    public static void bf(int depth,String str){
        if(depth==size){
            System.out.println(str);
            return;
        }
        for(int i =1;i<=size;i++){
            if(!visited[i]){
                visited[i]= true;
                bf(depth+1,str+i+" ");
                visited[i]= false;
            }
        }
    }
}
