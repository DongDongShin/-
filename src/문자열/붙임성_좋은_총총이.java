package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 붙임성_좋은_총총이 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        Set<String> dancePeople = new HashSet<>();
        dancePeople.add("ChongChong");
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String str1= st.nextToken();
            String str2 = st.nextToken();
            if (dancePeople.contains(str1)) {
                dancePeople.add(str2);
            }
            else if (dancePeople.contains(str2)) {
                dancePeople.add(str1);
            }
            else
                continue;
        }
        System.out.println(dancePeople.size());

    }
}
