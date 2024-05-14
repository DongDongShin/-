package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수강신청 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new LinkedHashMap<>();//중복이 되면 더해주지 않고
        for (int i = 0; i < L; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) {
                map.remove(input);
                map.put(input, map.getOrDefault(input, 0) + 1);
            } else
                map.put(input, map.getOrDefault(input, 0) + 1);
        }

        Iterator<String> it = map.keySet().iterator();
        int size=0;
        while (it.hasNext()) {
            if(size==K) break;
            else System.out.println(it.next());
            size++;
        }

    }
}
