package 자료구조;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class 문자열_집합 {

    static Map<String,Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt=0;
        map = new HashMap<>();


        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), 0);//없으며은 0을 return하고 그게 아니면 있는 값을
        }
        //
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            if (map.containsKey(key)) {
                cnt++;

            }

        }
        System.out.println(cnt);






    }
}
