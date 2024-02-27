package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 주식 {
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            size = Integer.parseInt(br.readLine());
            long[] arr = new long[size];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(greedy(arr));

            //다음 날의 주식을 보고 지금 시세보다 큰게 있으면 매수를 함.
        }
    }

    public static long greedy(long[] arr) { //역방향으로 생각하는 거를 어떻게 하는 것인가...?
        long max = -1;
        //마지막 날 주식은 팔지를 못하니깐. max용 밖에 안됨
        long answer = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (max < arr[i]) {//최대 시세를 갱신함
                max = arr[i];
            } else {
                answer += (max - arr[i]);
            }
        }
        return answer;
    }
}
