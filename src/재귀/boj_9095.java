package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9095 {


    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            ans =0;
            int num = Integer.parseInt(br.readLine());
            plus(num,1);
            plus(num,2);
            plus(num,3);

            System.out.println(ans);

        }


    }

    public static void plus(int n,int number) {
        if (n == number) {
            ans++;
            return;
        }
        if (n < number) {
            return;
        }
        else{
            plus(n,number+1);
            plus(n,number+2);
            plus(n,number+3);
        }



    }
}
