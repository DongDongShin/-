package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {


    static long[] Lan;
    static  int k;
    static int n;
    static long answer =0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         k = Integer.parseInt(st.nextToken());
         n = Integer.parseInt(st.nextToken());//만들어 내야 할 랜선의 갯수
        long max = Integer.MIN_VALUE;
        Lan = new long[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            Lan[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, Lan[i]);//일단 최대를 가져감
        }
        int min =1;
        cut_Lan(min, max);
        System.out.println(answer);

    }

    public static void cut_Lan(long min,long max) {
        while (min <= max) {
            long total_cnt =0;

            long mid = (max+min)/2;//처음의 mid 기준
            for (long length : Lan) {
                total_cnt += length/mid;//몫을 저장해 주는 거임.
            }

            //이제 부터 다시 생각 만약 기준점 보다 더 작다면. 자르는 길이를 줄여야 하고
            //그게 아니라면 더 많으니 좀만 더 올려치기를 해볼까 하는 나쁜생각을 하는거지
            if (total_cnt < n) {
                max = mid-1;
            }
            else{//그게 아니라면 좀만 더 높여보자
                min = mid+1;
                answer = mid;

            }

        }



    }
}
