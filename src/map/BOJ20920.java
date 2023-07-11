package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ20920 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String key = br.readLine();
            if (key.length() < M) continue;
            ;
            map.put(key, map.getOrDefault(key, 0) + 1);//처음에는 없으면..일단 0에서 +1
        }
        List<String> list = map.keySet().stream().collect(Collectors.toList()); //처음보는 것 입니다..


        //많이 등장하는 수, 더 긴수 사전 순
        list.sort((o1, o2) -> {
            int c1 = map.get(o1);
            int c2 = map.get(o2);
            if (c1 == c2) {//등장하는 횟 수가 같을때에는

                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o2.length()-o1.length();

            }
            return c2 - c1;

        });
        StringBuilder sb = new StringBuilder();
        for(String temp:list){
            sb.append(temp+"\n");
        }
        System.out.println(sb.toString());


    }
}
