package map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자_고르기2 {


    static Map<Integer, Integer> map ;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int key =0;
        map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                sb.append(map.get(key) + " ");
            }
            else{
                sb.append(0 + " ");

            }

        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
