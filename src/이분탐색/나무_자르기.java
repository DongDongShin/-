package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < tree.length; i++) {

            tree[i] = Integer.parseInt(st.nextToken());//일단 나무들을 초기화
        }
        Arrays.sort(tree);

        int start =0;
        int end = tree[tree.length - 1];
        int answer=0;

        while(start<=end){
            long length=0;
            int mid = (start+end)/2;
            for (int i = 0; i < tree.length; i++) {
                if(tree[i]<=mid){//작거나 같으면 안잘리는 거임
                    continue;
                }
                length+=tree[i]-mid;//잘린 부분을 이제 가져 가는 거지.
            }

            if (length<m) {//작은 거니깐 더 많은 나무를 잘라야겠지 h를 낮혀
                end = mid-1;
            }
            else{//혹은 일단 더 큰 나무가 짤렸으니 높이를 더 높여도 궨차나.. 계속 진행해
                start = mid +1;
                answer = mid;
            }
        }
        System.out.println(answer);







    }
}
