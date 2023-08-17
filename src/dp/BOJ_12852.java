package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12852 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] cnt = new int[n+1];
        int[] value = new int[n+1];
        cnt[1]=1;
        //이제 해당 인덱스 까지 계속 돌아가..

        for (int i = 2; i <= n; i++) {
            cnt[i]=cnt[i-1]+1;
            value[i]=i-1;

            if (i % 3 == 0 && cnt[i] > cnt[i / 3] + 1) { //지금 현재에서 나눠지는 것임...
                cnt[i]=cnt[i/3]+1;
                value[i]=i/3;

            }
            if (i % 2 == 0 && cnt[i] > cnt[i / 2] + 1) {
                cnt[i]=cnt[i/2]+1;
                value[i]=i/2;

            }
        }

        System.out.println(cnt[n]);

        int index = n;
        String str = "";
        while (index > 0) {
            str+=value[index]+" ";
            index= value[index];

        }
        System.out.println(str);


    }


}
