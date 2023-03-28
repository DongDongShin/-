package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 칸토어_집합 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            int n = Integer.parseInt(str);
            sb = new StringBuilder();

            n = (int)Math.pow(3, n);
            for(int i=0;i<n;i++)
                sb.append('-');


            MakeSet(0,n);
            System.out.println(sb.toString());
        }

    }
    public static void MakeSet(int start, int size) {
        if(size==1){
            return;
        }
        //새로운 인덱스를 구해야함...
        int NewSize = size/3;
        for(int i=start+NewSize;i<start+(2*NewSize);i++){
            sb.setCharAt(i,' ');
        }
        MakeSet(start,NewSize);
        MakeSet(start+(2*NewSize),NewSize);


    }
}
